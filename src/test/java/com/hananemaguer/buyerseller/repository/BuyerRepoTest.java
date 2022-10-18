package com.hananemaguer.buyerseller.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hananemaguer.buyerseller.model.Buyer;
import com.hananemaguer.buyerseller.model.Item;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BuyerRepoTest {
	
	@Autowired
	public  BuyerRepoInt buyerRepo;
	
	//findById() test
	@Test
	void findBuyerByIdTest() {
		Long actual=15L;
		Buyer buyer=buyerRepo.findById(actual);
		Long expected=buyer.getId();
		Assertions.assertThat(expected.equals(actual));
		//Assert.assertEquals(expected,actual);		
	}
	
	//deleteById() test
			@Test
			void deletebuyerByIdTest() {
				buyerRepo.deleteById(15L);
				Buyer expected=buyerRepo.findById(15L);
				Assertions.assertThat(expected).isNull();
			}
}
