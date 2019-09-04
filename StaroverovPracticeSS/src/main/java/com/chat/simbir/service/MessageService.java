package com.chat.simbir.service;

import com.chat.simbir.model.entity.Message;
import com.chat.simbir.model.entity.User;
import com.chat.simbir.model.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Transactional
    public Message seveMessage(Message message) {
        return messageRepository.save(message);
    }
}
