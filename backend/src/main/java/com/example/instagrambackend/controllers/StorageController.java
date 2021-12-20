package com.example.instagrambackend.controllers;

import com.example.instagrambackend.model.response.FileUploadResponse;
import com.example.instagrambackend.service.S3StorageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/storage")
public class StorageController {
    S3StorageService storageService;

    @PostMapping("/upload")
    private ResponseEntity<?> uploadFile(
            Principal principal,
            @RequestParam("file") MultipartFile file
    ) throws Exception {
        String url = storageService.uploadFile(principal.getName(), file);
        return ResponseEntity.ok(new FileUploadResponse(url));
    }
}
