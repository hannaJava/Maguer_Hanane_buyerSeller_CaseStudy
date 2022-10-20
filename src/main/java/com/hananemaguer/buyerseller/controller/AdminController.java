package com.hananemaguer.buyerseller.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hananemaguer.buyerseller.model.Buyer;
import com.hananemaguer.buyerseller.model.Item;
import com.hananemaguer.buyerseller.model.Seller;
import com.hananemaguer.buyerseller.model.User;
import com.hananemaguer.buyerseller.repository.BuyerRepoInt;
import com.hananemaguer.buyerseller.repository.ItemRepoInt;
import com.hananemaguer.buyerseller.repository.SellerRepoInt;
import com.hananemaguer.buyerseller.repository.UserRepoInt;
import com.hananemaguer.buyerseller.service.BuyerServiceInt;
import com.hananemaguer.buyerseller.service.ItemServiceInt;
import com.hananemaguer.buyerseller.service.SellerServiceInt;
import com.hananemaguer.buyerseller.service.UserServiceInt;

@Controller
@RequestMapping
public class AdminController {
	@Autowired
	ItemRepoInt itemRepo;
	
	@Autowired
	private ItemServiceInt itemService;
	
	@Autowired
	SellerRepoInt sellerRepo;
	
	@Autowired
	private SellerServiceInt sellerService;
	
	@Autowired
	BuyerRepoInt buyerRepo;
	
	@Autowired
	private BuyerServiceInt buyerService;
	
	@Autowired
	UserRepoInt userRepo;
	
	@Autowired
	private UserServiceInt userService;
	
	//items requests handling methods
	@GetMapping("/items_list")
	public String displayAllItems(Model model) {
		model.addAttribute("items",itemService.getAllItems());
		model.addAttribute("activepage","items_list");
		return "items_list";
	}

	@GetMapping("/displayUpdateItemForm")
	public ModelAndView displayUpdateItemForm(@RequestParam Long id,Model model) {
		ModelAndView mav = new ModelAndView("update_item");
		Item item = itemRepo.findById(id);
		mav.addObject("item", item);
		model.addAttribute("activepage","displayUpdateItemForm");
		return mav;
	}
	
	
	
	@GetMapping("/deleteItem")
	public String deleteItem(@RequestParam Long id,Model model) {
		itemRepo.deleteById(id);
		model.addAttribute("activepage","deleteItem");
		return "redirect:/items_list";
	}
	
	//sellers requests handling methods
	@GetMapping("/sellers_list")
	public String displayAllSellers(Model model) {
		model.addAttribute("sellers",sellerService.getAllSellers());
		model.addAttribute("activepage","sellers_list");
		return "sellers_list";
	}

	@GetMapping("/displayUpdateSellerForm")
	public ModelAndView displayUpdateSellerForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("signup");//to-do: change the signup form deactivate buyer/seller options
		Seller seller = sellerRepo.findById(id);
		mav.addObject("seller", seller);
		return mav;
	}
	
	@GetMapping("/deleteSeller")
	public String deleteSeller(@RequestParam Long id) {
		sellerRepo.deleteById(id);
		return "redirect:/sellers_list";
	}
	
	//buyers requests handling methods
	@GetMapping("/buyers_list")
	public String displayAllBuyers(Model model) {
		model.addAttribute("buyers",buyerService.getAllBuyers());
		return "buyers_list";
	}

	@GetMapping("/displayUpdateBuyerForm")
	public ModelAndView displayUpdateBuyerForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("signup");//to-do: change the signup form deactivate buyer/seller options
		Buyer buyer = buyerRepo.findById(id);
		mav.addObject("buyer", buyer);
		return mav;
	}
	
	@GetMapping("/deleteBuyer")
	public String deleteBuyer(@RequestParam Long id) {
		buyerRepo.deleteById(id);
		return "redirect:/buyers_list";
	}
	
	//users requests handling methods
		@GetMapping("/users_list")
		public String displayAllUsers(Model model) {
			model.addAttribute("users",userService.getAllUsers());
			return "users_list";
		}

		@GetMapping("/displayUpdateUserForm")
		public ModelAndView displayUpdateUserForm(@RequestParam Long id,Model model) {
			ModelAndView mav = new ModelAndView("user_update");//to-do: change the signup form deactivate buyer/seller options
			User user = userRepo.findById(id);
			mav.addObject("user", user);
			return mav;
		}
		
		@PostMapping("/user_update")
		public String updateUser(@ModelAttribute("user") User user) {
			 userRepo.updateById(user.getId(), user.getFirstName(), user.getLastName());
			return "user_update";
		}
		
		@GetMapping("/deleteUser")
		public String deleteUser(@RequestParam Long id) {
			User userType=userRepo.findById(id);
			//System.out.println("user for account type"+userType);
			//System.out.println("selected role "+role);
			 if (userType.getRoles().get(0).equals("seller")) {
		            //add data to seller table
				 sellerRepo.deleteById(id);
		        } else if (userType.getRoles().get(0).equals("buyer")) {
		            //add data to buyer table
		        	buyerRepo.deleteById(id);
		        } else if (userType.getRoles().get(0).equals("admin")) {
		            //add data to admin table
		        }
			 userRepo.deleteById(id);
			return "redirect:/users_list";
		}
		
		/*@GetMapping("/test")
		public String test(Model model){
			model.addAttribute("activepage","test");
			return "test";
		}*/
}
