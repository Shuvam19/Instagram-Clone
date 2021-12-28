package com.example.instagrambackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GlobalResponse {
    private boolean error;
    private String message;
    private Object data;
}
