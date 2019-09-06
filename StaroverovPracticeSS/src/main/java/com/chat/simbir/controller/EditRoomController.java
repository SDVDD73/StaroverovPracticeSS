package com.chat.simbir.controller;

import com.chat.simbir.model.entity.*;
import com.chat.simbir.service.RolesService;
import com.chat.simbir.service.RoomService;
import com.chat.simbir.service.RoomUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class EditRoomController {

    @Autowired
    RoomUserRoleService roomUserRoleService;

    @Autowired
    RolesService rolesService;

    @Autowired
    RoomService roomService;

    @GetMapping("editRoom")
    public String mappingEditChat(Model model){

        return "editRoom";
    }

    @PostMapping("editRoom")
    public String editChatPost(@AuthenticationPrincipal User user, Room room, Model model){

        try {
            roomService.createRoomWithAdmin(user, room);
            model.addAttribute("nameCreatedRoom", room.getRoomName() + "созданата");
            return "editRoom";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("nameCreatedRoom", "Ошибка создания комнаты");
            return "editRoom";
        }
    }

}
