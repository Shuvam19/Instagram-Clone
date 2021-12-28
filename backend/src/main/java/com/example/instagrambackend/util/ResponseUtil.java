package com.example.instagrambackend.util;

import com.example.instagrambackend.model.response.GlobalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static ResponseEntity<GlobalResponse> ok(Object data) {
        return new ResponseEntity<>(new GlobalResponse(false, "success", data), HttpStatus.OK);
    }

    public static ResponseEntity<GlobalResponse> bad(Exception exception) {
        return new ResponseEntity<>(new GlobalResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
    }
}
