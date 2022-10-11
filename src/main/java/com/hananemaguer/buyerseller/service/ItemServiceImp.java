package com.hananemaguer.buyerseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hananemaguer.buyerseller.model.Item;
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
	public List<Item> getAllItems() {
		return itemRepo.findAll();
	}
}
