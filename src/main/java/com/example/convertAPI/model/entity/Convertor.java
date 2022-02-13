package com.example.convertAPI.model.entity;

import java.io.File;

public interface Convertor {
    File convertTo(File initialFile, String format);
}
