package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.SoapClient;
import com.example.demo.loaneligibility.Acknowledgement;
import com.example.demo.loaneligibility.CustomerRequest;

@SpringBootApplication
@RestController
public class SpringBootSoapWebserviceClientApplication {
	
	@Autowired
	private SoapClient client;
	
	@PostMapping("/getLoanStatus")
	public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest req)
	{
		return client.getLoanStatus(req);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapWebserviceClientApplication.class, args);
	}

}
