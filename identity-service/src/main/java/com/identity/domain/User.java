package com.identity.domain;

public class User {

	private Long id;
	private String name;
	private String email;
	private String role;
	private String contactNumber;

	public User(Long id, String name, String email, String role, String contactNumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.contactNumber = contactNumber;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public String getContactNumber() {
		return contactNumber;
	}

}
