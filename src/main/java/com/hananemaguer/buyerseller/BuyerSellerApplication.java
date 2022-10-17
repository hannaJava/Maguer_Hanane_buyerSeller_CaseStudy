package com.hananemaguer.buyerseller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hananemaguer.buyerseller.model.Role;
import com.hananemaguer.buyerseller.model.User;
import com.hananemaguer.buyerseller.repository.UserRepoInt;

@SpringBootApplication
public class BuyerSellerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerSellerApplication.class, args);
		//admin user
		//User user=new User("admin@buyerseller.com","admin","root","root",Arrays.asList(new Role("admin")));
	}

}
