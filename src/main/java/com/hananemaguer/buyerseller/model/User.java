package com.hananemaguer.buyerseller.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users" , uniqueConstraints=@UniqueConstraint(columnNames="username"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;

@Column(name="username")
private String username;

@Column(name="password")
private String password;

/*@Column(name="role")
private String role;*/

@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;

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
public User( String username, String password, String firstName, String lastName,Collection<Role> roles) {
	super();
	
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
	this.password = password;
	this.roles=roles;
	//this.roles = roles;
}

public boolean hasRole(String roleName) {
    Iterator<Role> iterator = this.roles.iterator();
    while (iterator.hasNext()) {
        Role role = iterator.next();
        if (role.getName().equals(roleName)) {
            return true;
        }
    }
     
    return false;
}

//implemented 
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	 Collection<Role> roles = this.getRoles();
     List<SimpleGrantedAuthority> authorities = new ArrayList<>();
      
     for (Role role : roles) {
         authorities.add(new SimpleGrantedAuthority(role.getName()));
     }
     return authorities;
}

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return false;
}
}
