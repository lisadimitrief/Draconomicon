package com.draconomicon.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	private String username;
	private String mail;
	private String password;
	private int age;
	private int idGenre;
	private int idRole;
}