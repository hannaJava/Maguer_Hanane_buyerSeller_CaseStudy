package com.hananemaguer.buyerseller.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="sellers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
	@Id
	private long id;

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="role")
	private String role;
	
	@OneToMany//(mappedBy="seller")//,cascade=CascadeType.ALL)
	//@Column(name="posted_items")
	private List<Item> items;

	public Seller(long id, String username, String password, String firstName, String lastName, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
}
