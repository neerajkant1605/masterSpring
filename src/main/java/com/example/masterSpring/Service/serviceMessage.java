package com.example.masterSpring.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class serviceMessage {

    @Bean
    public String message () {
        String s = "This is a test";
        System.out.println(s);
        return s;
    }
}

