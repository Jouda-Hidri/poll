package com.doodle.poll.api;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doodle.poll.api.dto.PollDto;
import com.doodle.poll.service.PollService;

@RestController
public class PollController {

	@Autowired
	private PollService service;

	@GetMapping("/")
	public List<PollDto> findBy(@RequestParam(required = false) String user, @RequestParam(required = false) String title,
			@RequestParam(required = false) Integer afterDate) {
		if (user != null) {
			return service.findByUser(user);
		}
		if (title != null) {
			return service.findByTile(title);
		}
		/*
		if (afterDate != null) {
			try {
				return service.findLaterThan(afterDate.intValue());
			} catch (ParseException e) {
				// return 400
			}
		}*/
		return service.findAll();

	}
}
