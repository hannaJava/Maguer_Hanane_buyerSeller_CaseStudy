package com.hananemaguer.buyerseller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hananemaguer.buyerseller.model.Item;

public interface ItemRepoInt extends JpaRepository<Item,String> {

}
