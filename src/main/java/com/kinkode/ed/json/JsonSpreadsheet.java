package com.kinkode.ed.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.ArrayList; 
import java.util.List;   
import com.fasterxml.jackson.databind.MappingIterator; 
import com.fasterxml.jackson.databind.ObjectReader; 
import com.fasterxml.jackson.dataformat.csv.CsvMapper; 
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.File;
import java.io.IOException;

public class JsonSpreadsheet {
	

	
	public static void printSpreadsheet(JsonNode rootNode) throws IOException {

		Builder csvSchemaBuilder = CsvSchema.builder();
		JsonNode firstObject = rootNode.elements().next();
		firstObject.fieldNames().forEachRemaining(fieldName 
				-> {csvSchemaBuilder.addColumn(fieldName);} );
		
		//CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true)
                .addColumn("info")
                .addColumn("name")
                .addColumn("age")
                .addColumn("type")
                .addColumn("widget_type")
                .addColumn("reference")
            	.addColumn("data")
                .addColumn("stimulus")
                .build();
	     //mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

		
		
		 

		JsonSpreadsheet.printNodeToFile(csvSchema, rootNode);
	  
	}
	
	
	private static void printNodeToFile(CsvSchema csvSchema, JsonNode rootNode) {
		
		
		  try {
			  String currentPath = new java.io.File(".").getCanonicalPath();
			  String outfilePath = currentPath +"/src/main/resources/"+"out.csv";
			  
			  CsvMapper csvMapper = new CsvMapper();
			//  csvMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);
			  csvMapper.writerFor(JsonNode.class)
			    .with(csvSchema)
			    .writeValue(new File(outfilePath), rootNode);
			    //.writeValue(new File("src/main/resources/"+ "out.csv"), rootNode);

			 
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
}
