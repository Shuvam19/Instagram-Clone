package com.example.instagrambackend.controllers;

import com.example.instagrambackend.model.LoginRequest;
import com.example.instagrambackend.model.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(List.of(
                loginRequest.getUsername(), loginRequest.getPassword()
        ));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpRequest signUpRequest) {
        // Check Username Exists
        // Check Email Or Phone Exists
        // TODO Password Validation
        // Create
        return ResponseEntity.ok(List.of(
                signUpRequest.getUsername(),
                signUpRequest.getPassword(),
                signUpRequest.getFullName(),
                signUpRequest.getEmailOrPhone()
        ));
    }
}
