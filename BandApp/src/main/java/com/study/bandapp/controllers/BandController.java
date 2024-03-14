package com.study.bandapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BandController {
	
	@GetMapping(path="/band/{id}")
	public void getBand() {
		
	}

	@PostMapping(path="/band")
	public void createBand() {
		
	}

}
