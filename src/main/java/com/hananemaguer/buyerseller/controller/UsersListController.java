package com.hananemaguer.buyerseller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersListController {
	@GetMapping("/users-list")
	public String usersPageDisplay() {
		return "users-list";
	}
}
