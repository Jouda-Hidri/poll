package com.doodle.poll.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepo extends CrudRepository<Poll, Integer> {

	@Query("select p from Poll p where p.title like %:title%")
	List<Poll> searchByTitle(String title);

	@Query("select p from Poll p where p.initiated > :afterDate")
	List<Poll> findAfterDate(@Param("afterDate") Date afterDate);

}
