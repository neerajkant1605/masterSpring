package com.example.masterSpring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class masterSpringApplication implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(masterSpringApplication.class, args);
	}



	//@Autowired
	//serviceS3 s3;


	@Override
	public void run(String... args) throws Exception {
		//s3.createBucket("test");
	}
}





