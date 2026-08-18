package com.practice.performanceservice.service;

import org.springframework.stereotype.Service;

import com.practice.performanceservice.client.UserClient;
import com.practice.performanceservice.dto.ReviewRequest;
import com.practice.performanceservice.dto.ReviewResponse;
import com.practice.performanceservice.dto.UserResponse;

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
