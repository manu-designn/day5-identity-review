package com.practice.identityservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.identityservice.model.UserResponse;

@RestController
@RequestMapping("/users")
public class UserController {

	private final Map<Long, UserResponse> users = new HashMap<>();

	public UserController() {
		users.put(1001L, new UserResponse(1001L, "Ananya Sharma", "ananya.sharma@company.com", "EMPLOYEE"));
		users.put(1002L, new UserResponse(1002L, "Rohit Verma", "rohit.verma@company.com", "MANAGER"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
		UserResponse user = users.get(id);

		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(user);
	}

}
