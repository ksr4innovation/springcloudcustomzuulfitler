package com.snkit.springcloudproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SpringcloudproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudproxyApplication.class, args);
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	@Bean	
	public DemoFilter demoFilter() {
		return new DemoFilter();
	}
	
	
	@Bean	
	public DemoCustomPreOrderFilter demoCustomPreOrderFilter() {
		return new DemoCustomPreOrderFilter();
	}
	
	
	@Bean	
	public DemoOrderFilter demoOrderFilter() {
		return new DemoOrderFilter();
	}
}

