package com.hananemaguer.buyerseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hananemaguer.buyerseller.model.User;

public interface UserRepoInt extends JpaRepository<User,String>{
	//this method will be implemented at runtime by framework
	//this is the method name convention we need to provide to JpaRepository interface camel case findBy...
	User findByEmail(String email);
}
