package com.jellybean.api.controller;

import com.jellybean.api.service.FileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fileSystem")
public class FileDataController {

    final private FileDataService storageService;


    @PostMapping("")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = storageService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable("fileName") String fileName) throws IOException {
        byte[] downloadImage = storageService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(downloadImage);
    }

    @GetMapping("/images")
    public ResponseEntity<List<String>> getAllImages() throws IOException {
        List<String> imagePaths = storageService.getAllImagePaths();
        return ResponseEntity.ok(imagePaths);
    }

}
