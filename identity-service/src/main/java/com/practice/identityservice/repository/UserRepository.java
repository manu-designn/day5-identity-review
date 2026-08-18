package com.practice.identityservice.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.practice.identityservice.domain.User;

@Repository
public class UserRepository {

	private final Map<Long, User> users = new HashMap<>();

	public UserRepository() {
		users.put(1001L, new User(1001L, "Ananya Sharma", "ananya.sharma@company.com", "EMPLOYEE", "9845012345"));
		users.put(1002L, new User(1002L, "Rohit Verma", "rohit.verma@company.com", "MANAGER", "9845067890"));
	}

	public User findById(Long id) {
		return users.get(id);
	}

}
