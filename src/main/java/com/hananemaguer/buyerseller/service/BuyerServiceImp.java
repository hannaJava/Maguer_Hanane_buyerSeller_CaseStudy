package com.hananemaguer.buyerseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hananemaguer.buyerseller.model.Buyer;
import com.hananemaguer.buyerseller.repository.BuyerRepoInt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service//("BuyerServiceInt")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerServiceImp implements BuyerServiceInt{
	@Autowired
	private BuyerRepoInt buyerRepo;

	@Override
	public List<Buyer> getAllBuyers() {
		//our BuyerServiceInterface(BuyerRep) implements the JPARepository 
		return buyerRepo.findAll();
	}

	@Override
	public Buyer save(Buyer buyer) {
		return buyerRepo.save(buyer);
	}
}
