package com.hananemaguer.buyerseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hananemaguer.buyerseller.model.Buyer;

public interface BuyerRepoInt extends JpaRepository<Buyer,String>{

}
