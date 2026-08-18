package com.practice.performanceservice.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.practice.performanceservice.model.UserResponse;

@Service
public class UserClient {

	private final RestClient restClient;

	public UserClient(RestClient identityRestClient) {
		this.restClient = identityRestClient;
	}

	public UserResponse getUser(Long id) {
		try {
			return restClient.get()
					.uri("/users/{id}", id)
					.retrieve()
					.body(UserResponse.class);
		} catch (Exception ex) {
			throw new RuntimeException("Identity Service is unavailable");
		}
	}

}
