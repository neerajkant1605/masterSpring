package com.example.masterSpring.Processes;

import com.example.masterSpring.Service.serviceReadTextFile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;

@Component
public class processFileReadWrite {

    public static void reader(String ip, String op) throws IOException {
        String line = null;
        String delimiter = ",";
        BufferedReader br = new BufferedReader(new FileReader(ip));
        br.readLine();

        while (((line = br.readLine()) != null)) {
            String[] values = line.split(delimiter);
            String content = values[0] + "," + values[1];
            Files.writeString(Path.of(op), content + System.lineSeparator(), APPEND);
            System.out.println("Hello Ji");
        }

    }


}
