package com.doodle.poll.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;

@Getter
@Entity
public class Poll {

	@Id
	private Integer id;
	private String adminKey;
	private Timestamp latestChange;
	private Timestamp initiated;
	private int participantsCount;
	private int inviteesCount;
	@Enumerated(EnumType.STRING)
	private PollType type;
	private boolean hidden;
	@Enumerated(EnumType.STRING)
	private PreferencesType preferencesType;
	@Enumerated(EnumType.STRING)
	private State state;
	private String locale;
	private String title;
	@ManyToOne
	private Initiator initiator;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "poll")
	private Set<Option> options;
	private String optionHash;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "poll")
	private Set<Participant> participants;
	private String invitees;
	@Enumerated(EnumType.STRING)
	private Device device;
	@Enumerated(EnumType.STRING)
	private Levels levels;

	public List<String> getInviteesList() {
		if (invitees == null || invitees.trim().isEmpty()) {
			return new ArrayList<String>();
		}
		return Arrays.stream(invitees.split(",")).collect(Collectors.toList());
	}
}
