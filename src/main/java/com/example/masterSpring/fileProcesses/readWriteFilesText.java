package com.example.masterSpring.fileProcesses;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;

@Component
public class readWriteFilesText {

    @Bean
    public static void readerWrite() throws IOException {
        String ip = "E:\\Files\\Incoming\\Customer.txt";
        String op = "E:\\Files\\Outgoing\\SpringOut.txt";
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
