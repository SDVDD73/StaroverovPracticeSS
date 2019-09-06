package com.chat.simbir.controller;

import com.chat.simbir.model.entity.User;
import com.chat.simbir.service.RoomService;
import com.chat.simbir.service.RoomUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

    @Autowired
    RoomUserRoleService roomUserRepositoruService;

    @Autowired
    RoomService roomService;

    @RequestMapping(path = "/chat/{roomId}", method = RequestMethod.GET)
    public String roomtest(@PathVariable Integer roomId,  @AuthenticationPrincipal User user, Model model) {

        boolean isUserOfRoom = roomUserRepositoruService.isUserOfRoom(user.getId(), roomId);
        boolean isRoomExists = roomService.isRoomExists(roomId);

        if (!isRoomExists || !isUserOfRoom){
            return "noAccess";
        }

        String roomName = roomService.getByRoom(Long.valueOf(roomId)).getRoomName();

        model.addAttribute("roomId", roomId);
        model.addAttribute("roomName", roomName);
        model.addAttribute("username", user.getUsername());

        return "chat";
    }
}
