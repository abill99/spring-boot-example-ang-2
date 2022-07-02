package com.kinkode.ed.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Demo {
	@RequestMapping("/")
	 public String home() {
	  return "Welcome to the Demo - Angela!!";
	 }
}
