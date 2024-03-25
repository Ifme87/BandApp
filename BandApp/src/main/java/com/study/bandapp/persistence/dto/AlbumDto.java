package com.study.bandapp.persistence.dto;

import com.study.bandapp.enums.Genre;

import lombok.Data;

@Data
public class AlbumDto{
	Long id;
	String name;
	BandDto band;
	int releaseDate;
	Genre genre;
}


