package com.example.masterSpring.Configurations;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsSyncClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configS3 {

    //AWS
    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String accessSecret;

    @Value("${cloud.aws.region.static}")
    private String region;


    //Local Stack
    @Value("${localstack.credentials.access-key}")
    private String localstackAccessKey;

    @Value("${localstack.credentials.secret-key}")
    private String localstackAccessSecret;

    @Value("${localstack.region}")
    private String localstackRegion;

    @Value("${localstack.endpoint}")
    private String localstackEndPoint;


    // AWS Client Builder

    /*

    @Bean
    public AmazonS3 s3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, accessSecret);
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region).build();
     */

    // Localstack ClientBuilder
    @Bean
    public AmazonS3 s3Client() {
        var endpointConfig = new AwsClientBuilder.EndpointConfiguration(localstackEndPoint, localstackRegion);
        AWSCredentials credentials = new BasicAWSCredentials(localstackAccessKey, localstackAccessSecret);
        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(endpointConfig)
                .withPathStyleAccessEnabled(true)
                .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();


    }
}





