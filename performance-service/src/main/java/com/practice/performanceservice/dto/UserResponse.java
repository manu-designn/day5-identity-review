package com.practice.performanceservice.dto;

public record UserResponse(
		Long id,
		String name,
		String email,
		String role) {
}
