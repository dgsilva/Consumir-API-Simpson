package com.consumir.dto.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Episodio {
	
	private Long id;
	private String name;
	private Integer episode;
	private Integer season;
	private Double rating;
	private String description;
	private String airDate;

}
