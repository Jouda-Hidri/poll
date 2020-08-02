package com.doodle.poll.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PollTest {

	@Test
	void shouldSplitInviteesList() {
		Poll poll = new Poll();
		poll.setInvitees("John Doe,Ringo");
		
		assertEquals(2, poll.getInviteesList().size());
		assertEquals("John Doe", poll.getInviteesList().get(0));
		assertEquals("Ringo", poll.getInviteesList().get(1));
	}

}
