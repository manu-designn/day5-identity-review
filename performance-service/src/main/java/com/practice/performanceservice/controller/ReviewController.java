package com.practice.performanceservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.performanceservice.dto.ReviewRequest;
import com.practice.performanceservice.dto.ReviewResponse;
import com.practice.performanceservice.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	private final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@PostMapping
	public ResponseEntity<ReviewResponse> submitReview(@RequestBody ReviewRequest request) {
		return ResponseEntity.ok(reviewService.submitReview(request));
	}

}
