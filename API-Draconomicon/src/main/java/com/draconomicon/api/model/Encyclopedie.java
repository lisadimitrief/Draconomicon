package com.draconomicon.api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "encyclopedie")
@Getter
@Setter
@NoArgsConstructor
public class Encyclopedie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEncyclopedie;

	@Column(name="espece", length = 35)
	private String espece;

    @Column(name="carac_text")
	private String caracText;
    
    @Column(name="carac_image", length = 25)
	private String caracImage;
	
    @Column(name="myths_text")
	private String mythsText;
	
    @Column(name="myths_image", length = 25)
	private String mythsImage;
}