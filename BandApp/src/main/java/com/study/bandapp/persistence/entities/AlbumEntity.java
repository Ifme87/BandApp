package com.study.bandapp.persistence.entities;

import com.study.bandapp.enums.Genre;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="albums")
public class AlbumEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "band_id", referencedColumnName = "id")
	@Column(nullable = false)
	private BandEntity band;
	
	@Column(nullable = false)
	private int releaseDate;
	
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre type;
}
