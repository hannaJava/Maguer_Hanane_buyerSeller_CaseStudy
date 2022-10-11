//package com.hananemaguer.buyerseller.secureconfig;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.hananemaguer.buyerseller.service.UserServiceInt;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Configuration
//@EnableWebSecurity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
//	//
//	//@Autowired
//	//UserServiceInt interface should extends UserDetailsService interface
//	private UserServiceInt userService;
//	
//	//password encoder bean
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	//authentication bean
//	 @Bean
//	   public DaoAuthenticationProvider authenticationProvider(){
//	       DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//	       auth.setUserDetailsService(userService);
//	       auth.setPasswordEncoder(passwordEncoder());
//	       return auth;
//	   }
//	 
//	 @Override
//	 //pass the authentication bean as parameter 
//	 protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		 auth.authenticationProvider(authenticationProvider());
//	 }
//	 
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers(
//				"/sellers",
//				"/signup",
//				"/buyers",
//				"/js/**",
//				"img/**").permitAll()
//				.anyRequest()
//				.authenticated()
//				.and()
//				.formLogin()
//				.loginPage("/login")//add path to login page "/login"
//				.permitAll()
//				.and()
//				.logout()
//				.invalidateHttpSession(true)
//				.clearAuthentication(true)
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//"/logout"
//				.logoutSuccessUrl("/login?logout")//"login?logout" user navigate to login page with logout message//as thymleaf paramin login page
//				.permitAll();	
//	}
//}
