package com.practice.performanceservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

	@Value("${identity.service.base-url}")
	private String identityServiceBaseUrl;

	@Bean
	RestClient identityRestClient() {
		return RestClient.builder()
				.baseUrl(identityServiceBaseUrl)
				.build();
	}

}
