package com.hananemaguer.buyerseller.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hananemaguer.buyerseller.model.User;

public interface UserServiceInt extends UserDetailsService{
	//to save user registration data
	User save(User user) throws Exception;
	//to retrieve user by email
	List<User> getAllUsers();
}
