package com.hananemaguer.buyerseller.repository;

import java.util.List;
import java.util.*;

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
public class ItemRepoTest {

	@Autowired
	public  ItemRepoInt itemRepo;
	
	@Autowired
	public  BuyerRepoInt buyerRepo;
	
	//findById() test
	@Test
	void findItemByIdTest() {
		Long actual=5L;
		Item item=itemRepo.findById(actual);
		Long expected=item.getId();
		Assertions.assertThat(expected.equals(actual));
		//Assert.assertEquals(expected,actual);		
	}
	
	//findBySellerId() test
		@Test
		void findItemBySellerIdTest() {
			Long id=6L;
			List<Item> items=itemRepo.findBySellerId(id);
			Assertions.assertThat(items.size()).isGreaterThan(0);	
		}
	
	//deleteById() test
			@Test
			void deleteItemByIdTest() {
				itemRepo.deleteById(5L);
				Item expected=itemRepo.findById(5L);
				Assertions.assertThat(expected).isNull();
			}
			
			//search() test
			@Test
			void searchtemTest() {
			}
}
