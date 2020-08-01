package com.doodle.poll.api.dto;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import com.doodle.poll.domain.Device;
import com.doodle.poll.domain.Levels;
import com.doodle.poll.domain.Poll;
import com.doodle.poll.domain.PollType;
import com.doodle.poll.domain.PreferencesType;
import com.doodle.poll.domain.State;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PollDto {

	private String id;
	private String adminKey;
	private Timestamp latestChange;
	private Timestamp initiated;
	private int participantsCount;
	private int inviteesCount;
	private PollType type;
	private boolean hidden;
	private PreferencesType preferencesType;
	private State state;
	private String locale;
	private String title;
	private InitiatorDto initiator;
	private List<OptionDto> options;
	private String optionHash;
	private List<ParticipantDto> participants;
	private List<String> invitees;
	private Device device;
	private Levels levels;

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
		this.levels = poll.getLevels();
	}

}
