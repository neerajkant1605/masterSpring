package com.example.masterSpring.GenericMethods;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class genMethods {


    //Method to get the last modified file
    public static File getLastModified(String directoryFilePath) {
        File directory = new File(directoryFilePath);
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;

        if (files != null) {
            for (File file : files) {
                if (file.lastModified() > lastModifiedTime) {
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }
        return chosenFile;
    }

    public String message (String s) {
        return s;
    }

    //Method to show message
    public File convertMultipartToFile(MultipartFile f) throws IOException {
        File convFile = new File(f.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(f.getBytes());
        fos.close();
        return convFile;
    }

}

