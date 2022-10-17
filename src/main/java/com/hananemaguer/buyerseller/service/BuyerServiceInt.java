package com.hananemaguer.buyerseller.service;

import java.util.List;

import com.hananemaguer.buyerseller.model.Buyer;

//create interface and class implementation for loose coupling purposes
public interface BuyerServiceInt {
List<Buyer> getAllBuyers();
//to save buyer to db
Buyer save(Buyer buyer);
}
