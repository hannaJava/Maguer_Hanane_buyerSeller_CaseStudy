package com.hananemaguer.buyerseller.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hananemaguer.buyerseller.model.Item;
import com.hananemaguer.buyerseller.model.Seller;
import com.hananemaguer.buyerseller.model.User;
import com.hananemaguer.buyerseller.repository.ItemRepoInt;
import com.hananemaguer.buyerseller.repository.SellerRepoInt;
import com.hananemaguer.buyerseller.service.ItemServiceInt;
import com.hananemaguer.buyerseller.service.SellerServiceInt;
import com.hananemaguer.buyerseller.service.UserServiceInt;

import lombok.AllArgsConstructor;

//spring mvc controller to handle requests
@Controller
@AllArgsConstructor
@RequestMapping
public class SellerController {
	@Autowired
	private ItemServiceInt itemService;
	
	@Autowired
	private SellerRepoInt sellerRepo;
	
	@Autowired
	ItemRepoInt itemRepo;
	
	@GetMapping("/create_post")
	public String DisplayCreatePostForm(Model model) {
		model.addAttribute("item", new Item());
		return "create_post";
	}
	
	@PostMapping("/create_post")
	public String  savePostedItems(@RequestParam("itemName") String itemName,
			@RequestParam("itemPrice") Double itemPrice,
			@RequestParam("itemDescrip") String itemDescrip,HttpSession session)
			//,@RequestParam("itemQte") Integer itemQte
			//,@RequestParam("itemImage") MultipartFile itemImage) 
			{
		User user=(User)session.getAttribute("user");
		Seller seller=sellerRepo.findById(user.getId());
		Item item=new Item(itemName,itemPrice,itemDescrip,seller);
		itemService.save(item);//,itemQte, itemImage);
		return "redirect:/create_post?success";
	}
	
	@GetMapping("/items_list_by_seller")
	public String listItems(Model model,HttpSession session) {
		User user=(User)session.getAttribute("user");
		model.addAttribute("items",itemService.getAllItemsBySeller(user.getId()));
		return "items_list_by_seller";
	}	
	
	@GetMapping("/deleteSellerItem")
	public String deleteItem(@RequestParam Long id,Model model) {
		itemRepo.deleteById(id);
		//model.addAttribute("activepage","deleteItem");
		return "redirect:/items_list_by_seller";
	}
	
	@GetMapping("/displayUpdateSellerItemForm")
	public ModelAndView displayUpdateItemForm(@RequestParam Long id,Model model) {
		ModelAndView mav = new ModelAndView("create_post");
		Item item = itemRepo.findById(id);
		mav.addObject("item", item);
		//model.addAttribute("activepage","displayUpdateItemForm");
		return mav;
	}
	//private static final String PATH="/sellers_list";
	//private SellerServiceInt sellerService;
	/*handle list sellers request and return model and view*/
	/*@GetMapping(PATH)
	public String listSellers(Model model) {
		model.addAttribute("sellers",sellerService.getAllSellers());
		//spring boot automatically configure view resolver for thymleaf whenever it finds a thymleaf dependency in file path(pom.xml) no need to create view resolver bean for thymleaf manually
		//spring boot will find all thymleaf template under templates folder
		//display list of sellers in a view(sellers.html)
		return "sellers_list";
	}*/
}
