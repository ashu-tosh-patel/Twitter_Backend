package com.tweet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:ValidationMessages.properties")
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
//comment by sachin
	
//	@Bean
//	@LoadBalanced
//	public WebClient.Builder webClientBuilder(){
//		return WebClient.builder();
//	}
}
