package com.hananemaguer.buyerseller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hananemaguer.buyerseller.model.Role;
import com.hananemaguer.buyerseller.model.User;
import com.hananemaguer.buyerseller.repository.UserRepoInt;
import com.hananemaguer.buyerseller.service.UserServiceInt;

@SpringBootApplication
public class BuyerSellerApplication {

	@Autowired
	private UserRepoInt userRepo;
//	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

	
	public static void main(String[] args) {
		SpringApplication.run(BuyerSellerApplication.class, args);
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public ApplicationRunner addData(UserRepoInt userRepo){
		return args->{
			if(userRepo.findByUsername("root")==null) {
			userRepo.save(new User("root",passwordEncoder().encode("root"),"root","root",Arrays.asList(new Role("admin"))));
			}
		};
	}

}
