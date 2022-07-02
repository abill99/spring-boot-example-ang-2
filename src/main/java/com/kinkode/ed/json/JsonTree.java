package com.kinkode.ed.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.io.FileWriter;
import java.io.IOException;

public class JsonTree {
  public static void printTree(JsonNode rootNode) throws IOException {

     
      System.out.printf("root: %s type=%s%n", rootNode, rootNode.getNodeType());
      traverse(rootNode, 1);
  }

  private static void traverse(JsonNode node, int level) {
      if (node.getNodeType() == JsonNodeType.ARRAY) {
          traverseArray(node, level);
      } else if (node.getNodeType() == JsonNodeType.OBJECT) {
          traverseObject(node, level);
      } else {
         throw new RuntimeException("Not yet implemented");
      }
  }

  private static void traverseObject(JsonNode node, int level) {
      node.fieldNames().forEachRemaining((String fieldName) -> {
          JsonNode childNode = node.get(fieldName);
          printNode(childNode, fieldName, level);
          //for nested object or arrays
          if (traversable(childNode)) {
              traverse(childNode, level + 1);
          }
      });
  }

  private static void traverseArray(JsonNode node, int level) {
      for (JsonNode jsonArrayNode : node) {
          printNode(jsonArrayNode, "arrayElement", level);
          if (traversable(jsonArrayNode)) {
              traverse(jsonArrayNode, level + 1);
          }
      }
  }

  private static boolean traversable(JsonNode node) {
      return node.getNodeType() == JsonNodeType.OBJECT ||
              node.getNodeType() == JsonNodeType.ARRAY;
  }

  private static void printNode(JsonNode node, String keyName, int level) {
      if (traversable(node)) {
         //System.out.printf("%" + (level * 4 - 3) + "s|-- %s=%s type=%s%n",
           //       "", keyName, node.toString(), node.getNodeType());
          
          System.out.printf("%" + (level * 4 - 3) + "s|-- %s=%s%n",
                  "", keyName, node.toString());
          
      } else {
          Object value = null;
          if (node.isTextual()) {
              value = node.textValue();
          } else if (node.isNumber()) {
              value = node.numberValue();
          }//todo add more types
          //System.out.printf("%" + (level * 4 - 3) + "s|-- %s=%s type=%s%n",
          //       "", keyName, value, node.getNodeType());
          
          System.out.printf("%" + (level * 4 - 3) + "s|-- %s=%s%n",
                  "", keyName, value);
          
           
      }
  }
  
  private static void printToNodeFile(String nodeStr) {
	  try {
		  String currentPath = new java.io.File(".").getCanonicalPath();
		  String outfilePath = currentPath +"/src/main/resources/"+"tree.out";
		  FileWriter writer = new FileWriter(outfilePath);
		  writer.append(nodeStr);
		  writer.flush();
		  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  
  

}