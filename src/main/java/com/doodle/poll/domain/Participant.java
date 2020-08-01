package com.doodle.poll.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;

@Getter
@Entity
public class Participant {

	@Id
	private Integer id; // todo
	private String name;
	private String preferences;
	@ManyToOne
	private Poll poll;

	public List<Integer> getPreferencesList() {
		if (preferences == null || preferences.trim().isEmpty()) { // todo isBlank
			return new ArrayList<Integer>();
		}
		return Arrays.stream(preferences.split(",")) //
				.map(s -> Integer.parseInt(s)) //
				.collect(Collectors.toList());
	}

}
