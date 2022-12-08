package com.example.masterSpring.FileProcesses;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class readWriteFilesJson  {

    @Bean
    public void readJson() throws IOException, ParseException {
    JSONParser jp = new JSONParser();
    JSONObject joLeft = (JSONObject) jp.parse(new FileReader("E:\\Files\\Incoming\\Json\\left.json"));


}
}


   


