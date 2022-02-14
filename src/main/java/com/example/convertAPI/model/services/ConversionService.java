package com.example.convertAPI.model.services;

import com.example.convertAPI.model.entity.convertors.Convertor;
import com.example.convertAPI.model.entity.convertors.ConvertorPDF;
import com.example.convertAPI.model.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Optional;

@Service
public class ConversionService {
    private final HashMap<String, Convertor> convertors = new HashMap<>();

    {
        convertors.put("pdf", new ConvertorPDF());
    }

    public File convert(File initialFile, String initialFormat, String finalFormat) {
        Convertor convertor = Optional.ofNullable(convertors.get(initialFormat)).orElseThrow(() -> new InvalidFormatException("initial"));

        return convertor.convertTo(initialFile, finalFormat);
    }
}
