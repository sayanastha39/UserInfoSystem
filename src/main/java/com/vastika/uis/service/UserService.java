package com.vastika.uis.service;

import java.util.List;

import com.vastika.uis.model.User;

public interface UserService {

	void saveUserInfo(User user);
	
	void updateUserInfo(User user);
	
	void deleteUserInfo(int id);
	
	User getUserById(int id);
	
	List <User> getAllUserInfo();

	User getUserInfoByEmail(String email);
}
