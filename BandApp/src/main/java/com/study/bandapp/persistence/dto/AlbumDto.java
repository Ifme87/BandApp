package com.study.bandapp.persistence.dto;

import lombok.Data;

@Data
public class AlbumDto {
	String name;
	String band;
	int releaseDate;
	String genre;
}
