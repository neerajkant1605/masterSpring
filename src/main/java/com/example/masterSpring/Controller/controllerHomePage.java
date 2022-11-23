package com.example.masterSpring.Controller;
import com.example.masterSpring.Service.serviceMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class controllerHomePage {

    private final serviceMessage sm;

    public controllerHomePage(serviceMessage sm) {
        this.sm = sm;

    }

    /*************************************************************
     * Home page
     *************************************************************/

    @RequestMapping("/home")
    public String home() {
        return sm.message("This is home page");
    }



}
