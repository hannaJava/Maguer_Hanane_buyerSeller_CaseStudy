package com.hananemaguer.buyerseller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hananemaguer.buyerseller.service.SellerServiceInt;

import lombok.AllArgsConstructor;

//spring mvc controller to handle requests
@Controller
@AllArgsConstructor
public class SellerListController {
	private static final String PATH="/sellers-list";
	private SellerServiceInt sellerService;
	/*handle list sellers request and return model and view*/
	@RequestMapping(PATH)
	public String listSellers(Model model) {
		model.addAttribute("sellers",sellerService.getAllSellers());
		//spring boot automatically configure view resolver for thymleaf when ever it find a thymleaf dependency in file path(pom.xml) no need to create view resolver bean for thymleaf manually
		//spring boot will find all thymleaf template under templates folder so keep all views in that folder
		//display list of sellers in a view(sellers.html)
		return "sellers-list";
	}
}
