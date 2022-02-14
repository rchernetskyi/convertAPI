package com.example.convertAPI.model.entity.convertors;

import java.io.File;

public interface Convertor {
    File convertTo(File initialFile, String format);
}
