package com.hananemaguer.buyerseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hananemaguer.buyerseller.model.Seller;

//the implemented interface already has @Repository and @Transactional annotations so no need to add this annotations here
//already get all crud methods to change database
public interface SellerRepoInt extends JpaRepository<Seller,String>{
	
	public Seller findById(long id);
	
	@Query(value ="DELETE FROM sellers WHERE sellers.id= :id", nativeQuery = true)
	void deleteById(Long id);
}
