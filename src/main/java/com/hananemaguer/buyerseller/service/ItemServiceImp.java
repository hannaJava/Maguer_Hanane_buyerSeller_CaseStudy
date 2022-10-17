package com.hananemaguer.buyerseller.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hananemaguer.buyerseller.model.Item;
import com.hananemaguer.buyerseller.model.Seller;
import com.hananemaguer.buyerseller.model.User;
import com.hananemaguer.buyerseller.repository.ItemRepoInt;


import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class ItemServiceImp implements ItemServiceInt{
	@Autowired
	private ItemRepoInt itemRepo;
	
	@Override
	public List<Item> getAllItemsBySeller(long id) {
		System.out.println("before find all items");
		return itemRepo.findBySellerId(id);
	}

	@Override
	//public Item save(Item item) {
	public Item save(Item item){//, Integer itemQte), MultipartFile itemImage) {
		return itemRepo.save(item);
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepo.findAll();
	}

	@Override
	public List<Item> getAllItemsByKeyword(String keyword) {
		if(keyword!=null) {
			System.out.println("if user type a keyword");
			return itemRepo.search(keyword);
		}
		System.out.println("if user does'nt type a keyword");
		return itemRepo.findAll();
	}

}
