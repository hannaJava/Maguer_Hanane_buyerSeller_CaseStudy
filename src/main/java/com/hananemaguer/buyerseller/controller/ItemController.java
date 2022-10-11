package com.hananemaguer.buyerseller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hananemaguer.buyerseller.service.ItemServiceInt;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ItemController {
	private static final String PATH="/items";
	private ItemServiceInt itemService;
	@RequestMapping(PATH)
	public String listItems(Model model) {
		model.addAttribute("items",itemService.getAllItems());
		return "items";
	}
}
