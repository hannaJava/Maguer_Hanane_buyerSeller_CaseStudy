package com.hananemaguer.buyerseller.repository;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.hananemaguer.buyerseller.model.Seller;
import com.hananemaguer.buyerseller.model.User;

//@DataJpaTest
@SpringBootTest
@RunWith(SpringRunner.class)
class UserRepoTest {

	@Autowired
	public  UserRepoInt userRepo;

	//findByUsername() test
	@Test
	void findUserByUsernameTest() {
		String actual="hanane7885@gmail.com";
		User user=userRepo.findByUsername(actual);
		String expected=user.getUsername();
		Assertions.assertThat(expected.equals(actual));
		//Assert.assertEquals(expected,actual);		
	}
	
	//parameterized test for findByUsername() method
	@ParameterizedTest
	@ValueSource(strings={"root","seller","buyer"})
	void findUserByUsernameParamTest(String actual) {
		String expected=userRepo.findByUsername(actual).getUsername();
		Assertions.assertThat(expected.equals(actual));
	}
	
	//findById() test
		@Test
		void findUserByIdTest() {
			Long actual=2L;
			User user=userRepo.findById(actual);
			Long expected=user.getId();
			Assertions.assertThat(expected.equals(actual));
			//Assert.assertEquals(expected,actual);		
		}
		
		//deleteById() test
				@Test
				void deleteUserByIdTest() {
					userRepo.deleteById(2L);
					User expected=userRepo.findById(2L);
					Assertions.assertThat(expected).isNull();
				}
				
				//updateById() test
				@Test
				void updateUserByIdTest() {
				
				}
}
