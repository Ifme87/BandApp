package com.study.bandapp.api.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.bandapp.enums.Instrument;
import com.study.bandapp.persistence.dto.MusicianDto;
import com.study.bandapp.service.MusicianService;

@WebMvcTest(controllers = MusicianController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(SpringExtension.class)
public class MusicianControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MusicianService musicianService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private MusicianDto musicianDto = MusicianDto.builder()
			.id(33L)
			.name("John")
			.surname("Doe")
			.birthDate("1999")
			.instrument(Instrument.GUITAR)
			.build();
	
	@Test
	public void testGetMusician() throws Exception {
		
		Mockito.when(musicianService.getMusician(musicianDto.getId()))
			.thenReturn(musicianDto);
		
		ResultActions response = mockMvc.perform(get("/musicians/" + musicianDto.getId().toString()));
		
		response.andExpect(MockMvcResultMatchers.status().isOk())
    		.andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(musicianDto.getName())))
    		.andExpect(MockMvcResultMatchers.jsonPath("$.surname", CoreMatchers.is(musicianDto.getSurname())))
    		.andExpect(MockMvcResultMatchers.jsonPath("$.birthDate", CoreMatchers.is(musicianDto.getBirthDate())))
    		.andExpect(MockMvcResultMatchers.jsonPath("$.instrument", CoreMatchers.is("GUITAR")));

	}
	
	@Test
	public void testPostMusician() throws Exception {
		
		Mockito.when(musicianService.createMusician(musicianDto))
			.thenReturn(musicianDto);
		
		ResultActions response = mockMvc.perform(post("/musicians")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(musicianDto)));
		
		response.andExpect(MockMvcResultMatchers.status().isCreated())
        	.andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(musicianDto.getName())))
        	.andExpect(MockMvcResultMatchers.jsonPath("$.surname", CoreMatchers.is(musicianDto.getSurname())))
        	.andExpect(MockMvcResultMatchers.jsonPath("$.birthDate", CoreMatchers.is(musicianDto.getBirthDate())))
        	.andExpect(MockMvcResultMatchers.jsonPath("$.instrument", CoreMatchers.is("GUITAR")));
	
	}
	
	@Test
	public void testGetAllMusician() throws Exception {
		
		List<MusicianDto> result = new ArrayList<>();
		result.add(musicianDto);
		
		Mockito.when(musicianService.getAllMusicians()).thenReturn(result);
		
		ResultActions response = mockMvc.perform(get("/musicians"));
		
		response.andExpect(MockMvcResultMatchers.status().isOk())
			.equals(result);
		
	}
	
}
