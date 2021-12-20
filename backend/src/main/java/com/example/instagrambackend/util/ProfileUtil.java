package com.example.instagrambackend.util;

import com.example.instagrambackend.model.entity.User;
import com.example.instagrambackend.repository.UserDetailRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ProfileUtil {
    private UserDetailRepository userDetailRepository;

    public User getUserFromUserName(String username) throws Exception {
        System.out.println("Which is null username " + username);
        System.out.println("Or repos " + (userDetailRepository == null));
        Optional<User> userOptional = userDetailRepository.findByUsername(username);
        if (userOptional.isEmpty()) throw new Exception("User Not Present");
        return userOptional.get();
    }
}
