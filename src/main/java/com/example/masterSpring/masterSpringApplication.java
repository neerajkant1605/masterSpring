package com.example.masterSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class masterSpringApplication implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(masterSpringApplication.class, args);
	}

	/*

	To call a class method we need instantiate the class here with auto wire below

	@Autowired
	private className instanceName;

	 */


	@Override
	public void run(String... args) throws Exception {
		System.out.println("No command line message yet");
	}
}





