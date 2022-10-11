package com.hananemaguer.buyerseller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="items")
@Data
@NoArgsConstructor
public class Item {
	@Id
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="descrip")
	private String descrip;
	
	@Column(name="price")
	private String price;
}
