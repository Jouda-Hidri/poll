package com.doodle.poll.api;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.doodle.poll.api.dto.InitiatorDto;
import com.doodle.poll.api.dto.OptionDto;
import com.doodle.poll.api.dto.ParticipantDto;
import com.doodle.poll.api.dto.PollDto;
import com.doodle.poll.domain.Device;
import com.doodle.poll.domain.Levels;
import com.doodle.poll.domain.PollType;
import com.doodle.poll.domain.PreferencesType;
import com.doodle.poll.domain.State;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PollControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void testFindByUser() throws Exception {
		String response = mockMvc.perform(get("/poll").param("user", "mh+sample@doodle.com")).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		List<PollDto> polls = mapper.readValue(response, new TypeReference<List<PollDto>>() {
		});

		assertEquals(4, polls.size());
		PollDto poll = polls.get(0);
		InitiatorDto initiator = poll.getInitiator();
		assertEquals("mh+sample@doodle.com", initiator.getEmail());
		assertEquals("John Doe", initiator.getName());
		assertEquals("r44d7piq", poll.getAdminKey());
		assertEquals(true, poll.isHidden());
		assertEquals(PollType.TEXT, poll.getType());
		assertEquals(PreferencesType.YESNO, poll.getPreferencesType());
		assertEquals(State.OPEN, poll.getState());
		assertEquals("fr_CH", poll.getLocale());
		assertEquals(Device.WEB, poll.getDevice());
		assertEquals(Levels.YESNO, poll.getLevels());
		assertEquals(4, poll.getParticipantsCount());
		assertEquals(4, poll.getParticipants().size());
		assertEquals(0, poll.getInviteesCount());
		assertEquals(0, poll.getInvitees().size());
	}

	@Test
	public void testFindByTitle() throws Exception {
		String response = mockMvc.perform(get("/poll").param("title", "Marvel")).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString(StandardCharsets.UTF_8);
		List<PollDto> polls = mapper.readValue(response, new TypeReference<List<PollDto>>() {
		});

		assertEquals(2, polls.size());
		assertEquals("Qui sont les superhéros Marvel les plus oufs?", polls.get(0).getTitle());
		assertEquals(1, polls.get(0).getOptions().size());
		assertEquals("509166a0b12ed8e4ec658f0060aaf38e", polls.get(0).getOptionHash());
		final OptionDto option1 = polls.get(0).getOptions().get(0);
		assertEquals(null, option1.getStart());
		assertEquals(null, option1.getEnd());
		assertEquals(null, option1.getAllday());
		assertEquals(null, option1.getDate());
		assertEquals(null, option1.getStartDate());
		assertEquals(null, option1.getEndDate());
		assertEquals(true, option1.isAvailable());
		assertEquals("Pluto is a planet", option1.getText());
		assertEquals("Who are the most badass Marvel superheroes?", polls.get(1).getTitle());
		assertEquals("509166a0b12ed8e4ec658f0060aaf38e", polls.get(1).getOptionHash());
		assertEquals(1, polls.get(0).getOptions().size());
		final OptionDto option2 = polls.get(1).getOptions().get(0);
		assertEquals(Timestamp.valueOf("2020-08-02 10:55:13.0"), option2.getStart());
		assertEquals(Timestamp.valueOf("2020-08-02 10:52:54.0"), option2.getEnd());
		assertEquals(true, option2.getAllday());
		assertEquals(null, option1.getDate());
		assertEquals(Timestamp.valueOf("2020-08-02 10:53:46.0"), option2.getStartDate());
		assertEquals(Timestamp.valueOf("2020-08-02 10:54:37.0"), option2.getEndDate());
		assertEquals(true, option2.isAvailable());
		assertEquals(null, option2.getText());
		assertEquals(1, polls.get(1).getParticipants().size());
		final ParticipantDto participant = polls.get(1).getParticipants().get(0);
		assertEquals("John", participant.getName());
		assertEquals(2, participant.getPreferences().size());
		assertEquals(Integer.valueOf(1), participant.getPreferences().get(0));
		assertEquals(Integer.valueOf(0), participant.getPreferences().get(1));
	}

	@Test
	public void testFindByDate() throws Exception {
		String response = mockMvc.perform(get("/poll").param("afterDate", "2020-08-01 18:00:00.0"))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		List<PollDto> polls = mapper.readValue(response, new TypeReference<List<PollDto>>() {
		});

		assertEquals(3, polls.size());
		assertEquals(Timestamp.valueOf("2020-08-02 09:16:32.0"), polls.get(0).getInitiated());
		assertEquals(Timestamp.valueOf("2020-08-02 09:15:55.0"), polls.get(0).getLatestChange());
		assertEquals(Timestamp.valueOf("2020-08-02 09:24:52.0"), polls.get(1).getInitiated());
		assertEquals(Timestamp.valueOf("2020-08-02 09:24:21.0"), polls.get(1).getLatestChange());
		assertEquals(Timestamp.valueOf("2020-08-02 09:31:09.0"), polls.get(2).getInitiated());
		assertEquals(Timestamp.valueOf("2020-08-02 09:30:37.0"), polls.get(2).getLatestChange());

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
