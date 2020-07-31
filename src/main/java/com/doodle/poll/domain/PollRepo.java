package com.doodle.poll.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepo extends CrudRepository<Poll, String>{

	List<Poll> findByTitle(String title);
	
}
