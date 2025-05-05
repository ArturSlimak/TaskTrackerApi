package com.artursl.tasks_tracker.controllers;

import com.artursl.tasks_tracker.domain.dtos.AuthResponse;
import com.artursl.tasks_tracker.domain.dtos.LoginRequest;
import com.artursl.tasks_tracker.domain.dtos.RegistrationRequest;
import com.artursl.tasks_tracker.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/auth")
@Validated
public class AuthController {
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@Valid  @RequestBody LoginRequest loginRequest) {
        UserDetails userDetails = authenticationService.authenticate(loginRequest.email(), loginRequest.password());
        String token = authenticationService.generateToken(userDetails);
        return ResponseEntity.ok(
                new AuthResponse(token, 86400)
        );
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@Valid @RequestBody RegistrationRequest registrationRequest) {
        UserDetails user = authenticationService.register(registrationRequest);
        String token = authenticationService.generateToken(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("token", token));
    }
}
