package com.example.instagrambackend.model.response;

import com.example.instagrambackend.model.entity.Post;

import com.example.instagrambackend.model.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileResponse {
    private String username;
    private String firstname;
    private String lastname;
    private String mobileNo;
    private String email;

    private Integer noOfPost;
    private Long noOfFollowers;
    private Long noOfFollowing;
    private String imageUrl;

    private Boolean isFollowing;

    private Set<Post> postList;

    public ProfileResponse(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.mobileNo = user.getMobileNo();
    }

    public ProfileResponse(User user, Integer noOfPost, Long noOfFollowers, Long noOfFollowing, String imageUrl, Boolean isFollowing, Set<Post> postList) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.mobileNo = user.getMobileNo();
        this.noOfPost = noOfPost;
        this.noOfFollowers = noOfFollowers;
        this.noOfFollowing = noOfFollowing;
        this.imageUrl = imageUrl;
        this.isFollowing = isFollowing;
        this.postList = postList;
    }
}
