package com.jellybean.api.service;

import com.jellybean.api.repository.FileDataRepository;
import org.springframework.stereotype.Service;

@Service
public class FilesService {

    private final FileDataRepository fileDataRepository;

    public FilesService(FileDataRepository fileDataRepository){
        this.fileDataRepository = fileDataRepository;
    }

    public long getFileCount(){
        return fileDataRepository.count();
    }

}
