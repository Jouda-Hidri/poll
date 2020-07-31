package com.doodle.poll.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Participant {
	
	@Id
	private int id; // todo
	private String name;
	private String preferences;
	@ManyToOne
	private Poll poll;

}
