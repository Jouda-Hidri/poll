package com.doodle.poll.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Getter
@Entity
public class Initiator {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private boolean notify;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "initiator")
	List<Poll> polls;
}
