package com.doodle.poll.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PollControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindByUser() throws Exception {
		mockMvc.perform(get("/poll").param("user", "mh+sample@doodle.com")).andExpect(status().isOk());
	}

	@Test
	public void testFindByTitle() throws Exception {
		mockMvc.perform(get("/poll").param("title", "Marvel"))
				.andExpect(status().isOk());
	}

	@Test
	public void testFindByDate() throws Exception {
		mockMvc.perform(get("/poll").param("afterDate", "2020-07-01 16:13:15.0")).andExpect(status().isOk());
	}

	@Test
	public void testBadRequest() throws Exception {
		mockMvc.perform(get("/poll").param("user", "mh+sample@doodle.com").param("afterDate", "2020-07-01 16:13:15.0"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testBadRequestWithoutParams() throws Exception {
		mockMvc.perform(get("/poll")).andExpect(status().isBadRequest());
	}

}
