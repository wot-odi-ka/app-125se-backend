package com.id.latihan.latihanspring.controller;

import com.id.latihan.latihanspring.exception.TokenRefreshException;
import com.id.latihan.latihanspring.model.RefreshToken;
import com.id.latihan.latihanspring.model.User;
import com.id.latihan.latihanspring.payload.request.LogOutRequest;
import com.id.latihan.latihanspring.payload.request.LoginRequest;
import com.id.latihan.latihanspring.payload.request.SignupRequest;
import com.id.latihan.latihanspring.payload.request.TokenRefreshRequest;
import com.id.latihan.latihanspring.payload.response.JwtResponse;
import com.id.latihan.latihanspring.payload.response.MessageResponse;
import com.id.latihan.latihanspring.payload.response.TokenRefreshResponse;
import com.id.latihan.latihanspring.repository.RoleRepository;
import com.id.latihan.latihanspring.repository.UserRepository;
import com.id.latihan.latihanspring.security.jwt.JwtUtils;
import com.id.latihan.latihanspring.security.services.RefreshTokenService;
import com.id.latihan.latihanspring.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  RefreshTokenService refreshTokenService;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    String jwt = jwtUtils.generateJwtToken(userDetails);

    // List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
    //     .collect(Collectors.toList());

    RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

    return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
        userDetails.getUsername(), userDetails.getEmail()));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
        encoder.encode(signUpRequest.getPassword()));

    // Set<String> strRoles = signUpRequest.getRole();
    // Role roles1 = new Role();
    // Set<Role> roles = new HashSet<>();

    // if (strRoles == null) {
    //   Role userRole = roleRepository.findByName(ERole.ROLE_USER)
    //       .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    //   roles.add(userRole);
    // } else {
    //   strRoles.forEach(role -> {
    //     switch (role) {
    //     case "admin":
    //       Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
    //           .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    //       roles.add(adminRole);

    //       break;
    //     case "mod":
    //       Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
    //           .orElseThrow(() ->
    //                   new RuntimeException("Error: Role is not found."));
    //       System.out.println(modRole);
    //       roles.add(modRole);

    //       break;
    //     default:
    //       Role userRole = roleRepository.findByName(ERole.ROLE_USER)
    //           .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    //       roles.add(userRole);
    //     }
    //   });
    // }

    // user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

  @PostMapping("/refreshtoken")
  public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
    String requestRefreshToken = request.getRefreshToken();

    return refreshTokenService.findByToken(requestRefreshToken)
        .map(refreshTokenService::verifyExpiration)
        .map(RefreshToken::getUser)
        .map(user -> {
          String token = jwtUtils.generateTokenFromUsername(((User) user).getUsername());
          return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
        })
        .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
            "Refresh token is not in database!"));
  }
  
  @PostMapping("/logout")
  public ResponseEntity<?> logoutUser(@Valid @RequestBody LogOutRequest logOutRequest) {
    refreshTokenService.deleteByUserId(logOutRequest.getUserId());
    return ResponseEntity.ok(new MessageResponse("Log out successful!"));
  }

}
