package com.hananemaguer.buyerseller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hananemaguer.buyerseller.service.BuyerServiceInt;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BuyerListController {
	private static final String PATH="/buyers-list";
	private BuyerServiceInt buyerService;
	@RequestMapping(PATH)
	public String listBuyers(Model model) {
		model.addAttribute("buyers",buyerService.getAllBuyers());
		 return "buyers-list";
	}

}
