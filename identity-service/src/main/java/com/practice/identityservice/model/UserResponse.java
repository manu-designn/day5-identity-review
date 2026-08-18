package com.practice.identityservice.model;

public record UserResponse(
		Long id,
		String name,
		String email,
		String role) {
}
