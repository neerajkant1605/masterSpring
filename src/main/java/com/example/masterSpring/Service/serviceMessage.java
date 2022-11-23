package com.example.masterSpring.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class serviceMessage {


    public String message (String s) {
      return s;
    }
}

