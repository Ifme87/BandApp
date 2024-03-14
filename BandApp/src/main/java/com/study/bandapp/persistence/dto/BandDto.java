package com.study.bandapp.persistence.dto;

import lombok.Data;

@Data
public class BandDto {
	String name;
	int estYear;
	String[] albums;
	String guitarOne;
	String guitarTwo;
	String bass;
	String vocals;
}
