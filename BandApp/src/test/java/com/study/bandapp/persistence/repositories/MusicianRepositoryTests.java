package com.study.bandapp.persistence.repositories;


import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.study.bandapp.enums.Instrument;
import com.study.bandapp.persistence.entities.MusicianEntity;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class MusicianRepositoryTests {
	
	@Autowired
	private MusicianRepository musicianRepository;
	
	MusicianEntity savedMusician;
	MusicianEntity musicianEntity;
	
	@BeforeEach
	void setup() {
		musicianEntity = MusicianEntity.builder()
				.id(33L)
				.name("John")
				.surname("Doe")
				.birthDate("1999")
				.instrument(Instrument.GUITAR)
				.build();
		
		savedMusician = musicianRepository.save(musicianEntity);
	}

	@Test
	public void testSaveMusician() {
		
		Assertions.assertThat(savedMusician).isNotNull();
		Assertions.assertThat(savedMusician.getId()).isGreaterThan(0);
		Assertions.assertThat(savedMusician.getName()).isEqualTo("John");
		Assertions.assertThat(savedMusician.getSurname()).isEqualTo("Doe");
		Assertions.assertThat(savedMusician.getBirthDate()).isEqualTo("1999");
		Assertions.assertThat(savedMusician.getInstrument()).isEqualTo(Instrument.GUITAR);
		
	}
	
	@Test
	public void testFindByIdMusician() {
		Optional<MusicianEntity> retreivedMusician = musicianRepository.findById(musicianEntity.getId());
		MusicianEntity retreivedMusicianEntity = retreivedMusician.get();

		Assertions.assertThat(retreivedMusicianEntity).isNotNull();
		Assertions.assertThat(retreivedMusicianEntity.getId()).isGreaterThan(0);
		Assertions.assertThat(retreivedMusicianEntity.getName()).isEqualTo("John");
		Assertions.assertThat(retreivedMusicianEntity.getSurname()).isEqualTo("Doe");
		Assertions.assertThat(retreivedMusicianEntity.getBirthDate()).isEqualTo("1999");
		Assertions.assertThat(retreivedMusicianEntity.getInstrument()).isEqualTo(Instrument.GUITAR);
		
	}
	
	@Test
	public void testFindAllMusician() {
		
	}

}
