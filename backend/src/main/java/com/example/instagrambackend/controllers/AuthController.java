package com.example.instagrambackend.controllers;

import com.example.instagrambackend.model.entity.User;
import com.example.instagrambackend.model.entity.UserRole;
import com.example.instagrambackend.model.request.LoginRequest;
import com.example.instagrambackend.model.request.SignUpRequest;
import com.example.instagrambackend.model.response.LoginResponse;
import com.example.instagrambackend.model.response.ProfileResponse;
import com.example.instagrambackend.model.response.UserResponse;
import com.example.instagrambackend.repository.UserDetailRepository;
import com.example.instagrambackend.model.exception.GlobalException;
import com.example.instagrambackend.model.response.GlobalResponse;
import com.example.instagrambackend.util.JWTUtil;
import com.example.instagrambackend.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private UserDetailsService userDetailsService;
    private JWTUtil jwtUtil;
    private UserDetailRepository userDetailRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<GlobalResponse> loginUser(@RequestBody LoginRequest loginRequest) throws GlobalException {
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException exception) {
            throw new GlobalException("UserName Or Password Is Incorrect");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseUtil.ok(new LoginResponse(token));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpRequest signUpRequest) {

        if (signUpRequest.getUsername() == null) {
            throw new GlobalException("Please Enter Username");
        }

        // Check UserName Exists
        if (userDetailRepository.findByUsername(signUpRequest.getUsername()).isPresent()) {
            throw new GlobalException("Username Already Exists");
        }

        if (signUpRequest.getEmail() != null && !signUpRequest.getEmail().isEmpty()
                && userDetailRepository.findByEmail(signUpRequest.getEmail()).isPresent()) {
            throw new GlobalException("Email Already Exists");
        }

        if (signUpRequest.getMobileNo() != null && !signUpRequest.getMobileNo().equals("0")
                && userDetailRepository.findByMobileNo(signUpRequest.getMobileNo()).isPresent()) {
            throw new GlobalException("MobileNo Already Exists");
        }

        // Encode A Password
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());

        // Create A new User
        User newUser = new User(
                signUpRequest.getUsername(),
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                encodedPassword,
                signUpRequest.getMobileNo(),
                signUpRequest.getEmail(),
                UserRole.USER_ROLE
        );

        userDetailRepository.save(newUser);

        UserDetails userDetails = userDetailsService.loadUserByUsername(signUpRequest.getUsername());

        String token = jwtUtil.generateToken(userDetails);

        return ResponseUtil.ok(new LoginResponse(token));
    }

    @PostMapping("/user")
    public ResponseEntity<?> getUser(Principal principal) throws Exception {
        Optional<User> userOptional = userDetailRepository.findByUsername(principal.getName());
        if (userOptional.isEmpty()) throw new GlobalException("User Not Present");
        return ResponseUtil.ok(new UserResponse(
                new ProfileResponse(userOptional.get())
        ));
    }

    @GetMapping("/isValidUsername")
    public ResponseEntity<?> isUserNameValid(@RequestParam("username") String username) {
        return ResponseUtil.ok(userDetailRepository.existsByUsernameNot(username));
    }
}
