package com.draconomicon.api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "genre")
@Getter
@Setter
@NoArgsConstructor
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGenre;

	@Column(name="genre", length = 15)
	private String genre;
}