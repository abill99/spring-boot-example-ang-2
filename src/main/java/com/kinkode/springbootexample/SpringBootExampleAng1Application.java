package com.kinkode.springbootexample;

import org.springframework.boot.CommandLineRunner;
import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;

@SpringBootApplication
public class SpringBootExampleAng1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleAng1Application.class, args);
		System.out.println("Let's inspect the beans provided by Spring Boot:");
		 String currentPath;
		try {
			currentPath = new java.io.File(".").getCanonicalPath();
			System.out.println("Current dir:" + currentPath);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//@Bean
	//public CommandLineRunner /(ApplicationContext ctx) {
	//	return args -> {

			//System.out.println("Let's inspect the beans provided by Spring Boot:");

	//		String[] beanNames = ctx.getBeanDefinitionNames();
	//		Arrays.sort(beanNames);
	//		for (String beanName : beanNames) {
	//			System.out.println(beanName);
		//	}

	//	};
	//}

}
