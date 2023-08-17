package com.draconomicon.api.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogResponse {
	private Long idBlog;
	private String avatar;
	private String username;
	private String titre;
	private String contenu;
	private Timestamp dateBlog;
}