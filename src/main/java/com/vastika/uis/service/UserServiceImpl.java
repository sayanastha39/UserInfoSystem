package com.vastika.uis.service;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vastika.uis.controller.UserController;
import com.vastika.uis.model.Role;
import com.vastika.uis.model.User;
import com.vastika.uis.repository.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	private static final Logger log = Logger.getLogger(UserServiceImpl.class);
	
	
	private static final String ROLE_NAME="ROLE_USER";

		@Autowired
		private UserRepository userRepository;
		
		@Override
		public void saveUserInfo(User user) {
			Role role= new Role();
			role.setId(2);
			role.setRoleName(ROLE_NAME);
			user.setRole(role);
			log.info("role is {}"+ role.getRoleName());
			userRepository.saveUserInfo(user);
		}

		@Override
		public void updateUserInfo(User user) {
			//Role role=  new 
			userRepository.updateUserInfo(user);
		}

		@Override
		public void deleteUserInfo(int id) {
			userRepository.deleteUserInfo(id);
		}

		@Override
		public User getUserById(int id) {
			return userRepository.getUserById(id);
		}

		@Override
		public List<User> getAllUserInfo() {
			return userRepository.getAllUserInfo();
		}

		@Override
		public User getUserInfoByEmail(String email) {
			// TODO Auto-generated method stub
			return userRepository.getUserInfoByEmail(email);
		}


}
