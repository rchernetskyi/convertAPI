package com.example.convertAPI.model.services;

import com.example.convertAPI.model.entity.UserRequest;
import com.example.convertAPI.model.repository.UserRequestRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class UserRequestService {
    @Autowired
    private UserRequestRepository requestRepository;

    public void addUserRequest(File initialFile, File finalFile, String initialFormat, String finalFormat, HttpServletRequest request) {
        UserRequest userRequest;

        Date date = new Date();
        try {
            userRequest = new UserRequest(FileUtils.readFileToByteArray(initialFile), FileUtils.readFileToByteArray(finalFile),
                    initialFormat, finalFormat, date, date);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong");
        }
        requestRepository.save(userRequest);
    }
}
