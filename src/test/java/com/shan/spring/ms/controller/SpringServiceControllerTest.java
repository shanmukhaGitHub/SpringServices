package com.shan.spring.ms.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.shan.spring.ms.model.AlphaNumericPojo;
import com.shan.spring.ms.service.GeneratePhoneService;

@WebMvcTest(GeneratePhoneNumbersController.class)
public class SpringServiceControllerTest {

	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GeneratePhoneService service;
	
	
	@Test
	public void generatePhone_WhenIncorrectNumberProvided() throws Exception {
		when(service.getPhoneCombinationList("124")).thenReturn(new AlphaNumericPojo());
		this.mockMvc.perform(get("http://localhost:8080/generatePhoneCombinations")).andDo(print()).andExpect(status().isNotFound())
				;
	}

	
	@Test
	public void generatePhone_WhenCorrectNumberProvided() throws Exception {
		when(service.getPhoneCombinationList("124")).thenReturn(new AlphaNumericPojo());
		this.mockMvc.perform(get("http://localhost:8080/generatePhoneCombinations/34534")).andDo(print()).andExpect(status().isOk())
				;
	}

}
