package com.hananemaguer.buyerseller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hananemaguer.buyerseller.model.Item;

public interface ItemRepoInt extends JpaRepository<Item,String> {
	
	@Query("SELECT i FROM Item i JOIN FETCH i.seller")
	List<Item> findAll();
	
	List<Item> findBySellerId(long sellerId);
	
	Item findById(long id);
	
	@Query("SELECT i FROM Item i JOIN FETCH i.seller WHERE CONCAT(i.itemName,' ',i.itemDescrip) LIKE %:keyword%")
	//@Query("SELECT i FROM Item i JOIN FETCH i.seller WHERE i.itemName LIKE %:keyword% or i.itemDescrip LIKE %:keyword%")
	List<Item> search(String keyword);
	
	
	@Query(value ="DELETE FROM items WHERE items.id= :id", nativeQuery = true)
	void deleteById(Long id);
}
