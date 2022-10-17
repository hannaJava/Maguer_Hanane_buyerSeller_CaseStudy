package com.hananemaguer.buyerseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hananemaguer.buyerseller.model.Seller;
import com.hananemaguer.buyerseller.repository.SellerRepoInt;

import lombok.AllArgsConstructor;
import lombok.Data;

//by adding @Service we make this class a default implementation of SellerServiceInterface
//so this class will be called at runtime wherever SellerServiceInterface is used
@Service//("SellerServiceInt")
@Data
@AllArgsConstructor
//no need for autowired construction because this bean has only one constructor
public class SellerServiceImp implements SellerServiceInt{
	
	@Autowired
	private SellerRepoInt sellerRepo;

	@Override
	public List<Seller> getAllSellers() {
		//our SellerServiceInterface(sellerRep) implements the JPARepository 
		return sellerRepo.findAll();
	}

	@Override
	public Seller save(Seller seller) {
		
		return sellerRepo.save(seller);
	}
}
