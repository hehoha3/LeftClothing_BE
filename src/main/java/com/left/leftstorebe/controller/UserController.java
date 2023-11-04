package com.left.leftstorebe.controller;

import com.left.leftstorebe.model.dto.SignInRequest;
import com.left.leftstorebe.model.dto.SignUpRequest;
import com.left.leftstorebe.model.entiti.user.JwtResponse;
import com.left.leftstorebe.model.entiti.user.User;
import com.left.leftstorebe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private final UserService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> signup(
            @RequestBody SignUpRequest request
    ) {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtResponse> signIn(
            @RequestBody SignInRequest request
    ) {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUserList() {
        return new ResponseEntity<>(authenticationService.getListUser(), HttpStatus.OK);
    }

    @GetMapping("/who")
    public ResponseEntity<User> getUserByToken(
            @RequestParam("token") String token
    ) {
        return new ResponseEntity<>(authenticationService.getUserByToken(token), HttpStatus.OK);
    }
}