package com.example.masterSpring.Controller;
import com.example.masterSpring.Service.serviceReadTextFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.masterSpring.Service.serviceCustmerList;

import java.io.IOException;

@RestController
public class controllerTextFile {


    //Create class references

    private final serviceCustmerList getCustomerList;
    private final serviceReadTextFile readFile;


    //Autowired to refer class objects in constructors
    @Autowired
    public controllerTextFile(serviceCustmerList getCustomerList, serviceReadTextFile readFile) {
        this.getCustomerList = getCustomerList;

        this.readFile = readFile;
    }





    /*************************************************************
     * Get list of customers
     *************************************************************/

    @RequestMapping("/file")
    public String fileRead() throws IOException {
        return readFile.reader("E:\\Files\\Incoming\\Customer.txt");

    }
}

















