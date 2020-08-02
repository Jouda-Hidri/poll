package com.doodle.poll.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Getter
@Entity
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Option {
	
	@Id
	@GeneratedValue
	private Long id;
	private boolean available;
	@ManyToOne
	private Poll poll;

}
