package com.hananemaguer.buyerseller.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hananemaguer.buyerseller.model.Item;
import com.hananemaguer.buyerseller.model.Seller;
import com.hananemaguer.buyerseller.model.User;


public interface ItemServiceInt {
Item save(Item item);
List<Item> getAllItems();
//Item save(String itemName, Double itemPrice, String itemDescrip,Seller seller);//, Integer itemQte, MultipartFile itemImage);
List<Item> getAllItemsBySeller(long id);
List<Item> getAllItemsByKeyword(String keyword);
}
