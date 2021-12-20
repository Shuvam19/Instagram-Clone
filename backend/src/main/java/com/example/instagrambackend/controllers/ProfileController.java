package com.example.instagrambackend.controllers;

import com.example.instagrambackend.model.entity.User;
import com.example.instagrambackend.model.response.ProfileResponse;
import com.example.instagrambackend.repository.PostRepository;
import com.example.instagrambackend.repository.UserDetailRepository;
import com.example.instagrambackend.util.ProfileUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class ProfileController {
    private UserDetailRepository userDetailRepository;
    private ProfileUtil profileUtil;
    private PostRepository repository;

    @GetMapping("/followingPosts")
    public ResponseEntity<?> getFollowingPost(Principal principal) throws Exception {
        User user = profileUtil.getUserFromUserName(principal.getName());
        return ResponseEntity.ok(repository.getAllPostOfFollowing(user.getId()));
    }

    @GetMapping(path = "/{user-id:[a-zA-Z0-9]+}")
    public ResponseEntity<?> getUserInfo(Principal principal, @PathVariable("user-id") String userID) throws Exception {
        User user = profileUtil.getUserFromUserName(userID);
        User principalUser = profileUtil.getUserFromUserName(principal.getName());
        long followersCount = userDetailRepository.getFollowersCount(user.getId());
        long followingCount = userDetailRepository.getFollowingCount(user.getId());
        Boolean isFollowing = userDetailRepository.isFollowing(user.getId(), principalUser.getId());
        return ResponseEntity.ok(new ProfileResponse(user, (int) (100 * Math.random()), followersCount, followingCount, "https://picsum.photos/150", isFollowing, user.getAllPosts()));
    }

    @GetMapping("/follow/{user-id}")
    public ResponseEntity<?> followUser(Principal principal, @PathVariable("user-id") String userID) throws Exception {
        User to = profileUtil.getUserFromUserName(principal.getName());
        User from = profileUtil.getUserFromUserName(userID);
        from.getFollowing().add(to);
        userDetailRepository.save(from);
        return ResponseEntity.ok("Done");
    }

    @GetMapping("/unfollow/{user-id}")
    public ResponseEntity<?> unfollowUser(Principal principal, @PathVariable("user-id") String userID) throws Exception {
        User to = profileUtil.getUserFromUserName(principal.getName());
        User from = profileUtil.getUserFromUserName(userID);
        from.getFollowing().remove(to);
        userDetailRepository.save(from);
        return ResponseEntity.ok("Done");
    }

    @GetMapping("/followers")
    public ResponseEntity<?> getAllFollowers(Principal principal) throws Exception {
        User user = profileUtil.getUserFromUserName(principal.getName());
        return ResponseEntity.ok(userDetailRepository.getAllFollowers(user.getId()));
    }

    @GetMapping("/following")
    public ResponseEntity<?> getAllFollowing(Principal principal) throws Exception {
        User user = profileUtil.getUserFromUserName(principal.getName());
        return ResponseEntity.ok(userDetailRepository.getAllFollowing(user.getId()));
    }
}
