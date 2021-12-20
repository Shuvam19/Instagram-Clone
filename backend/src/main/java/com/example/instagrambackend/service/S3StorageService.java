package com.example.instagrambackend.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class S3StorageService {
    private AmazonS3 amazonS3;

    public S3StorageService(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    @Value("${amazonProperties.bucketName}")
    private String bucketName;

    @Value("${amazonProperties.region}")
    private String region;

    public String uploadFile(String userId, MultipartFile multiPartFile) throws Exception {
        try {
            String path = getPathOfUser(userId);
            String fileName = generateFileName(multiPartFile);
            File convertedFile = convertMultiPartToFile(multiPartFile);
            uploadFileTos3bucket(path, fileName, convertedFile);
            convertedFile.delete();
            return createUrl(userId, fileName);
        } catch (IOException e) {
            throw new Exception("Some Error Occurred");
        }
    }

    private String createUrl(String userId, String fileName) {
        return String.format("https://%s.s3.%s.amazonaws.com/%s/%s", bucketName, region, userId, fileName);
    }

    private PutObjectResult uploadFileTos3bucket(String path, String fileName, File file) {
        return amazonS3.putObject(new PutObjectRequest(path, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    private String getPathOfUser(String userId) {
        return String.format("%s/%s", bucketName, userId);
    }

    private String generateFileName(MultipartFile multiPart) {
        return String.valueOf(new Date().getTime());
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
