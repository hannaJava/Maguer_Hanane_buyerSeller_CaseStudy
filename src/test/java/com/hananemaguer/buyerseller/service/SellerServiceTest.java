package com.hananemaguer.buyerseller.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hananemaguer.buyerseller.model.Seller;
import com.hananemaguer.buyerseller.repository.SellerRepoInt;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerServiceTest {

	@Autowired
	public  SellerServiceImp sellerService;
	
	@Autowired
	public  SellerRepoInt sellerRepo;
	
	//save() test
	@Test
	void saveSellerTest() {
		Long id=20L;
		Seller actual=new Seller(id,"sellerTest","password","seller","seller","seller");
		Seller expected=sellerService.save(actual);
		//Seller expected=sellerRepo.findById(id);
		Assertions.assertThat(expected.equals(actual));
		//Assert.assertEquals(expected,actual);	
	}
}
