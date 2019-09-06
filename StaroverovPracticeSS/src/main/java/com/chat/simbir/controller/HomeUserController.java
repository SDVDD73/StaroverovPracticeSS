package com.chat.simbir.controller;

import com.chat.simbir.model.dto.DtoTwoString;
import com.chat.simbir.model.entity.*;
import com.chat.simbir.model.repos.UserRepository;
import com.chat.simbir.service.RoomService;
import com.chat.simbir.service.RoomUserRepositoruService;
import com.chat.simbir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeUserController {

    @Autowired
    UserService userService;

    @GetMapping("/homeUser")
    public String goHomeUser(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", "Добро пожаловать: " + user.getUsername());

        List<Room> subscriptionsOnRoomsOfUser = userService.getSubscriptionsRoomsOfUser(user.getId());
        List<DtoTwoString> linksOnChatsAndNameChats = makeLinksOnChat(subscriptionsOnRoomsOfUser);

        model.addAttribute("linkOfChat", linksOnChatsAndNameChats);



        return "homeUser";
    }


    private List<DtoTwoString> makeLinksOnChat(List<Room> subscriptionsOnRoomOfUser) {
        List<DtoTwoString> linkOfChatAndNameChat = new ArrayList<>();

        for (int index = 0; index < subscriptionsOnRoomOfUser.size(); index++) {
            linkOfChatAndNameChat.add(new DtoTwoString(
                    "/chat/" + subscriptionsOnRoomOfUser.get(index).getId(),
                     (subscriptionsOnRoomOfUser.get(index).getRoomName())));
        }
        return linkOfChatAndNameChat;
    }
}
