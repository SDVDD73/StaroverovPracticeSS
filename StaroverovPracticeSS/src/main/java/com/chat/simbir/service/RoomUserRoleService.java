package com.chat.simbir.service;

import com.chat.simbir.model.entity.RoomUserRole;
import com.chat.simbir.model.repos.RoomUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomUserRoleService {

    @Autowired
    RoomUserRoleRepository roomUserRoleRepository;

    public boolean isUserOfRoom (long idUser, long idRoom){

        return !roomUserRoleRepository.searchByIdUserAndIdRoom(idUser, idRoom).isEmpty();
    }

    public void save (RoomUserRole roomUserRole){
        roomUserRoleRepository.save(roomUserRole);
    }
}
