package com.example.masterSpring.Service;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.example.masterSpring.GenericMethods.genMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;


@Service
public class serviceS3{


    //List buckets
    @Autowired
    AmazonS3 amzS3;

    @Autowired
    genMethods gm;
    public serviceS3(genMethods gm) {
        this.gm = gm;
    }

    @Value("${application.bucket.name.input}")
    private String inputBucketName;



    public List<Bucket> listBuckets () {
            List<Bucket> s = amzS3.listBuckets();
        return s;
    }

    /*****************************
        Upload files to S3
     ****************************/

    //Upload via controller API and Postman
    public String uploadFileController (MultipartFile multipartFile) throws IOException {

        String uniqueFileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        File file = gm.convertMultipartToFile(multipartFile);
        amzS3.putObject(inputBucketName, uniqueFileName, file);
        return uniqueFileName;
    }

    //Upload from disk storage (Bean is created hence method does not need to be called)
    @Bean
    public String uploadFileFromDisk () throws IOException {
        String keyName = System.currentTimeMillis()+ "_"+ "SampleText.txt";
        String filePath = "E:\\Files\\Incoming\\SampleText.txt";
        amzS3.putObject(inputBucketName, keyName, new File(filePath));
        return "file uploaded directory: " + filePath ;
    }

    /*****************************
     Upload files to S3
     ****************************/


    public String readFile (String keyName) throws IOException {
       S3Object object = amzS3.getObject(inputBucketName, keyName );
        InputStream objectData = object.getObjectContent();


        try {
            BufferedReader reader= new BufferedReader( new InputStreamReader(objectData));
            reader.readLine();
            String line = null;
            while(((line = reader.readLine()) != null)) {
                return line;
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }




}


