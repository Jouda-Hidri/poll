package com.doodle.poll.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitiatorRepo extends CrudRepository<Initiator, Integer>{

	List<Initiator> findByEmail(String user);

}
