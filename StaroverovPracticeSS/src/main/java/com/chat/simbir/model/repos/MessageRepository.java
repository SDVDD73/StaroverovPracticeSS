package com.chat.simbir.model.repos;

import com.chat.simbir.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository  extends JpaRepository<Message, Long> {
}
