package com.app.controller;

import com.app.properties.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@CrossOrigin
public class HelloController {

	@Autowired
	MessageProperties messageProperties;

	@GetMapping
	public String HelloMethod()
	{
		return messageProperties.getUserMessage()+" "+messageProperties.getDisplayMessage();
	}

}
