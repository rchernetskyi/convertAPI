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
import java.util.*;

@Service
public class ConversionService {
    private final HashMap<Set<String>, Convertor> convertors = new HashMap<>();

    {
        convertors.put(new HashSet<>(List.of("pdf")), new ConvertorPDF());
    }

    public File convert(File initialFile, String initialFormat, String finalFormat) {
        Convertor convertor = Optional.ofNullable(getConvertor(initialFormat)).orElseThrow(() -> new InvalidFormatException("initial"));

        return convertor.convertTo(initialFile, finalFormat);
    }

    private Convertor getConvertor(String initialFormat) {
        for (Set<String> set : convertors.keySet()) {
            if (set.contains(initialFormat)) return convertors.get(set);
        }

        return null;
    }


}
