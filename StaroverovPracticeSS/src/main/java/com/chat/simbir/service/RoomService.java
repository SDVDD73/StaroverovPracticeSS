package com.chat.simbir.service;

import com.chat.simbir.model.entity.Room;
import com.chat.simbir.model.repos.RoomRepository;
import com.chat.simbir.model.repos.RoomUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public boolean isRoomExists(long idRoom){
        Room room = roomRepository.findById(idRoom);
        if ( room != null && room.isEnable()){
            return true;
        } else {
            return false;
        }
    }

    public Room getByRoom(long roomId){
        return roomRepository.findById(roomId);
    }

}
