package com.study.bandapp.persistence.dto;

import lombok.Builder;

@Builder
public record AlbumDto(	
		String name,
		BandDto band,
		int releaseDate,
		String genre
) {}


