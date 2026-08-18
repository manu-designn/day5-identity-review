package com.performance.service;

import org.springframework.stereotype.Service;

import com.performance.client.UserClient;
import com.performance.dto.ReviewRequest;
import com.performance.dto.ReviewResponse;
import com.performance.dto.UserResponse;

@Service
public class ReviewService {

	private final UserClient userClient;

	public ReviewService(UserClient userClient) {
		this.userClient = userClient;
	}

	public ReviewResponse submitReview(ReviewRequest request) {
		UserResponse user = userClient.getUser(request.getUserId());

		return new ReviewResponse(
				"SUCCESS",
				"Review recorded for " + user.name() + " with rating " + request.getRating());
	}

}
