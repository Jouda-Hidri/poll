package com.doodle.poll.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.doodle.poll.api.dto.PollDto;
import com.doodle.poll.domain.InitiatorRepo;
import com.doodle.poll.domain.PollRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PollService {

	private final PollRepo pollRepo;
	private final InitiatorRepo initiatorRepo;

	public List<PollDto> findByUser(String user) {
		return initiatorRepo.findByEmail(user).stream().flatMap(i -> i.getPolls().stream()).map(PollDto::new)
				.collect(Collectors.toList());
	}

	public List<PollDto> findByTitle(String title) {
		return pollRepo.findByTitle(title).stream().map(PollDto::new).collect(Collectors.toList());
	}

	public List<PollDto> findAfterDate(Date afterDate) {
		return pollRepo.findAfterDate(afterDate).stream().map(PollDto::new).collect(Collectors.toList());
	}
}
