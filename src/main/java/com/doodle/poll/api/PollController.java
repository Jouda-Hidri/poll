package com.doodle.poll.api;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doodle.poll.api.dto.PollDto;
import com.doodle.poll.service.PollService;

@RestController
public class PollController {

	@Autowired
	private PollService service;

	@GetMapping("/poll")
	public ResponseEntity<List<PollDto>> findBy(@RequestParam(required = false) String user,
			@RequestParam(required = false) String title, @RequestParam(required = false) Timestamp afterDate) {

		if (user != null && title == null && afterDate == null) {
			return ResponseEntity.ok().body(service.findByUser(user));
		}

		if (title != null && user == null && afterDate == null) {
			return ResponseEntity.ok().body(service.findByTitle(title));
		}

		if (afterDate != null && user == null && title == null) {
			return ResponseEntity.ok().body(service.findAfterDate(afterDate));
		}

		return ResponseEntity.badRequest().build();
	}
}
