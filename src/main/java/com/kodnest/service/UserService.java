package com.kodnest.service;

import org.springframework.stereotype.Service;

import com.kodnest.entity.User;
@Service
public interface UserService {
	void SaveUser(User user);

	boolean emailExists(User user);

	boolean validUser(String email, String password);

	String getRole(String email);

	User getUser(String mail);

	void updateUser(User user);

}
