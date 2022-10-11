package com.hananemaguer.buyerseller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyerController {
	@GetMapping("/buyer")
	public String buyerPageDisplay() {
		return "buyer";
	}
}
