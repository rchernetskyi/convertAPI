package com.example.convertAPI.model.services;

import com.example.convertAPI.model.entity.FinalFileEntity;
import com.example.convertAPI.model.entity.InitialFileEntity;
import com.example.convertAPI.model.repository.FinalFileEntityRepository;
import com.example.convertAPI.model.repository.InitialFileEntityRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;

@Service
public class FileEntitiesService {
    @Autowired
    private InitialFileEntityRepository initialFileEntityRepository;

    @Autowired
    private FinalFileEntityRepository finalFileEntityRepository;

    private InitialFileEntity addInitialFile(File initialFile, String initialFormat, FinalFileEntity finalFileEntity) {
        InitialFileEntity initialFileEntity;

        Date date = new Date();
        try {
            initialFileEntity = new InitialFileEntity(FileUtils.readFileToByteArray(initialFile), initialFormat, date, finalFileEntity);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong");
        }
        return initialFileEntityRepository.save(initialFileEntity);
    }

    private FinalFileEntity addFinalFile(File finalFile, String finalFormat) {
        FinalFileEntity finalFileEntity;

        Date date = new Date();
        try {
            finalFileEntity = new FinalFileEntity(FileUtils.readFileToByteArray(finalFile), finalFormat, date);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong");
        }
        return finalFileEntityRepository.save(finalFileEntity);
    }

    public void addFiles(File initialFile, String initialFormat, File finalFile, String finalFormat) {
        FinalFileEntity finalFileEntity = addFinalFile(finalFile, finalFormat);
        addInitialFile(initialFile, initialFormat, finalFileEntity);
    }
}
