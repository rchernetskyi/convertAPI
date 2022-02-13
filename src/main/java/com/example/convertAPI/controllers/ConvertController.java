package com.example.convertAPI.controllers;

import com.example.convertAPI.model.services.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class ConvertController {
    @Autowired
    private ConversionService conversionService;

    @PostMapping("/convert")
    public ResponseEntity<Resource> convert(@RequestParam("file") MultipartFile multipartFile, @RequestParam("format") String format) throws IOException {
        File convertedFile = conversionService.convert(multipartFile, format);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(convertedFile));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + convertedFile.getName());

        String contentType = Files.probeContentType(convertedFile.toPath());

        return ResponseEntity.ok()
                .contentLength(convertedFile.length())
                .headers(headers)
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}
