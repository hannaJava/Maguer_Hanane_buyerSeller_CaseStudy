package com.hananemaguer.buyerseller.service;

import java.util.List;

import com.hananemaguer.buyerseller.model.Seller;

//create interface and class implementation for loose coupling purposes
public interface SellerServiceInt {
List<Seller> getAllSellers();
Seller save(Seller seller);
}
