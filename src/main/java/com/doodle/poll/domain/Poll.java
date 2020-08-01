package com.doodle.poll.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;

@Getter
@Entity
public class Poll {

	@Id
	private Integer id; // todo
	private String adminKey;
    private Timestamp  latestChange; // todo
    private Timestamp  initiated; // todo
	private int participantsCount; // todo
	private int inviteesCount;
	private String type; // todo enum
	private boolean hidden;
	private String preferencesType; // todo enum
	private String state; // todo enum
	private String locale; // todo enum
	private String title;
	@ManyToOne
	private Initiator initiator;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "poll")
	private Set<Option> options;
	private String optionHash;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "poll")
	private Set<Participant> participants;
	private String invitees; // todo list separation, assumption list of strings
	private String device; // todo enum
	private String levels; // todo enum

	public List<String> getInviteesList() {
		if (invitees == null || invitees.trim().isEmpty()) { // todo isBlank
			return new ArrayList<String>();
		}
		return Arrays.stream(invitees.split(",")) //
				.collect(Collectors.toList());
	}
}
