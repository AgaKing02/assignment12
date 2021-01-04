package com.apj2.assignment12.services;


import java.io.File;


public class FileService {
    private static final String PATH = "C:/Users/HP/Desktop/apj2test";

    public static File[] getFilesFromPath() {
        File file = new File(PATH);
        return file.listFiles();
    }

}
