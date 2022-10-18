package com.hananemaguer.buyerseller.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hananemaguer.buyerseller.model.Item;
import com.hananemaguer.buyerseller.model.Seller;
import com.hananemaguer.buyerseller.repository.ItemRepoInt;
import com.hananemaguer.buyerseller.repository.SellerRepoInt;
import com.hananemaguer.buyerseller.repository.UserRepoInt;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemServiceTest {
	@Autowired
	public  ItemServiceImp itemService;
	
	@Autowired
	public  ItemRepoInt itemRepo;
	
	@Autowired
	public  SellerRepoInt sellerRepo;
	
	//save() test
	@Test
	void saveItemTest() {
		Seller seller=new Seller();
		Item actual=new Item("item name",0.0,"item description",seller);
		Item expected=itemService.save(actual);
		//User expected=itemRepo.findById(ret.getId());
		Assertions.assertThat(expected.equals(actual));
		//Assert.assertEquals(expected,actual);	
	}
}
