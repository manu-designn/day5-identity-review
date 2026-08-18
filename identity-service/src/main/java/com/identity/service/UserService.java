package com.identity.service;

import org.springframework.stereotype.Service;

import com.identity.domain.User;
import com.identity.dto.UserResponse;
import com.identity.exception.UserNotFoundException;
import com.identity.repository.UserRepository;

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
