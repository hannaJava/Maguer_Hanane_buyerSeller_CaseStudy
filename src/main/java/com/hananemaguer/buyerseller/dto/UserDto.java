package com.hananemaguer.buyerseller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	//same fields as user model class
	private String firstName;
	private String lastName;
	private String email;
	private String password;
}
