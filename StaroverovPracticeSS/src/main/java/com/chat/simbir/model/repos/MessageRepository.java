package com.chat.simbir.model.repos;

import com.chat.simbir.model.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository  extends CrudRepository<Message, Integer> {
}
