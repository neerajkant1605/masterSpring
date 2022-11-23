package com.example.masterSpring.Controller;
import com.example.masterSpring.Model.customer;
import com.example.masterSpring.Service.serviceCustmerList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class controllerCustomerList {
    private final serviceCustmerList customers;

    public controllerCustomerList(serviceCustmerList customers) {
        this.customers = customers;
    }


    /*************************************************************
     * Get Customer list
     *************************************************************/

    @RequestMapping("/customers")
    public List<customer> customerList() {
        return customers.customerList();
    }


}
