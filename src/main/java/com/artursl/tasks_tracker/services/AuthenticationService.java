package com.artursl.tasks_tracker.services;

import com.artursl.tasks_tracker.domain.dtos.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    UserDetails authenticate(String email, String password);
    String generateToken(UserDetails userDetails);
    UserDetails validateToken(String token);
    UserDetails register(RegistrationRequest request);

}
