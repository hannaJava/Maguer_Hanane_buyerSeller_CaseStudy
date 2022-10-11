package com.hananemaguer.buyerseller.service;

//import org.springframework.security.core.userdetails.UserDetailsService;

import com.hananemaguer.buyerseller.dto.UserDto;
import com.hananemaguer.buyerseller.model.User;

public interface UserServiceInt{// extends UserDetailsService{
	//to save user registration data
	User save(UserDto userDto);
	//to retrieve user by email
}
