package com.doodle.poll.api.dto;

import com.doodle.poll.domain.Option;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OptionDto {
	private String text;
	private boolean available;

	public OptionDto(Option option) {
		this.text = option.getText();
		this.available = option.isAvailable();
	}
}
