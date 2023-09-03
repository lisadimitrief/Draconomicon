package com.draconomicon.api.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "commentaire")
@Getter
@Setter
@NoArgsConstructor
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComment;

	@Column(name="comment", length = 250)
	private String comment;

    @Column(name="date_comments")
	private Date dateComments;
    
    @Column(name="id_user")
    @JoinTable(
        name="user",
        joinColumns= {@JoinColumn(name="id_user")}
        )
	private int idUser;
	
    @Column(name="id_blog")
	@JoinTable(
			name="blog",
			joinColumns= {@JoinColumn(name="id_blog")}
			)
	private int idBlog;
}