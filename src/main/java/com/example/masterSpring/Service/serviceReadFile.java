package com.example.masterSpring.Service;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static java.rmi.server.LogStream.log;

@Service
public class serviceReadFile {
    public String reader(String f) throws IOException {

        byte[] data = Files.readAllBytes(Paths.get(f));
        return new String(data);
    }
}




