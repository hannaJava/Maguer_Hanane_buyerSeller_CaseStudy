package com.hananemaguer.buyerseller.repository;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hananemaguer.buyerseller.model.Item;
import com.hananemaguer.buyerseller.model.Seller;

@SpringBootTest
@RunWith(SpringRunner.class)
class SellerRepoTest {
	
	@Autowired
	public  SellerRepoInt sellerRepo;

	//findById() test
			@Test
			void findSellerByIdTest() {
				Long actual=6L;
				Seller seller=sellerRepo.findById(actual);
				Long expected=seller.getId();
				Assertions.assertThat(expected.equals(actual));
				//Assert.assertEquals(expected,actual);		
			}
			
			//deleteById() test
					@Test
					void deleteSellerByIdTest() {
						sellerRepo.deleteById(6L);
						Seller expected=sellerRepo.findById(6L);
						Assertions.assertThat(expected).isNull();
					}

}
