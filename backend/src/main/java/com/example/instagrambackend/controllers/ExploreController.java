package com.example.instagrambackend.controllers;

import com.example.instagrambackend.repository.PostRepository;
import com.example.instagrambackend.model.exception.GlobalException;
import com.example.instagrambackend.util.ProfileUtil;
import com.example.instagrambackend.util.ResponseUtil;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<?> getRandomPosts(Principal principal) throws GlobalException {
        return ResponseUtil.ok(repository.findAll20ByUser_UsernameNot(principal.getName()));
    }
}
