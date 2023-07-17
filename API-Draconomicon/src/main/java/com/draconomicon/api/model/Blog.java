package com.draconomicon.api.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "blog")
@Getter
@Setter
@NoArgsConstructor
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBlog;

	@Column(name="titre", length = 25)
	private String titre;

    @Column(name="contenu")
	private String contenu;
    
    @Column(name="image", length = 25)
	private String image;
	
    @Column(name="date_blog")
	@CreationTimestamp
	private Timestamp dateBlog;
	
	@Column(name="id_user")
	@JoinTable(
			name="user",
			joinColumns= {@JoinColumn(name="id_user")}
			)
	private int idUser;
}