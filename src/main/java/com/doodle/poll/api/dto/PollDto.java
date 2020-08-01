package com.doodle.poll.api.dto;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import com.doodle.poll.domain.Poll;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PollDto {

	private Integer id; // todo
	private String adminKey;
	private Timestamp latestChange; // todo
	private Timestamp initiated; // todo
	private int participantsCount; // todo
	private int inviteesCount;
	private String type; // todo enum
	private boolean hidden;
	private String preferencesType; // todo enum
	private String state; // todo enum
	private String locale; // todo enum
	private String title;
	private InitiatorDto initiator;
	private List<OptionDto> options;
	private String optionHash;
	private List<ParticipantDto> participants;
	private List<String> invitees;
	private String device; // todo enum
	private String levels; // todo enum

	public PollDto(Poll poll) {
		this.id = poll.getId();
		this.adminKey = poll.getAdminKey();
		this.latestChange = poll.getLatestChange();
		this.initiated = poll.getInitiated();
		this.participantsCount = poll.getParticipantsCount();
		this.inviteesCount = poll.getInviteesCount();
		this.type = poll.getType();
		this.hidden = poll.isHidden();
		this.preferencesType = poll.getPreferencesType();
		this.state = poll.getState();
		this.locale = poll.getLocale();
		this.title = poll.getTitle();
		this.initiator = new InitiatorDto(poll.getInitiator());
		this.options = poll.getOptions().stream().map(OptionDto::new).collect(Collectors.toList());
		this.optionHash = poll.getOptionHash();
		this.participants = poll.getParticipants().stream().map(ParticipantDto::new).collect(Collectors.toList());
		this.invitees = poll.getInviteesList();
		this.device = poll.getDevice();

	}

}
