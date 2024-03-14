package com.study.bandapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicianController {
	
	@GetMapping(path="/album/{id}")
	public void getAlbum() {
		
	}

	@PostMapping(path="/album")
	public void createAlbum() {
		
	}

}
