package com.study.bandapp.persistence.dto;

import lombok.Builder;

@Builder
public record BandDto(
	String name,
	int estYear,
	AlbumDto albums,
	MusicianDto guitarOne,
	MusicianDto guitarTwo,
	MusicianDto bass,
	MusicianDto vocals
) {}
