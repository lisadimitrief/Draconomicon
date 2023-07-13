package com.draconomicon.api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "role")
@Getter
@Setter
@NoArgsConstructor
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;

	@Column(name="role", length = 15)
	private String role;
}