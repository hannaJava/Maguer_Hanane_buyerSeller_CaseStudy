package com.hananemaguer.buyerseller.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hananemaguer.buyerseller.service.UserServiceInt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/signup")
public class UserDtoController {

	//@Autowired
	private UserServiceInt userService;
	
	//create a bean for sign-up form use  where data contained in this form(sign-up) will be saved in this bean(user) 
	//this bean(user)mentioned in form tag as thymleaf object 
	//same as passing user as model in method()
	/*@ModelAttribute("user")
		public UserDto userDto() {
		return new UserDto();
	}*/
	
	//to handle user sign-up get request
	@GetMapping
	public String displaySignUpForm(Model model) {
		//create a bean for sign-up form use  where data contained in this form(sign-up) will be saved in this bean(user) 
		//this bean(user)mentioned in form tag as thymleaf object 
		model.addAttribute("user", new UserDto());//
		return "signup";
	}
	//to handle the sign-up form post request
	@PostMapping
	public String signUp(@ModelAttribute("user") UserDto userDto) {
		userService.save(userDto);
		return "redirect:/signup?success";//return sign-up view with success message displayed 
	}
}
