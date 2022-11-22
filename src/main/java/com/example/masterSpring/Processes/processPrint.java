package com.example.masterSpring.Processes;

import org.springframework.stereotype.Component;

@Component
public class processPrint {

    public void printMessage(String s){
        System.out.println(s);
    }
}
