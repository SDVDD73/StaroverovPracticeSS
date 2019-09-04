package com.chat.simbir.controller;

import com.chat.simbir.model.entity.User;
import com.chat.simbir.service.RoomService;
import com.chat.simbir.service.RoomUserRepositoruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;

@Controller
public class ChatController {

    @Autowired
    RoomUserRepositoruService roomUserRepositoruService;

    @Autowired
    RoomService roomService;

    @RequestMapping("/publicChat")
    public String index(Model model,

                        @AuthenticationPrincipal User user) {
        model.addAttribute("roomId", "PublicChat");
        model.addAttribute("username", user.getUsername());

        return "chat";
    }

    @RequestMapping(path = "/chat/{roomId}", method = RequestMethod.GET)
    public String roomtest(@PathVariable Integer roomId,  @AuthenticationPrincipal User user, Model model) {
        model.addAttribute("roomId", roomId);
        model.addAttribute("username", user.getUsername());

        boolean isUserOfRoom = !roomUserRepositoruService.isUserOfRoom(user.getId(), roomId).isEmpty();
        boolean isRoomExists = roomService.isRoomExists(roomId);

        if (isUserOfRoom && isRoomExists){
            return "chat";
        }else {
            return "noAccess";
        }


    }
}
