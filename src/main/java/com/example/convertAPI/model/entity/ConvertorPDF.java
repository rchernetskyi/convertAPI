package com.example.convertAPI.model.entity;

import com.aspose.pdf.Document;
import com.example.convertAPI.model.exceptions.InvalidFormatException;

import java.io.File;
import java.util.HashMap;
import java.util.Optional;

public class ConvertorPDF implements Convertor {

    private final HashMap<String, Integer> formats = new HashMap<>();

    {
        formats.put("doc", 1);
        formats.put("html", 3);
        formats.put("xml", 4);
        formats.put("docx", 6);
        formats.put("epub", 10);
        formats.put("pptx", 14);
    }

    @Override
    public File convertTo(File initialFile, String format) {
        File convertedFile = new File("C:\\Users\\romac\\Desktop\\conversion\\src\\main\\java\\com\\conversion\\controllers\\tmp\\"
                + initialFile.getName().replaceAll("\\..+", ".docx"));

        Document document = new Document(initialFile.getAbsolutePath());

        document.save(convertedFile.getAbsolutePath(), Optional.ofNullable(formats.get(format)).orElseThrow(() -> new InvalidFormatException("final")));

        return convertedFile;
    }
}
