package com.example.instagrambackend.model.response;

import com.example.instagrambackend.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUserResponse {
    private String username;
    private String firstname;
    private String lastname;
    private String mobileNo;
    private String email;

    public AppUserResponse(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.mobileNo = user.getMobileNo();
    }
}
