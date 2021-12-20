package com.example.instagrambackend.repository;


import com.example.instagrambackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByMobileNo(String mobileNo);

    Boolean existsByUsernameNot(String username);

    @Query(value = "select * from follower_following f join user a on a.id=f.following_id where f.user_id=?1", nativeQuery = true)
    Collection<User> getAllFollowing(Long userId);

    @Query(value = "select * from follower_following f join user a on a.id=f.user_id where f.following_id=?1", nativeQuery = true)
    Collection<User> getAllFollowers(Long userId);

    @Query(value = "select count(*) from follower_following f  where f.following_id=?1", nativeQuery = true)
    Long getFollowingCount(Long userId);

    @Query(value = "select count(*) from follower_following f  where f.user_id=?1", nativeQuery = true)
    Long getFollowersCount(Long userId);

    @Query(value = "SELECT if(count(*)=0,'false','true') FROM follower_following f WHERE f.user_id=?1 AND f.following_id=?2", nativeQuery = true)
    Boolean isFollowing(Long user_id, Long follower_id);

}
