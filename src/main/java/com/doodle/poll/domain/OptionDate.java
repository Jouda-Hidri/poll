package com.doodle.poll.domain;

import java.sql.Timestamp;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;

@Getter
@Entity
@DiscriminatorValue(value = "Date")
public class OptionDate extends Option {
	private Timestamp start;
    private Timestamp end;
    private boolean allday;
    private Timestamp startDate;
    private Timestamp endDate;
}
