package com.study.bandapp.persistence.dto;

import com.study.bandapp.enums.Instrument;

import lombok.Data;

@Data
public class MusicianDto {
	String name;
	String surname;
	String birthDate;
	Instrument instrument;
}