# === STAGE 1: BUILD ===
FROM maven:3.9.9-eclipse-temurin-11 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml dan download dependency (cache step)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy seluruh source code
COPY src ./src

# Build project tanpa menjalankan test
RUN mvn clean package -DskipTests -Pproduction

# === STAGE 2: RUN ===
FROM eclipse-temurin:11-jdk
WORKDIR /app

# Copy hasil build dari stage 1
COPY --from=build /app/target/*.jar app.jar

# Expose port default Spring Boot
EXPOSE 8080

# Jalankan aplikasi
CMD ["java", "-jar", "app.jar"]
