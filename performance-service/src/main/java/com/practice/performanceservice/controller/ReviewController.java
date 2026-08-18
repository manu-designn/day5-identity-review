package com.practice.performanceservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.performanceservice.client.UserClient;
import com.practice.performanceservice.model.ReviewRequest;
import com.practice.performanceservice.model.UserResponse;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	private final UserClient userClient;

	public ReviewController(UserClient userClient) {
		this.userClient = userClient;
	}

	@PostMapping
	public String submitReview(@RequestBody ReviewRequest request) {
		UserResponse user = userClient.getUser(request.getUserId());
		return "Review recorded for " + user.name() + " with rating " + request.getRating();
	}

}
