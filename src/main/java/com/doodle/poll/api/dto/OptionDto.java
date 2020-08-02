package com.doodle.poll.api.dto;

import java.sql.Timestamp;

import com.doodle.poll.domain.Option;
import com.doodle.poll.domain.OptionDate;
import com.doodle.poll.domain.OptionText;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
public class OptionDto {
	private String text;
	private Timestamp start;
	private Timestamp end;
	private Boolean allday;
	private Timestamp startDate;
	private Timestamp endDate;
	private boolean available;

	public OptionDto(Option option) {
		this.available = option.isAvailable();

		if (option instanceof OptionText) {
			this.text = ((OptionText) option).getText();
		}

		if (option instanceof OptionDate) {
			this.start = ((OptionDate) option).getStart();
			this.end = ((OptionDate) option).getEnd();
			this.allday = ((OptionDate) option).isAllday();
			this.startDate = ((OptionDate) option).getStartDate();
			this.endDate = ((OptionDate) option).getEndDate();
		}

	}
}
