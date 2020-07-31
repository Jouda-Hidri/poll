package com.doodle.poll.api.dto;

import com.doodle.poll.domain.Initiator;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InitiatorDto {
	private String name;
	private String email;
	private boolean notify;
	public InitiatorDto(Initiator initiator) {
		this.name = initiator.getName();
		this.email = initiator.getEmail();
		this.notify = initiator.isNotify();
	}
}
