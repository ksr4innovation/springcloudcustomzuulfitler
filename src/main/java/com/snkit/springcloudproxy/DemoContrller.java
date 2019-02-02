package com.snkit.springcloudproxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoContrller {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value="/sayHiProxy")
	public String sayHiProxy() {
		
		ResponseEntity<String> resp =  restTemplate.exchange("http://CUSTADDSERVICE/sayHi",HttpMethod.GET, null,String.class);
		
		return resp.getBody();
	}
}
