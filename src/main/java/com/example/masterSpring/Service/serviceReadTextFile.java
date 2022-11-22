package com.example.masterSpring.Service;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class serviceReadTextFile {
    public String reader(String f) throws IOException {

        byte[] data = Files.readAllBytes(Paths.get(f));
        return new String(data);
    }
}




