package com.doodle.poll.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;

@Getter
@Entity
@DiscriminatorValue(value = "Text")
public class OptionText extends Option {
	private String text;
}
