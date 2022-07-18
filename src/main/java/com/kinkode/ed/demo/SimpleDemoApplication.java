package com.kinkode.ed.demo;

import java.io.IOException;
import com.kinkode.ed.json.JsonFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class SimpleDemoApplication {

	public static void main(String[] args) {

		
		try {
			System.out.println("SIMPLE: Let's print file path:");
			String currentPath;
			currentPath = new java.io.File(".").getCanonicalPath();
			
			//String fileStr = currentPath +"/src/main/resources/json/"+"valid_short.json");
			//String outFileStr = currentPath +"/src/main/resources/json/"+"formatted_valid_short.json";

			//String fileStr = currentPath +"/src/main/resources/json/"+"valid.json");
			//String outFileStr = currentPath +"/src/main/resources/json/"+"formatted_valid.json";

			
			//String fileStr = currentPath +"/src/main/resources/json/"+"data_short.json";
			//String outFileStr = currentPath +"/src/main/resources/json/"+"formatted_data_short.json";
			
			String  fileStr = currentPath + "/src/main/resources/json/"+"data.json";
			
			String outFileStr = currentPath +"/src/main/resources/json/"+"formatted_data.json";


			System.out.println("Current dir:" + currentPath);

			try {	         
				//System.out.println("----Formatting File:" + fileStr );

		         // JsonFilter.formatForLe(fileStr, outFileStr);
		    } catch(Exception e) {
		        e.printStackTrace();
		   
		    }
			
			//System.out.println("----RE Reading JSON:" + fileStr);		 
			//JsonFilter.readFromFile(fileStr);
			
			System.out.println("----SIMPLE Reading FORMATTED JSON:" + outFileStr);		 
			JsonFilter.readFromFile(outFileStr);
			
			System.out.println("----SIMPLE DONE Reading FORMATTED JSON:" + outFileStr);
			
			


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}