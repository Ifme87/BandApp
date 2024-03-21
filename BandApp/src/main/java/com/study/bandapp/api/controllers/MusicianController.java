package com.study.bandapp.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.bandapp.persistence.dto.MusicianDto;
import com.study.bandapp.service.MusicianService;

@RestController
public class MusicianController {
	
	MusicianService musicianService;
	
	public MusicianController(MusicianService musicianService) {
		this.musicianService = musicianService;
	}
	
	@GetMapping(path="/musicians/{id}")
	public ResponseEntity<MusicianDto> getMusician(@PathVariable Long id) {
		var musician = musicianService.getMusician(id);
		if (musician != null) {
			return new ResponseEntity<MusicianDto>(musician, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path="/musicians")
	public ResponseEntity<MusicianDto> createMusician(@RequestBody MusicianDto musicianDto) {
		var musician = musicianService.createMusician(musicianDto);
		return new ResponseEntity<MusicianDto>(musician, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/musicians")
	public ResponseEntity<List<MusicianDto>> getAllMusicians() {
		return new ResponseEntity<List<MusicianDto>>(musicianService.getAllMusicians(), HttpStatus.OK);
	}
}
