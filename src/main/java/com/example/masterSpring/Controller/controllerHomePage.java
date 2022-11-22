package com.example.masterSpring.Controller;
import com.example.masterSpring.Service.serviceMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class controllerHomePage {
    private final serviceMessage message;

    public controllerHomePage(serviceMessage message) {
        this.message = message;
    }

    /*************************************************************
     * Home page
     *************************************************************/

    @RequestMapping("/home")
    public String messageOutput() {
        return message.message("This is home page");
    }


}
