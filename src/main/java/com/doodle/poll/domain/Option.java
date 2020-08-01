package com.doodle.poll.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Getter
@Entity
public class Option {
	
	@Id
	@GeneratedValue
	private Long id;
	private String text;
	private boolean available;
	@ManyToOne
	private Poll poll;

}
