package com.doodle.poll.domain;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;

@Getter
@Entity
public class Poll {
	
	@Id
	private String id; // todo
	private String adminKey;
	private BigInteger latestChange; // todo
	private BigInteger initiated; // todo
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
	@OneToMany
	private List<Option> options;
	private String optionHash;
	@OneToMany
	private List<Participant> participants;
	private String invitees; // todo list separation, assumption list of strings
	private String device; // todo enum
	private String levels; //todo enum
}
