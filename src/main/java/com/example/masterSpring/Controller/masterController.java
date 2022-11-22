package com.example.masterSpring.Controller;
import com.example.masterSpring.Model.customer;
import com.example.masterSpring.Service.serviceReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.masterSpring.Service.serviceGetCustomerList;
import com.example.masterSpring.Service.serviceMessage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RestController
public class masterController {


    //Create class references
    private final serviceMessage message;
    private final serviceGetCustomerList getCustomerList;
    private final serviceReadFile readFile;


    //Autowired to refer class objects in constructors
    @Autowired
    public masterController(serviceGetCustomerList getCustomerList, serviceMessage message, serviceReadFile readFile) {
        this.getCustomerList = getCustomerList;
        this.message = message;
        this.readFile = readFile;
    }


    /*************************************************************
     * Home page
     *************************************************************/

    @RequestMapping("/home")
    public String messageOutput() {
        return message.message("This is home page");
    }


    /*************************************************************
     * Get list of customers
     *************************************************************/

    @RequestMapping("/file")
    public String fileRead() throws IOException {
        return readFile.reader("E:\\Files\\Incoming\\Customer.txt");

    }
}

















