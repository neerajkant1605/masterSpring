package com.example.masterSpring.Service;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class serviceS3{


    //List buckets
    @Autowired
    AmazonS3 amzS3;

    public List<Bucket> listBuckets () {
            List<Bucket> s = amzS3.listBuckets();                    ;
        return s;
    }

    }


