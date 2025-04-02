package com.ship.probe.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ship.probe.model.Coordinate;
import com.ship.probe.model.InitRequest;
import com.ship.probe.service.ProbeService;

@WebMvcTest(ProbeController.class)
@AutoConfigureMockMvc
public class ProbeControllerTest {
	
@Autowired	
private MockMvc mockMvc;

@Autowired
private ObjectMapper objectMapper;

@MockBean
private ProbeService probeService;

List<Coordinate> obstacles = new ArrayList<>();
	
@Test
void initialize() throws Exception
{
	Coordinate coordinate = new Coordinate();
	coordinate.setX(5);
	coordinate.setY(6);
	ProbeService service = mock(ProbeService.class);
	doNothing().when(service).initialize(0, 1, 2, 3, "NORTH", obstacles);
	InitRequest initRequest = new InitRequest(0, 1, 2, 3, "NORTH", obstacles);
	mockMvc.perform(post("/probe/initialize")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(initRequest)))
            .andExpect(status().isOk())

	.andExpect(MockMvcResultMatchers.content().string("Probe Initialized"));	 
}

}
