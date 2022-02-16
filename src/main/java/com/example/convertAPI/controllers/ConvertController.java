package com.example.convertAPI.controllers;

import com.example.convertAPI.model.entity.FinalFileEntity;
import com.example.convertAPI.model.services.ConversionService;
import com.example.convertAPI.model.services.FileEntitiesService;
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

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.util.List;

@RestController
public class ConvertController {
    @Autowired
    private ConversionService conversionService;

    @Autowired
    private FileEntitiesService fileEntitiesService;

    @PostMapping("/convert")
    public ResponseEntity<Resource> convert(@RequestParam("file") MultipartFile multipartFile
            , @RequestParam("format") String finalFormat, HttpServletRequest request) throws IOException {
        File initialFile = saveMultipartFile(multipartFile);
        String initialFormat = multipartFile.getOriginalFilename().replaceAll(".*\\.", "");

        File convertedFile = conversionService.convert(initialFile, initialFormat, finalFormat);

        fileEntitiesService.addFiles(initialFile, initialFormat, convertedFile, finalFormat);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(convertedFile));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + convertedFile.getName());

        String contentType = Files.probeContentType(convertedFile.toPath());

        List<String> a;


        return ResponseEntity.ok()
                .contentLength(convertedFile.length())
                .headers(headers)
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }

    private File saveMultipartFile(MultipartFile multipartFile) throws IOException {
        File initialFile = new File("C:\\Users\\romac\\Desktop\\Лаби\\convertAPI\\src\\main\\resources\\tmp\\file.tmp");

        try (OutputStream os = new FileOutputStream(initialFile)) {
            os.write(multipartFile.getBytes());
        }
        return initialFile;
    }
}
