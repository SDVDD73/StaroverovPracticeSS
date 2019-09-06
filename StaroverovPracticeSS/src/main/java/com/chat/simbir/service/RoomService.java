package com.chat.simbir.service;

import com.chat.simbir.model.entity.Role;
import com.chat.simbir.model.entity.Room;
import com.chat.simbir.model.entity.RoomUserRole;
import com.chat.simbir.model.entity.User;
import com.chat.simbir.model.repos.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RolesService rolesService;

    @Autowired
    RoomUserRoleService roomUserRoleService;


    public boolean isRoomExists(long idRoom){
        Room room = roomRepository.findById(idRoom);
        return room != null && room.isEnable() ? true : false;

    }

    public Room getByRoom(long roomId){
        return roomRepository.findById(roomId);
    }

    public void save(Room room){
        roomRepository.save(room);
    }

    public void createRoomWithAdmin(User user, Room room) {
        room.setEnable(true);
        save(room);

        RoomUserRole roomUserRole = new RoomUserRole();
        roomUserRole.setUser(user);
        roomUserRole.setRoom(room);
        roomUserRole.setRole(rolesService.findByRole(Role.ADMIN));
        roomUserRole.setEnable(true);
        roomUserRoleService.save(roomUserRole);
    }
}
