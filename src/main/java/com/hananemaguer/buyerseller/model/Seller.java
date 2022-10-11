package com.hananemaguer.buyerseller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="sellers")
@Data
@NoArgsConstructor
public class Seller {
	@Id
	@Column(name="email",nullable=false)
	private String email;
	
	@Column(name="username",nullable=false)
	private String username;
	
	@Column(name="password",nullable=false)
	private String password;
}
