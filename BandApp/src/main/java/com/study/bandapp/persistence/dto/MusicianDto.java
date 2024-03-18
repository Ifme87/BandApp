package com.study.bandapp.persistence.dto;

import java.util.Date;

import lombok.Builder;

@Builder
public record MusicianDto (
	String name,
	String surname,
	Date birthDate,
	String instrument
) {}