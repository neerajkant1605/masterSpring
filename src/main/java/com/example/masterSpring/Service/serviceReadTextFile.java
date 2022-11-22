package com.example.masterSpring.Service;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;

@Service
public class serviceReadTextFile {
    public static void reader(String ip, String op) throws IOException {
        String line = null;
        String delimiter = ",";
        BufferedReader br = new BufferedReader(new FileReader(ip));
        br.readLine();

        while (((line = br.readLine()) != null)) {
            String[] values = line.split(delimiter);
            String content = values[0] + "," + values[1];
            Files.writeString(Path.of(op), content + System.lineSeparator(), APPEND);
        }

    }
}




