package com.chat.simbir.service;

import com.chat.simbir.model.entity.Role;
import com.chat.simbir.model.entity.Room;
import com.chat.simbir.model.entity.User;
import com.chat.simbir.model.repos.RoomUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomUserRepositoruService {

    @Autowired
    RoomUserRoleRepository roomUserRoleRepository;


}
