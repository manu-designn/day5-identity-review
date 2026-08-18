package com.practice.identityservice.dto;

public record UserResponse(
		Long id,
		String name,
		String email,
		String role) {
}
