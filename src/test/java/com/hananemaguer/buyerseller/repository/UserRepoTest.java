package com.hananemaguer.buyerseller.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;



import com.hananemaguer.buyerseller.model.User;

import junit.framework.Assert;

//@DataJpaTest
@SpringBootTest
@RunWith(SpringRunner.class)
class UserRepoTest {

	@Autowired
	public  UserRepoInt userRepo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void findUserTest() {
		String actual="hanane7885@gmail.com";
		User user=userRepo.findByUsername(actual);
		String expected=user.getUsername();
		Assertions.assertThat(expected.equals(actual));
		//Assert.assertEquals(expected,actual);		
	}
	
	//List<User> users=userRepo.findAll();
	@ParameterizedTest
	@ValueSource(strings={"seller@gmail.com","buyer@gmail.com"})
	void findUserParamTest(String actual) {
		String expected=userRepo.findByUsername(actual).getUsername();
		Assertions.assertThat(expected.equals(actual));
	}
}
