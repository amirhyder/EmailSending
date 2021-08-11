package com.systems.ltd.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systems.ltd.service.EmailService;

@RestController
public class EmailController {
	

	@Autowired
	private EmailService emailServie;
	
	
	@Value("${email}")
	String message;
	String subject = "Checking for email Confirmation";
	String to = "amirhyder1998@gmail.com";
	
	@GetMapping("/email")
	public String send() {
		if(emailServie.sendEmail(to, message, subject)) {
			return "Email sent";
		}else {
			return "Email not sent";
		}
	}
	
	
	
//	 @Value("${email}")
//	 private String emailContent;
//	 
//	 @GetMapping("/email")
//	 public String getValue()
//	 {
//	  return emailContent;
//	 }
	
	
	
	
	

}
