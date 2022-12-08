package com.example.masterSpring.FileProcesses;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
public class readWriteFilesJson  {

    @Value("${files.input.json}")
    private String jsonInputFile;





    //Read JSON File
    @Bean
    public void readJson() throws IOException, ParseException {

        log.info("JSON PROCESSES START ..................");


    JSONParser jp = new JSONParser();
    JSONObject joLeft = (JSONObject) jp.parse(new FileReader(jsonInputFile));

        //Extract Value for a key
        log.info("JSON field value extraction- email (String): " + joLeft.get("email"));

        //
        log.info("JSON field value extraction project(Array): " + joLeft.get("projects"));

        //Remove a key
        joLeft.remove("zipCode");






    }

}


   


