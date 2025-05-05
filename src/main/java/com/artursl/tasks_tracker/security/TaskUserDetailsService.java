package com.artursl.tasks_tracker.security;

import com.artursl.tasks_tracker.domain.entities.User;
import com.artursl.tasks_tracker.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class TaskUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public TaskUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email:" + email));
        return new TaskUserDetails(user);
    }
}
