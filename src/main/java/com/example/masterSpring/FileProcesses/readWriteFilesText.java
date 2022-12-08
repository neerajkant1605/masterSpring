package com.example.masterSpring.FileProcesses;

import com.example.masterSpring.GenericMethods.genMethods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;

@Slf4j
@Component
public class readWriteFilesText {

    @Value("${files.output.text}")
    private String textOutputFile;

    @Value("${folder.input.text}")
    private String textInputFolder;


    @Autowired
    genMethods gm;
    public readWriteFilesText(genMethods gm) {
        this.gm = gm;
    }


    @Bean
    public void readerWrite() throws IOException {



        String ip = gm.getLastModified(textInputFolder).toString();
        String op = textOutputFile;
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
