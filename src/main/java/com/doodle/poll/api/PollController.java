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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PollController {

	@Autowired
	private PollService service;

	@Operation(summary = "List all polls by title or created by a given  user or after a given date")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the polls", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Invalid filter supplied", content = @Content) })
	@GetMapping("/poll")
	public ResponseEntity<List<PollDto>> findBy(
			@Parameter(description = "Email of user who created the poll ex. mh+sample@doodle.com") @RequestParam(required = false) String user,
			@Parameter(description = "Title of poll ex. Marvel") @RequestParam(required = false) String title,
			@Parameter(description = "Date after which poll was created ex. 2020-08-02 09:13:15") @RequestParam(required = false) Timestamp afterDate) {

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
