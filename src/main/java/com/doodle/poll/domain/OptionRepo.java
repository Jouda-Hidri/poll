package com.doodle.poll.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepo extends CrudRepository<Option, Integer>{

}
