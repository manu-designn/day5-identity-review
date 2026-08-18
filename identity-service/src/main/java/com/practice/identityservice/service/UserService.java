package com.practice.identityservice.service;

import org.springframework.stereotype.Service;

import com.practice.identityservice.domain.User;
import com.practice.identityservice.dto.UserResponse;
import com.practice.identityservice.exception.UserNotFoundException;
import com.practice.identityservice.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserResponse getUser(Long id) {
		User user = userRepository.findById(id);

		if (user == null) {
			throw new UserNotFoundException("User not found with id " + id);
		}

		return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getRole());
	}

}
