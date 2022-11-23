package com.example.masterSpring.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerTextFile {

    private final serviceReadTextFile processFile;

    public controllerTextFile(serviceReadTextFile readFile) {
        this.processFile = readFile;
    }

    @RequestMapping("/write")
    public  void messageOutput() throws Exception{
        processFile.reader("E:\\Files\\Incoming\\Customer.txt","E:\\Files\\Outgoing\\SpringOut.txt");
    }

}
















