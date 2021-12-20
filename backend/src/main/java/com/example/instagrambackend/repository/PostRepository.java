package com.example.instagrambackend.repository;

import com.example.instagrambackend.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll20ByUser_UsernameNot(String username);

    @Query(value = "SELECT * from post p where p.user_id in (select user_id from follower_following f where f.following_id=?1)", nativeQuery = true)
    List<Post> getAllPostOfFollowing(Long uid);
}
