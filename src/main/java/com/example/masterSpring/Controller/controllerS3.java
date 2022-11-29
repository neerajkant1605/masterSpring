package com.example.masterSpring.Controller;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.example.masterSpring.Service.serviceS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/upload")
    public String uploadFile(@RequestParam (value= "file") MultipartFile file) throws IOException {
        sS3.uploadFileController(file);
        return "file uploaded: " + sS3.uploadFileController(file).toString();
    }

}
