package com.PlacesBrowser.REST;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TestRestConfiguration {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
