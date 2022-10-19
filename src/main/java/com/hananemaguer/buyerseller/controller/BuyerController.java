package com.hananemaguer.buyerseller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hananemaguer.buyerseller.model.Seller;
import com.hananemaguer.buyerseller.repository.BuyerRepoInt;
import com.hananemaguer.buyerseller.repository.ItemRepoInt;
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
	
	@Autowired
	private SellerRepoInt sellerRepo;
	
	@PostMapping("/items_list_by_keyword")
	public String listItems(Model model,@Param("keyword") String keyword) {
		model.addAttribute("items",itemService.getAllItemsByKeyword(keyword));
		model.addAttribute("keyword",keyword);
		return "items_list_by_keyword";
	}	
	
	@GetMapping("/items_list_buyer")
	public String displayAllItems(Model model) {
		model.addAttribute("items",itemService.getAllItems());
		Seller seller=new Seller();
		model.addAttribute("seller",seller);
		return "items_list_buyer";
	}
	
	@GetMapping("/displaySellerContact")
	public ModelAndView displaySellerContact(@RequestParam Long id){
		ModelAndView mav = new ModelAndView("seller_contact");
		Seller seller=sellerRepo.findById(id);
		mav.addObject("seller",seller);
		return mav;
	}
}
