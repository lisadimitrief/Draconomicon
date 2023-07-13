package com.draconomicon.api.model;

import jakarta.persistence.*;
import lombok.*;
// import com.draconomicon.api.model.Genre;

@Data
@Entity
@Table(name= "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;

	@Column(name="username", length = 20)
	private String username;

    @Column(name="mail", length = 30)
	private String mail;
    
    @Column(name="password", length = 256)
	private String password;
	
    @Column(name="age")
	private int age;
	
	@Column(name="id_genre")
	@JoinTable(
		name="genre",
		joinColumns= {@JoinColumn(name="genre")}
	)
	private int idGenre;
    
    @Column(name="avatar", length = 25)
	private String avatar;
    
    @Column(name="id_role")
	@JoinTable(
		name="role",
		joinColumns= {@JoinColumn(name="role")}
	)
	private int idRole;

}