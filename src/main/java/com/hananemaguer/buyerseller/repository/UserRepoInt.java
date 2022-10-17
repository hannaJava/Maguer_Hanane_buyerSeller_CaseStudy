package com.hananemaguer.buyerseller.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hananemaguer.buyerseller.model.Role;
import com.hananemaguer.buyerseller.model.User;

import lombok.Builder;


public interface UserRepoInt extends JpaRepository<User,String>{
	//this method will be implemented at runtime by framework
	//this is the method name convention we need to provide to JpaRepository interface camel case findBy...
	User findByUsername(String username);

	public User findById(Long id);
	
	@Query(value ="DELETE FROM users WHERE users.id= :id", nativeQuery = true)
	void deleteById(Long id);
}
