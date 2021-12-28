package com.example.instagrambackend.filters;

import com.example.instagrambackend.model.exception.GlobalException;
import com.example.instagrambackend.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {GlobalException.class})
    public ResponseEntity<?> bodyError(Exception exception) {
        return ResponseUtil.bad(exception);
    }

}
