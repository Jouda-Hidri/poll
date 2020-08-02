package com.doodle.poll.domain;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ParticipantTest {

	@Test
	void shouldSplitPreferencesList() {
		Participant participant = new Participant();
		participant.setPreferences("0,1,0");

		assertEquals(3, participant.getPreferencesList().size());
		assertEquals(Integer.valueOf(0), participant.getPreferencesList().get(0));
		assertEquals(Integer.valueOf(1), participant.getPreferencesList().get(1));
		assertEquals(Integer.valueOf(0), participant.getPreferencesList().get(2));
	}

}
