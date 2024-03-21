package com.study.bandapp.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.bandapp.persistence.dto.AlbumDto;
import com.study.bandapp.service.AlbumService;

@RestController
public class AlbumController {
	
	AlbumService albumService;
	
	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}
	
	@GetMapping(path="/Albums/{id}")
	public ResponseEntity<AlbumDto> getAlbum(@PathVariable Long id) {
		var Album = albumService.getAlbum(id);
		if (Album != null) {
			return new ResponseEntity<AlbumDto>(Album, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path="/Albums")
	public ResponseEntity<AlbumDto> createAlbum(@RequestBody AlbumDto AlbumDto) {
		var Album = albumService.createAlbum(AlbumDto);
		return new ResponseEntity<AlbumDto>(Album, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/Albums")
	public ResponseEntity<List<AlbumDto>> getAllAlbums() {
		return new ResponseEntity<List<AlbumDto>>(albumService.getAllAlbums(), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/albums")
	public void deleteAlbum() {
		
	}
	
	@PutMapping(path="/albums/{id}")
	public void updateAlbum() {
		
	}
	
}
