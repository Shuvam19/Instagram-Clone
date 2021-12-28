package com.example.instagrambackend.controllers;

import com.example.instagrambackend.model.response.FileUploadResponse;
import com.example.instagrambackend.service.S3StorageService;
import com.example.instagrambackend.model.exception.GlobalException;
import com.example.instagrambackend.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/storage")
public class StorageController {
    S3StorageService storageService;

    @PostMapping("/upload")
    private ResponseEntity<?> uploadFile(
            Principal principal,
            @RequestParam("file") MultipartFile file
    ) throws GlobalException {
        String url = storageService.uploadFile(principal.getName(), file);
        return ResponseUtil.ok(new FileUploadResponse(url));
    }
}
