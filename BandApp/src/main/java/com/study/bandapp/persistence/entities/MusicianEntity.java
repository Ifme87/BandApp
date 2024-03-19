package com.study.bandapp.persistence.entities;

import com.study.bandapp.enums.Instrument;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="musicians")
public class MusicianEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(length = 100)
	private String surname;
	
	@Column(nullable = false)
	private String birthDate;
	
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
	private Instrument instrument;
	
}
