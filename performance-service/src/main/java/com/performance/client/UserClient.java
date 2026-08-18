package com.performance.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

import com.performance.dto.UserResponse;
import com.performance.exception.IdentityServiceUnavailableException;
import com.performance.exception.UserNotFoundException;

@Component
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

		} catch (HttpClientErrorException.NotFound notFound) {
			throw new UserNotFoundException("User not found with id " + id);

		} catch (ResourceAccessException | HttpClientErrorException | HttpServerErrorException unreachable) {
			throw new IdentityServiceUnavailableException("Identity Service is currently unavailable");
		}
	}

}
