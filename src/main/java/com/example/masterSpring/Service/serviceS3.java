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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
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
       API:
     ****************************/

    //Upload files to S3
    public String uploadFileController (MultipartFile multipartFile) throws IOException {
        String uniqueFileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        File file = gm.convertMultipartToFile(multipartFile);
        amzS3.putObject(inputBucketName, uniqueFileName, file);
        return uniqueFileName;
    }

    /********************************************************
     Console:
     > Upload last modified file in folder to S3
     > Read the uploaded file in an array
     > Make changes to file and add time stamp
     > Write the data to a temp file  and save
     > Upload the new file to S3 Bucket
     ********************************************************/


    @Bean
    public String fileProcess () throws IOException {

        //UPLOAD FILE:

        //Get the latest modified file
        String inputFolder = gm.getLastModified("E:\\Files\\Incoming").toString();

        //Extract the file name
        Path inputFilePath = Paths.get(inputFolder);
        Path inputFileName = inputFilePath.getFileName();

        //Generate unique file name for upload
        String keyName = System.currentTimeMillis()+ "_"+ inputFileName.toString();

        //Upload file to S3 Bucket
        amzS3.putObject(inputBucketName, keyName, new File(inputFilePath.toString()));


        // READ UPLOADED FILE

        //Create file object from file in S3
        S3Object object = amzS3.getObject(inputBucketName, keyName);
        InputStream objectData = object.getObjectContent();

        //Read files line by line in an array
        String line = null;
        String delimiter = ",";
        try {
            BufferedReader reader= new BufferedReader( new InputStreamReader(objectData));
            reader.readLine();

            //Generate datetime stamp string
            Date myDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
            String myDateString = sdf.format(myDate);

            //Read file
            while(((line = reader.readLine()) != null)) {
                String[] values = line.split(delimiter);
                System.out.println(values[0] + "|"+ values[1] + "|" + values[2] + "|" + values[3] + "|" + myDateString );
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "File " + keyName + " is uploaded to basket: " +  inputBucketName;
    }

}










