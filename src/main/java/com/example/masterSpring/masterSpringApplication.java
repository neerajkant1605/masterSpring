package com.example.masterSpring;

import com.example.masterSpring.Processes.masterSpringApplicationint;
import com.example.masterSpring.Processes.processFileReadWrite;
import com.example.masterSpring.Processes.processPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class masterSpringApplication implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(masterSpringApplication.class, args);
	}
	
	@Autowired
	private processFileReadWrite printing;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("No command line message yet");
	}
}





