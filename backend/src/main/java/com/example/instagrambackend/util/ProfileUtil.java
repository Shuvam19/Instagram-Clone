package com.example.instagrambackend.util;

import com.example.instagrambackend.model.exception.GlobalException;
import com.example.instagrambackend.model.entity.User;
import com.example.instagrambackend.repository.UserDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ProfileUtil {
    private UserDetailRepository userDetailRepository;

    public User getUserFromUserName(String username) throws GlobalException {
        Optional<User> userOptional = userDetailRepository.findByUsername(username);
        if (userOptional.isEmpty()) throw new GlobalException("User Not Present");
        return userOptional.get();
    }
}
