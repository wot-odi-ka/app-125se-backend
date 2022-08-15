package com.id.latihan.latihanspring.repository;

import com.id.latihan.latihanspring.model.ERole;
import com.id.latihan.latihanspring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
