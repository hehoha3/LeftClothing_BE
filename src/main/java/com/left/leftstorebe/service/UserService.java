package com.left.leftstorebe.service;

import com.left.leftstorebe.model.dto.SignInRequest;
import com.left.leftstorebe.model.dto.SignUpRequest;
import com.left.leftstorebe.model.entiti.user.JwtResponse;
import com.left.leftstorebe.model.entiti.user.Role;
import com.left.leftstorebe.model.entiti.user.User;
import com.left.leftstorebe.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public JwtResponse signUp(SignUpRequest request) {
        var newUser = User
                .builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .address(request.getAddress())
                .role(Role.ROLE_USER)
                .build();
        userRepo.save(newUser);
        var jwtToken = jwtService.generateToken(newUser);
        return JwtResponse
                .builder()
                .jwtToken(jwtToken)
                .build();
    }

    public JwtResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepo.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return JwtResponse
                .builder()
                .jwtToken(jwtToken)
                .build();
    }

    public List<User> getListUser() {
        return userRepo.findAll();
    }

    public User getUserByToken(String token) {
        String username = jwtService.extractUsername(token);
        return userRepo.findAllByUsername(username);
    }
}
