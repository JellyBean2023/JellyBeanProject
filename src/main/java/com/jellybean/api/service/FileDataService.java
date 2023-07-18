package com.jellybean.api.service;

import com.jellybean.api.entity.FileData;
import com.jellybean.api.repository.FileDataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileDataService {

    private final FileDataRepository fileDataRepository;
    private final String FOLDER_PATH = "C:\\files";

    private final FilesService filesService;

    @Transactional
    public String uploadImageToFileSystem(MultipartFile file) throws IOException{
        log.info("upload file: {}", file.getOriginalFilename());
//        String filePath = FOLDER_PATH + "\\" +file.getOriginalFilename();
        String filePath = FOLDER_PATH + "\\" + generateFileName() + getFileExtension(file.getOriginalFilename());
        String fileNewName = generateFileName() + getFileExtension(file.getOriginalFilename());
        fileDataRepository.save(
                FileData.builder()
                        .oriName(file.getOriginalFilename())
                        .name(fileNewName)
                        .type(file.getContentType())
                        .filePath(filePath)
                        .build()
        );

        file.transferTo(new File(filePath));

//        if(fileData != null){
//            return "file uploaded successfully! filePath : " + filePath;
//        }

        return null;
    }

    private String generateFileName(){
        long fileCount = filesService.getFileCount();
        String formattedCount = String.format("%03d", fileCount + 1);
        return "banners_image_" + formattedCount;
    }

    private String getFileExtension(String originalFilename){
        int lastDotIndex = originalFilename.lastIndexOf('.');
        if(lastDotIndex != -1){
            return originalFilename.substring(lastDotIndex);
        }
        return "";
    }


    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        FileData fileData = fileDataRepository.findByName(fileName)
                .orElseThrow(RuntimeException::new);

        String filePath = fileData.getFilePath();

        log.info("download fileData: {}", fileData);
        log.info("download filePath: {}", filePath);

        return Files.readAllBytes(new File(filePath).toPath());
    }


    public List<String> getAllImageNames(){
        List<FileData> fileDataList = fileDataRepository.findAll();
        List<String> imageNames = new ArrayList<>();

        for(FileData fileData : fileDataList){
            String imageName = fileData.getName();
            imageNames.add(imageName);
        }
        return imageNames;
    }


//    public Map<String, String> getAllImageMaps(){
//        List<FileData> fileDataList = fileDataRepository.findAll();
//        Map<String, String> imageMaps = new HashMap<>();
//
//        for(FileData fileData : fileDataList){
//            String id = String.valueOf(fileData.getId());
//            String imageName = fileData.getName();
//            imageMaps.put(id, imageName);
//        }
//        return imageMaps;
//    }

}
