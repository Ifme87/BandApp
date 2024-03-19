package com.study.bandapp.persistence.dto;

import lombok.Data;

@Data
public class BandDto{
	String name;
	int estYear;
	AlbumDto albums;
	MusicianDto guitarOne;
	MusicianDto guitarTwo;
	MusicianDto bass;
	MusicianDto vocals;
}
