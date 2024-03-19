package com.study.bandapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.bandapp.persistence.repositories.AlbumRepository;
import com.study.bandapp.persistence.dto.*;
import com.study.bandapp.persistence.entities.AlbumEntity;

@Component
public class AlbumService {
	
	private AlbumRepository albumRepository;
	private ModelMapper modelMapper;

	@Autowired
	public AlbumService(AlbumRepository albumRepository, ModelMapper modelMapper) {
		this.albumRepository = albumRepository;
		this.modelMapper = modelMapper;
	}

	public AlbumDto getAlbum(Long id) {
		var album = albumRepository.findById(id);
		if (album.isPresent()) {
			return modelMapper.map(album, AlbumDto.class);
		} else {
			return null;
		}
	}
		
	public AlbumDto createAlbum(AlbumDto albumDto) {
		var savedAlbum = albumRepository.save(modelMapper.map(albumDto, AlbumEntity.class));
		return modelMapper.map(savedAlbum, AlbumDto.class);
	}
}

