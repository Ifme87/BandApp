package com.study.bandapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.bandapp.persistence.dto.MusicianDto;
import com.study.bandapp.persistence.entities.MusicianEntity;
import com.study.bandapp.persistence.repositories.MusicianRepository;

@Component
public class MusicianService {
	
	private MusicianRepository musicianRepository;
	private ModelMapper modelMapper;

	@Autowired
	public MusicianService(MusicianRepository musicianRepository, ModelMapper modelMapper) {
		this.musicianRepository = musicianRepository;
		this.modelMapper = modelMapper;
	}

	public MusicianDto getMusician(Long id) {
		var musician = musicianRepository.findById(id);
		if (musician.isPresent()) {
			return modelMapper.map(musician, MusicianDto.class);
		} else {
			return null;
		}
	}
		
	public MusicianDto createMusician(MusicianDto musicianDto) {
		var savedMusician = musicianRepository.save(modelMapper.map(musicianDto, MusicianEntity.class));
		return modelMapper.map(savedMusician, MusicianDto.class);
	}

}
