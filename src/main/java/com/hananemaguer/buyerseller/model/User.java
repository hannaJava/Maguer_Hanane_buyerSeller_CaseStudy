package com.hananemaguer.buyerseller.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="users" , uniqueConstraints=@UniqueConstraint(columnNames="email"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;

@Column(name="email")
private String email;

@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;

@Column(name="password")
private String password;

//Eager over lazy
//cascade All will include PERSIST, MERGE, REMOVE, REFRESH, DETACH applied to child entity when applied to parent entity
@ManyToMany(fetch =FetchType.EAGER,cascade=CascadeType.ALL)
@JoinTable(
		name="users_roles",
		joinColumns = @JoinColumn(name="user_id",referencedColumnName ="id"),
		inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName ="id")
		)
private Collection<Role> roles;

//needed in form creation 
public User(String email, String firstName, String lastName, String password, Collection<Role> roles) {
	super();
	this.email = email;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.roles = roles;
}

}
