package com.hananemaguer.buyerseller.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hananemaguer.buyerseller.model.Role;
import com.hananemaguer.buyerseller.model.User;
import com.hananemaguer.buyerseller.repository.UserRepoInt;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

	@Autowired
	public  UserServiceImp userService;
	
	@Autowired
	public  UserRepoInt userRepo;
	
	//save() test
	@Test
	void saveUserTest() {
		User actual=new User("userTest","password","user","user");
		//actual.setRoles(Arrays.asList(new Role("seller")));
		User expected=userService.save(actual);
		//User expected=userRepo.findById(ret.getId());
		Assertions.assertThat(expected.equals(actual));
		//Assert.assertEquals(expected,actual);	
	}
}
