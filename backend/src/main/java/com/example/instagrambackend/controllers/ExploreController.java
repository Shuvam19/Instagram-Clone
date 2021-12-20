package com.example.instagrambackend.controllers;

import com.example.instagrambackend.model.entity.User;
import com.example.instagrambackend.repository.PostRepository;
import com.example.instagrambackend.util.ProfileUtil;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/explore/")
public class ExploreController {

    PostRepository repository;
    ProfileUtil profileUtil;

    @GetMapping("/posts")
    public ResponseEntity<?> getRandomPosts(Principal principal) throws Exception {
        return ResponseEntity.ok(repository.findAll20ByUser_UsernameNot(principal.getName()));
    }
}
