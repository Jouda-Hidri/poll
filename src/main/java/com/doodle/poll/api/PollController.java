package com.doodle.poll.api;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;

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

// todo exception handling by the controller
	@GetMapping("/")
	public List<PollDto> findBy(@RequestParam(required = false) String user,
			@RequestParam(required = false) String title, @RequestParam(required = false) Timestamp afterDate) {

		if (user != null) {
			return service.findByUser(user);
		}
		if (title != null) {
			return service.findByTitle(title);
		}
		if (afterDate != null) {
			return service.findAfterDate(afterDate);
		}

		return service.findAll();
	}
}
