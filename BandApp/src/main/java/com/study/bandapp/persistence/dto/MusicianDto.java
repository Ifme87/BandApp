package com.study.bandapp.persistence.dto;

import com.study.bandapp.enums.Instrument;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicianDto {
	Long id;
	String name;
	String surname;
	String birthDate;
	Instrument instrument;
}