package com.example.masterSpring.Controller;
import com.example.masterSpring.GenericMethods.genMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class controllerHomePage {

    @Autowired
    private genMethods gm;
    public controllerHomePage(genMethods gm) {
        this.gm = gm;
    }

    /*************************************************************
     * Home page
     *************************************************************/

    @RequestMapping("/home")
    public String home() {
        return gm.message("This is home page");
    }



}
