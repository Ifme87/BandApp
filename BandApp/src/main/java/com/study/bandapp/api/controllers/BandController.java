package com.study.bandapp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.bandapp.persistence.dto.BandDto;
import com.study.bandapp.service.BandService;


@RestController
public class BandController {
	
	BandService bandService;

	@Autowired
	public BandController(BandService bandService) {
		this.bandService = bandService;
	}
	
	@GetMapping(path="/bands/{id}")
	public ResponseEntity<BandDto> getband(@PathVariable Long id) {
		var band = bandService.getBand(id);
		if (band != null) {
			return new ResponseEntity<BandDto>(band, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path="/bands")
	public ResponseEntity<BandDto> createband(@RequestBody BandDto bandDto) {
		var band = bandService.createBand(bandDto);
		return new ResponseEntity<BandDto>(band, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/bands")
	public ResponseEntity<List<BandDto>> getAllbands() {
		return new ResponseEntity<List<BandDto>>(bandService.getAllBands(), HttpStatus.OK);
	}

}
