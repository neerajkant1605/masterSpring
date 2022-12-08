package com.example.masterSpring.Service;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.example.masterSpring.GenericMethods.genMethods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;

@Slf4j
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

    @Value("${application.bucket.name.output}")
    private String outputBucketName;


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

        log.info("S3 BUCKET PROCESSES START ..................");



        //Generate datetime stamp
        Date myDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String myDateString = sdf.format(myDate);

        //UPLOAD FILE:
        //Get the latest modified file
        String inputFolder = gm.getLastModified("E:\\Files\\Incoming").toString();

        //Extract the file name
        Path inputFilePath = Paths.get(inputFolder);
        Path inputFileName = inputFilePath.getFileName();

        //Generate unique input file name for upload
        String keyName = inputFileName.toString().replace(".txt","") + "_" + myDateString + ".txt";
        log.info("Input file name is: " + keyName);

        //Generate unique output file name for upload
        String outputFileName = inputFileName.toString().replace(".txt", "") + "_Out_" ;
        File outputFilePath = File.createTempFile(outputFileName, ".txt");
        log.info("Output file name and location is: " + outputFilePath.toString());


        //Upload input file to S3 Bucket
        amzS3.putObject(inputBucketName, keyName, new File(inputFilePath.toString()));
        log.info("Local file " + keyName + " uploaded to input bucket: " + inputBucketName);

        // READ UPLOADED FILE
        //Create file object from file in S3
        S3Object object = amzS3.getObject(inputBucketName, keyName);
        InputStream objectData = object.getObjectContent();


        //Read files line by line in an array
        log.info("Reading file " + object.toString() + " start ........ from bucket: " + inputBucketName );
        String line = null;
        String delimiter = ",";
        String outputFilePathString = new String (outputFilePath.toString());
        try {

            BufferedReader reader= new BufferedReader( new InputStreamReader(objectData));
            reader.readLine();

            //Read file
            while(((line = reader.readLine()) != null)) {
                String[] values = line.split(delimiter);
                String content = new String ("Data rows: " + values[0] + "|"+ values[1] + "|" + values[2] + "|" + values[3] + "|" + myDateString);
                Files.write(Paths.get(outputFilePathString), (content + System.lineSeparator()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            }
        }
        catch (IOException e){
            log.error("Exception when reading & writing file: " + e);
        }

        log.info("File writing finished .....");


        //Upload output file to S3 Bucket
        amzS3.putObject(outputBucketName, outputFileName + myDateString + ".txt", new File(outputFilePathString));
        log.info("Output file " + outputFileName + myDateString + ".txt uploaded to bucket: " + outputBucketName  );
        outputFilePath.delete();
        log.info("Temp file: " + outputFilePath.toString() + " deleted");
        return "File " + keyName + " is uploaded to basket: " +  inputBucketName;

    }


}












