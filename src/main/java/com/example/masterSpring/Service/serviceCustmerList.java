package com.example.masterSpring.Service;

import com.example.masterSpring.Model.customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceCustmerList {
    public List<customer> customerList()    {
        return List.of(new customer(1,"Neeraj", "Kant", "London")); }
}
