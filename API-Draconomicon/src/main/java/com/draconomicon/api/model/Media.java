package com.draconomicon.api.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "media")
@Getter
@Setter
@NoArgsConstructor
public class Media {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedia;

	@Column(name="media_text")
	private String mediaText;

	@Column(name="media_image", length = 25)
	private String mediaImage;

    @Column(name="media_date")
	private Date mediaDate;
	
	@Column(name="id_encyclopedie")
	@JoinTable(
			name="encyclopedie",
			joinColumns= {@JoinColumn(name="id_encyclopedie")}
			)
	private int idEncyclopedie;
}