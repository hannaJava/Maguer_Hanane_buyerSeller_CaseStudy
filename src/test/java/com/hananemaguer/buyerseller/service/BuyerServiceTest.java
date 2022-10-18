package com.hananemaguer.buyerseller.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hananemaguer.buyerseller.model.Buyer;
import com.hananemaguer.buyerseller.repository.BuyerRepoInt;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BuyerServiceTest {

	@Autowired
	public  BuyerServiceImp buyerService;
	
	@Autowired
	public  BuyerRepoInt buyerRepo;
	
	//save() test
	@Test
	void saveBuyerTest() {
		Long id=20L;
		Buyer actual=new Buyer(id,"buyerTest","password","buyer","buyer","buyer");
		Buyer expected=buyerService.save(actual);
		//Buyer expected=buyerRepo.findById(id);
		Assertions.assertThat(expected.equals(actual));
		//Assert.assertEquals(expected,actual);	
	}
}
