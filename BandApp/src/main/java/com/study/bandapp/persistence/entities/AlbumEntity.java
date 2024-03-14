package com.study.bandapp.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="albums")
public class AlbumEntity {
	
	@Id
	Long id;
	String name;
	String band;
	int releaseDate;
	String genre;
}
