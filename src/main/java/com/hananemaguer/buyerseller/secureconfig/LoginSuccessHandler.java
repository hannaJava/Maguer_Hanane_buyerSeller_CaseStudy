package com.hananemaguer.buyerseller.secureconfig;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.hananemaguer.buyerseller.model.User;
import com.hananemaguer.buyerseller.repository.UserRepoInt;


 
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
 

	@Autowired
	private UserRepoInt userRepo;
	
	 @Autowired HttpSession session; //autowiring session
	 
	 private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);
	 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
 
    	 UserDetails userDetails = (UserDetails) authentication.getPrincipal();
         String username = userDetails.getUsername();
         
    	User user=userRepo.findByUsername(username);
         
        String redirectURL = request.getContextPath();
         
        if ( user.hasRole("seller")) {
            redirectURL = "seller";
        } else if (user.hasRole("buyer")) {
            redirectURL = "buyer";
        } else if (user.hasRole("admin")) {
            redirectURL = "admin";
        }
         
        response.sendRedirect(redirectURL);
        
         logger.info("current sesssion username is : " + username);
        //HttpSession session = request.getSession();
        session.setAttribute("user", user);
        System.out.println(" session attribute "+session.getAttribute("user"));
    }
 
}