package com.hananemaguer.buyerseller.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hananemaguer.buyerseller.Exception.DubplicatedUserException;
import com.hananemaguer.buyerseller.model.Role;
import com.hananemaguer.buyerseller.model.User;
import com.hananemaguer.buyerseller.repository.UserRepoInt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserServiceImp implements UserServiceInt{

	@Autowired
	private UserRepoInt userRepo;
	
	@Autowired//avoiding cycle references btw securitycong and userserviceimp
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User save(User user) throws DubplicatedUserException {
		//if(userRepo.findByUsername(user.getUsername())!=null) throw new Exception("User already exists for this email");
		if(userRepo.findByUsername(user.getUsername())!=null) throw new DubplicatedUserException("User already exists for this email");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		//user.setRoles(Arrays.asList(new Role("admin")));
		//Role role=new Role();
		//user.setRoles(Arrays.asList(user.getRoles());
		return userRepo.save(user);
	}

	//inject user interface repository//field based injection//not recommended
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(" load user by username");
		User user=userRepo.findByUsername(username);
		System.out.println(user);
		if(user==null) {
			throw new UsernameNotFoundException("Unexisting Account/Invalid username or password.(spring boot error message)");
		}
		System.out.println("pw "+user.getPassword());
		System.out.println("email "+user.getUsername());
		System.out.println("id "+user.getId());
		//return user;
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}                                                                       
	
	//User class implements UserDetails interface//User belong to spring security
			//create private method to map roles into authorities
			//System.out.println(mapRolesToAuthorities(user.getRoles()));
	//return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	
	//convert roles into authorities
	private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		//map a role to authority
		return roles.stream()//convert roles into streams
		.map(role->new SimpleGrantedAuthority(role.getName()))//map each to simple granted authority object//spring security class
		.collect(Collectors.toList());//collected those streamed roles into a list and return it
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
}
