package com.hananemaguer.buyerseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hananemaguer.buyerseller.model.Seller;

//the implemented interface already has @Repository and @Transactional annotations so no need to add this annotations here
//already get all crud methods to change database
public interface SellerRepoInt extends JpaRepository<Seller,String>{

}
