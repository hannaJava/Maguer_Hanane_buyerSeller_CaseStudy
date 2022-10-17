package com.hananemaguer.buyerseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hananemaguer.buyerseller.model.Buyer;


public interface BuyerRepoInt extends JpaRepository<Buyer,String>{

	public Buyer findById(long id);
	
	@Query(value ="DELETE FROM buyers WHERE buyers.id= :id", nativeQuery = true)
	void deleteById(Long id);
}
