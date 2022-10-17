package com.hananemaguer.buyerseller.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hananemaguer.buyerseller.model.Buyer;
import com.hananemaguer.buyerseller.model.Role;
import com.hananemaguer.buyerseller.model.Seller;
import com.hananemaguer.buyerseller.model.User;
import com.hananemaguer.buyerseller.repository.UserRepoInt;
import com.hananemaguer.buyerseller.service.BuyerServiceInt;
import com.hananemaguer.buyerseller.service.SellerServiceInt;
import com.hananemaguer.buyerseller.service.UserServiceInt;

@Controller
public class MainController {

	@Autowired
	private UserServiceInt userService;
	
	@Autowired
	private UserRepoInt userRepo;
	
	@Autowired
	private BuyerServiceInt buyerService;
	
	@Autowired
	private SellerServiceInt sellerService;
	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}	
	
	//to handle user sign-up get request
		@GetMapping("/signup")
		public String displaySignUpForm(Model model) {
			model.addAttribute("user", new User());
			return "signup";
		}
		
		//to handle the sign-up form post request
		@PostMapping("/signup")
		public String signUp(@ModelAttribute("user") User user,@RequestParam("role") String role) {
			user.setRoles(Arrays.asList(new Role(role)));
			try {
				userService.save(user);
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
				return "redirect:/signup?error";
			}
			//save the buyer and seller entity data at same time
			User userType=userRepo.findByUsername(user.getUsername());
			System.out.println("user for account type"+userType);
			System.out.println("selected role "+role);
			 if (role.equals("seller")) {
		            //add data to seller table
				 sellerService.save(new Seller(userType.getId(), userType.getUsername(),userType.getPassword(),userType.getFirstName(),userType.getLastName(),role));
		        } else if (role.equals("buyer")) {
		            //add data to buyer table
		        	buyerService.save(new Buyer(userType.getId(), userType.getUsername(),userType.getPassword(),userType.getFirstName(),userType.getLastName(),role));
		        } else if (role.equals("admin")) {
		            //add data to admin table
		        }
			return "redirect:/signup?success";//return sign-up view with success message displayed 
		}
		
	@GetMapping("/admin")
	public String displayAdmin() {
		return "admin";
	}
	
	@GetMapping("/buyer")
	public String displayBuyer() {
		return "buyer";
	}
	
	@GetMapping("/seller")
	public String displaySeller() {
		return "seller";
	}
}
