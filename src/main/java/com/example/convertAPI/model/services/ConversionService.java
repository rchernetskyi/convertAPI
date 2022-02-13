package com.example.convertAPI.model.services;

import com.example.convertAPI.model.entity.Convertor;
import com.example.convertAPI.model.entity.ConvertorPDF;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Service
public class ConversionService {
    private final HashMap<String, Convertor> convertors = new HashMap<>();

    {
        convertors.put("pdf", new ConvertorPDF());
    }

    public File convert(MultipartFile multipartFile, String format) throws IOException {
        File initialFile = new File("C:\\Users\\romac\\Desktop\\Лаби\\convertAPI\\src\\main\\resources\\tmp\\file.tmp");
        multipartFile.transferTo(initialFile);

        String initialFormat = multipartFile.getOriginalFilename().replaceAll(".*\\.", "");

        Convertor convertor = convertors.get(initialFormat);

        return convertor.convertTo(initialFile, format);
    }
}
