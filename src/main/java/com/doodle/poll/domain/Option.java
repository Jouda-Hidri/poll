package com.doodle.poll.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Getter
@Entity
public class Option {
	
	@Id
	private Integer id; // not visible on dto
	private String text;
	private boolean available;
	@ManyToOne
	private Poll poll;

}
