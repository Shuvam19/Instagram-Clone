package com.example.instagrambackend.controllers;

import com.example.instagrambackend.model.entity.Post;
import com.example.instagrambackend.model.entity.User;
import com.example.instagrambackend.model.request.CreatePostRequest;
import com.example.instagrambackend.repository.PostRepository;
import com.example.instagrambackend.util.ProfileUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/create")
public class CreateController {

    private PostRepository repository;
    private ProfileUtil profileUtil;

    @PostMapping("/post")
    public ResponseEntity<?> postContent(Principal principal, @RequestBody CreatePostRequest createPostRequest) throws Exception {
        System.out.println(principal.getName());
        User user = profileUtil.getUserFromUserName(principal.getName());
        Post post = new Post(createPostRequest);
        post.setUser(user);
        repository.save(post);
        return ResponseEntity.ok("Post Create Successfully");
    }
}
