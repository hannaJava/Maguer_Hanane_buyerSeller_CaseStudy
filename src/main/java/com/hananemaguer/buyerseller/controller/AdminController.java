package com.hananemaguer.buyerseller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("/admin")
	public String adminPageDisplay() {
		return "admin";
	}
}
