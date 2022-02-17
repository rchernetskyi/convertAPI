package com.example.convertAPI.model.entity.convertors;

import com.aspose.words.Document;
import com.example.convertAPI.model.exceptions.InvalidFormatException;

import java.io.File;
import java.util.HashMap;
import java.util.Optional;

public class ConvertorWord implements Convertor {

    private final HashMap<String, Integer> formats = new HashMap<>();

    {
        formats.put("pdf", 40);
        formats.put("xps", 41);
        formats.put("htmlfixed", 45);
        formats.put("epub", 52);
        formats.put("doc", 10);
        formats.put("docx", 20);
        formats.put("png", 101);
    }

    @Override
    public File convertTo(File initialFile, String format) {
        File convertedFile = new File("C:\\Users\\romac\\Desktop\\Лаби\\convertAPI\\src\\main\\resources\\tmp\\"
                + initialFile.getName().replaceAll("\\..+", "." + format));

        try {
            Document document = new Document(initialFile.getAbsolutePath());
            document.save(convertedFile.getAbsolutePath(), Optional.ofNullable(formats.get(format)).orElseThrow(() -> new InvalidFormatException("final")));

        } catch (Exception e) {
            throw new RuntimeException("Oops something went wrong");
        }
        return convertedFile;
    }
}
