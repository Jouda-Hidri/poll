package com.doodle.poll.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Participant {

	@Id
	private Long id;
	private String name;
	@Setter
	private String preferences;
	@ManyToOne
	private Poll poll;

	public List<Integer> getPreferencesList() {
		if (preferences == null) {
			return new ArrayList<Integer>();
		}
		return Arrays.stream(preferences.split(",")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
	}

}
