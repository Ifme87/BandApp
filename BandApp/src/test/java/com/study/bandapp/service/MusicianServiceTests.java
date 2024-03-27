package com.study.bandapp.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.study.bandapp.enums.Instrument;
import com.study.bandapp.persistence.dto.MusicianDto;
import com.study.bandapp.persistence.entities.MusicianEntity;
import com.study.bandapp.persistence.repositories.MusicianRepository;

@ExtendWith(MockitoExtension.class)
public class MusicianServiceTests {
	
	@Mock
	private MusicianRepository musicianRepository;
	
	@Mock
	private ModelMapper modelMapper;
	
	@InjectMocks
	private MusicianService musicianServiceUnderTest;
	
	private MusicianDto musicianDto = MusicianDto.builder()
			.id(33L)
			.name("John")
			.surname("Doe")
			.birthDate("1999")
			.instrument(Instrument.GUITAR)
			.build();
	
	private MusicianEntity musicianEntity = MusicianEntity.builder()
			.id(33L)
			.name("John")
			.surname("Doe")
			.birthDate("1999")
			.instrument(Instrument.GUITAR)
			.build();
	
	@Test
	public void createMusicianTest() {
		Mockito.when(modelMapper.map(musicianDto, MusicianEntity.class)).thenReturn(musicianEntity);
		Mockito.when(modelMapper.map(musicianEntity, MusicianDto.class)).thenReturn(musicianDto);
		Mockito.when(musicianRepository.save(musicianEntity)).thenReturn(musicianEntity);
		
		MusicianDto savedMusician = musicianServiceUnderTest.createMusician(musicianDto);
		
		Assertions.assertThat(savedMusician).isNotNull();
		Assertions.assertThat(savedMusician.getId()).isGreaterThan(0);
		Assertions.assertThat(savedMusician.getName()).isEqualTo("John");
		Assertions.assertThat(savedMusician.getSurname()).isEqualTo("Doe");
		Assertions.assertThat(savedMusician.getBirthDate()).isEqualTo("1999");
		Assertions.assertThat(savedMusician.getInstrument()).isEqualTo(Instrument.GUITAR);
		
	}
	
	@Test
	public void getMusicianTest() {
		Mockito.when(musicianRepository.findById(musicianEntity.getId())).thenReturn(Optional.of(musicianEntity));
		Mockito.when(modelMapper.map(Optional.of(musicianEntity), MusicianDto.class)).thenReturn(musicianDto);
		
		MusicianDto retreivedMusician = musicianServiceUnderTest.getMusician(musicianDto.getId());
		
		Assertions.assertThat(retreivedMusician).isNotNull();
		Assertions.assertThat(retreivedMusician.getId()).isGreaterThan(0);
		Assertions.assertThat(retreivedMusician.getName()).isEqualTo("John");
		Assertions.assertThat(retreivedMusician.getSurname()).isEqualTo("Doe");
		Assertions.assertThat(retreivedMusician.getBirthDate()).isEqualTo("1999");
		Assertions.assertThat(retreivedMusician.getInstrument()).isEqualTo(Instrument.GUITAR);
		
	}
	
	@Test
	public void getAllMusiciansTest() {
		List<MusicianEntity> listOfMusicianEntities = new ArrayList<>();
		listOfMusicianEntities.add(musicianEntity);
		Iterable<MusicianEntity> result = listOfMusicianEntities;

		Mockito.when(musicianRepository.findAll()).thenReturn(result);
		Mockito.when(modelMapper.map(musicianEntity, MusicianDto.class)).thenReturn(musicianDto);
		
		List<MusicianDto> retreivedMusicianList = musicianServiceUnderTest.getAllMusicians();
		
		List<MusicianDto> templateToCompare = new ArrayList<>();
		templateToCompare.add(musicianDto);
		
		Assertions.assertThat(retreivedMusicianList).isNotNull();
		Assertions.assertThat(retreivedMusicianList).isEqualTo(templateToCompare);
		
		
	}
	 
	
	
	
	
	
	

}
