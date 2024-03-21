package com.study.bandapp.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.bandapp.persistence.dto.BandDto;
import com.study.bandapp.persistence.entities.BandEntity;
import com.study.bandapp.persistence.repositories.BandRepository;

@Component
public class BandService {
	
	private BandRepository bandRepository;
	private ModelMapper modelMapper;

	@Autowired
	public BandService(BandRepository bandRepository, ModelMapper modelMapper) {
		this.bandRepository = bandRepository;
		this.modelMapper = modelMapper;
	}

	public BandDto getBand(Long id) {
		var Band = bandRepository.findById(id);
		if (Band.isPresent()) {
			return modelMapper.map(Band, BandDto.class);
		} else {
			return null;
		}
	}
		
	public BandDto createBand(BandDto bandDto) {
		var savedBand = bandRepository.save(modelMapper.map(bandDto, BandEntity.class));
		return modelMapper.map(savedBand, BandDto.class);
	}
	
	public List<BandDto> getAllBands() {
		var Bands = bandRepository.findAll();
		List<BandDto> result = new ArrayList<>();
		for (BandEntity a : Bands) {
			result.add(modelMapper.map(a, BandDto.class)); 
		}
		return result;
	}
}
