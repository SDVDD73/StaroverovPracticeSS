package com.chat.simbir.service;

import com.chat.simbir.model.entity.Role;
import com.chat.simbir.model.entity.Room;
import com.chat.simbir.model.entity.RoomUserRole;
import com.chat.simbir.model.entity.User;
import com.chat.simbir.model.repos.RoomUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomUserRepositoruService {

    @Autowired
    RoomUserRoleRepository roomUserRoleRepository;

    public List<Long> isUserOfRoom (long idUser, long idRoom){
        return roomUserRoleRepository.isUserofRoom(idUser, idRoom);
    }
}
