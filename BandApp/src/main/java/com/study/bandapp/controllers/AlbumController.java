package com.study.bandapp.controllers;

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

	@GetMapping(path="/albums/{id}")
	public ResponseEntity<AlbumDto> getAlbum(@PathVariable Long id) {
		var album = albumService.getAlbum(id);
		if (album != null) {
			return new ResponseEntity<AlbumDto>(album, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path="/albums")
	public ResponseEntity<AlbumDto> createAlbum(@RequestBody AlbumDto albumDto) {
		var album = albumService.createAlbum(albumDto);
		return new ResponseEntity<AlbumDto>(album, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/albums")
	public void getAllAlbum() {
		
	}
	
	@DeleteMapping(path="/albums")
	public void deleteAlbum() {
		
	}
	
	@PutMapping(path="/albums/{id}")
	public void updateAlbum() {
		
	}
	
}
