package com.example.masterSpring.Controller;

import com.amazonaws.services.s3.model.Bucket;
import com.example.masterSpring.Service.serviceS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controllerS3 {

    @Autowired
    serviceS3 sS3;

    //List buckets
    @RequestMapping("/buckets")
    public List<Bucket> buckets() {
        return sS3.listBuckets();
    }
}
