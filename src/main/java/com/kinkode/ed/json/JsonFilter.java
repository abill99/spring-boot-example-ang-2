package com.kinkode.ed.json;

import com.kinkode.ed.debug.Debug;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class JsonFilter {

	public static void readFromFile(String fileStr){
		
	     
		Debug.out(" JsonFilter reading:" + fileStr);
		try {
			
			//create ObjectMapper instance
			ObjectMapper mapper = new ObjectMapper();
			Object json = mapper.readValue(new FileInputStream(fileStr), Map.class);
			//Debug.out(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));
			
			//Generate Keys for Header using Map
			Debug.out(" Generate Keys for Header using Map and print:");
			Map<String, Object> map = mapper.readValue(new FileInputStream(fileStr), Map.class);
			
			// it works
            //Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});

           //System.out.println(map);
           Debug.out(map.get("info"));
           
           ArrayList infoArr = (ArrayList) map.get("info");
           
           Debug.out("PRINTING ARRAY OBJECTS");
			for (Object a  : infoArr) {
				Debug.out(a+ " ");
		      }
			
			//https://mkyong.com/java/how-to-export-data-to-csv-file-java/
            
            Debug.out("DONE Generate Keys for Header using Map:");
			
			Debug.out("PRINT SPREADSHEET");
		    JsonNode rootNode = mapper.readTree(new FileInputStream(fileStr));
			JsonSpreadsheet.printSpreadsheet(rootNode);
			
			//Debug.out("PRINT TREE");
		    //JsonNode rootNode = mapper.readTree(new FileInputStream(fileStr));
			//JsonTree.printTree(rootNode);
			
		
	
		} catch (Exception e) {
			Debug.out(e.getMessage()); ;
			e.printStackTrace();
		}
		

	}
	
	public static void checkParserSettings()   {
		try {
			//JsonFactory jsonFactory = new JsonFactory();
			//JsonParser jsonParser = jsonFactory.createJsonParser(new FileInputStream(fileStr));
			//jsonParser.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);

			//for(JsonParser.Feature feature : JsonParser.Feature.values()) {
			////	Debug.out(feature.name() + ":" + jsonParser.isEnabled(feature));
			//}

		   } catch(Exception e) {
		         e.printStackTrace();
		   }
	}
	
	public static void formatForLe(String filePath, String outfilePath)  throws Exception {
		      //Instantiating the File class
		      //Instantiating the Scanner class to read the file
		
			  Debug.out("formatForLe---------------------------");
		      Scanner sc = new Scanner(new File(filePath));
		      StringBuffer buffer = new StringBuffer();
		      //Reading lines of the file and appending them to StringBuffer
		      while (sc.hasNextLine()) {
		         buffer.append(sc.nextLine()+System.lineSeparator());
		      }
		      String fileContents = buffer.toString();
		      String newfileContents = "";

		      
		      sc.close();

			  //Debug.out("formatForLe closing the Scanner object");
		      
		      
		      String thisLine = null;
		      String oldLine = null;

			//Debug.out("----formatForLe::Reading Json from formatted File:" + filePath);

		     //String fileAsStr = Files.readString(Path.of(filePath));
			// Debug.out("----formatForLe::Reading Json from formatted File:" + filePath);

		  
				
			      try {
			         // open input stream test.txt for reading purpose.
			    	 //Debug.out("formatForLe reading stimulus");
			         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));   
			         int cnt = 0;
			         while ((oldLine = br.readLine()) != null) {
			        	 
			        	 String value ="";
			        	if (oldLine.contains("stimulus") || oldLine.contains("template")) {
			        		//Debug.out("Stimulus--------");
			        		//Debug.out(oldLine);
			        		
			        		String[] keyValuePair = oldLine.split(":", 2);
				            String key = keyValuePair[0];
				            String value_unformatted = keyValuePair[1];
				           if (value_unformatted.endsWith("\"," )) {
				        	 // Debug.out("ends with COMMA");
				        	//	Debug.out(oldLine);
				        		String splice = value_unformatted.substring(1, value_unformatted.length()-2);
				     
				   
					             value = "\""+ splice.replaceAll( "\"" , " " )+"\",";
					             
					           
				           } else {
				        	    //Debug.out("NOT ends with COMMA");
						        //Debug.out(oldLine);

						        String splice = value_unformatted.replaceAll( "\"" , " " );
						        value = "\""+ splice.replaceAll( "\"" , " " )+"\"";
						       
				           }
			        		
			   		      
			   		      String replacementLine = key + ":"   + value.trim();
			   		     // Debug.out("replacementLine");
			   		     // Debug.out(replacementLine);
			   		      
			        		
			   		      
			   		        newfileContents = newfileContents + replacementLine + "\n";
			        		cnt++;
			        	} else {
			        		newfileContents = newfileContents + oldLine+ "\n";
			        	}
			         }    
			         Debug.out(cnt);
	
			      } catch(Exception e) {
			         e.printStackTrace();
			      }
			      
			   Debug.out("------formatForLe writing" + outfilePath);
		     
		      //instantiating the FileWriter class
		      FileWriter writer = new FileWriter(outfilePath);
		     // Debug.out("new data: "+ fileContents);
		      
		      
		      writer.append(newfileContents);
		      writer.flush();
		      
		     
		      
		    try {
		         // open input stream test.txt for reading purpose.
		         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream( outfilePath)));   
		         int cnt = 0;
		         while ((thisLine = br.readLine()) != null) {
		        	if (thisLine.contains("stimulus")) {
		        		//Debug.out(thisLine);
		        		cnt++;
		        	}
		         }    
		         Debug.out(cnt);

		      } catch(Exception e) {
		         e.printStackTrace();
		      }
		     
		      
			  Debug.out("END OverwriteLine---------------------------");
		}

	
}
