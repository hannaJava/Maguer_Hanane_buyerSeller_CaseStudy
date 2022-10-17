package com.hananemaguer.buyerseller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hananemaguer.buyerseller.repository.BuyerRepoInt;
import com.hananemaguer.buyerseller.repository.SellerRepoInt;
import com.hananemaguer.buyerseller.service.ItemServiceInt;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping
public class BuyerController {
	@Autowired
	private ItemServiceInt itemService;
	
	@Autowired
	private BuyerRepoInt buyerRepo;
	
	@PostMapping("/items_list_by_keyword")
	public String listItems(Model model,@Param("keyword") String keyword) {
		model.addAttribute("items",itemService.getAllItemsByKeyword(keyword));
		model.addAttribute("keyword",keyword);
		return "items_list_by_keyword";
	}	
}
