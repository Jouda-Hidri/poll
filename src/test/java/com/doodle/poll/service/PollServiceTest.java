package com.doodle.poll.service;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.doodle.poll.api.dto.PollDto;
import com.doodle.poll.domain.Device;
import com.doodle.poll.domain.Levels;
import com.doodle.poll.domain.PollType;
import com.doodle.poll.domain.PreferencesType;
import com.doodle.poll.domain.State;

@SpringBootTest
@RunWith(SpringRunner.class)
class PollServiceTest {

	@Autowired
	private PollService service;

	@Test
	void shouldFindPollsByUser() {
		List<PollDto> result = service.findByUser("mh+sample@doodle.com");

		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getInitiator().getEmail(), "mh+sample@doodle.com");
		assertEquals(result.get(0).getType(), PollType.TEXT);
		assertEquals(result.get(0).getPreferencesType(), PreferencesType.YESNO);
		assertEquals(result.get(0).getState(), State.OPEN);
		assertEquals(result.get(0).getLocale(), "fr_CH");
		assertEquals(result.get(0).getDevice(), Device.WEB);
		assertEquals(result.get(0).getLevels(), Levels.YESNO);
	}

	@Test
	void shouldFindPollsByTitle() {
		List<PollDto> result = service.findByTitle("Qui sont les superhéros Marvel les plus oufs?");

		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getTitle(), "Qui sont les superhéros Marvel les plus oufs?");
	}

	@Test
	void shouldFindPollsAfterDate() throws ParseException {
		List<PollDto> result = service.findAfterDate(Timestamp.valueOf("2020-07-01 16:13:15.0"));

		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getInitiated(), Timestamp.valueOf("2020-08-01 16:13:15.0"));
		assertEquals(result.get(0).getLatestChange(), Timestamp.valueOf("2020-08-01 16:12:28.0"));
	}

}
