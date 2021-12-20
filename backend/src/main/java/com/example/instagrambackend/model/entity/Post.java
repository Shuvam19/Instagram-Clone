package com.example.instagrambackend.model.entity;

import com.example.instagrambackend.model.request.CreatePostRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String productUrl;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    User user;

    public Post(CreatePostRequest request) {
        this.productUrl = request.getProductUrl();
    }

    public Post(String url) {
        this.productUrl = url;
    }
}
