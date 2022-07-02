package com.kinkode.ed.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Demo {
	@RequestMapping("/")
	 public String home() {
	  return "Welcome to the Demo - Angela!!";
	 }
	
	 @GetMapping("/api/dadjokes")
	    public String dadJokes() {
	        return "Justice is a dish best served cold, if it were served warm it would be just water.";
	   }
}
