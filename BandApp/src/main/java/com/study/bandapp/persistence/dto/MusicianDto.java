package com.study.bandapp.persistence.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MusicianDto {
	String name;
	Date birthDate;
	String instrument;
}
