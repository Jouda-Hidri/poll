package com.doodle.poll.api.dto;

import java.util.List;

import com.doodle.poll.domain.Participant;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ParticipantDto {

	private Integer id;
	private String name;
	private List<Integer> preferences;

	public ParticipantDto(Participant participant) {
		this.id = participant.getId();
		this.name = participant.getName();
		this.preferences = participant.getPreferencesList();
	}

}
