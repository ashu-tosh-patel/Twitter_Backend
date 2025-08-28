package com.tweet.seachAndDIscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@PropertySource("classpath:ValidationMessages.properties")
public class SeachAndDIscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeachAndDIscoveryApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}
}
