package com.hananemaguer.buyerseller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellerController {
	@GetMapping("/seller")
	public String buyerPageDisplay() {
		return "seller";
	}
}
