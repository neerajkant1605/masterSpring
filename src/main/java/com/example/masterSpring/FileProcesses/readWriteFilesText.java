package com.example.masterSpring.FileProcesses;

import com.example.masterSpring.GenericMethods.genMethods;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private genMethods gm;
    public readWriteFilesText(genMethods gm) {
        this.gm = gm;
    }


    @Bean
    public void readerWrite() throws IOException {
        String ip = gm.getLastModified("E:\\Files\\Incoming\\CustomerSpringFolder").toString();
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
