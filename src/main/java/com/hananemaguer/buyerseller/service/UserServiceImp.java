package com.hananemaguer.buyerseller.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
import org.springframework.stereotype.Service;

import com.hananemaguer.buyerseller.dto.UserDto;
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
	
	/*@Autowired
	private BCryptPasswordEncoder passwordEncoder;*/
	
	@Override
	public User save(UserDto userDto) {
		//add roles as needed
		//before using security
		User user=new User(userDto.getFirstName(),userDto.getLastName(),userDto.getEmail(),userDto.getPassword(),Arrays.asList(new Role("ROLE_USER")));
		//after using Bcrypt password encoder to encode the password in encrypted format before stored in db
		//encode use SHA-1 algorithm
		//User user=new User(userDto.getFirstName(),userDto.getLastName(),userDto.getEmail(),passwordEncoder.encode(userDto.getPassword()),Arrays.asList(new Role("ROLE_USER")));
		return userRepo.save(user);
	}
	
	//inject user interface repository//field based injection//not recommended
	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		//User class implements UserDetails interface//User belong to spring security
		//create private method to map roles into authorities
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}*/
	
	//convert roles into authorities
	/*private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		//map a role to authority
		return roles.stream()//convert roles into streams
		.map(role->new SimpleGrantedAuthority(role.getName()))//map each to simple granted authority object//spring security class
		.collect(Collectors.toList());//collected those streamed roles into a list and return it
	}*/
}
