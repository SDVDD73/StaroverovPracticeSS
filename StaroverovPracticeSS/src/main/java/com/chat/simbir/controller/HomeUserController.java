package com.chat.simbir.controller;

import com.chat.simbir.model.entity.User;
import com.chat.simbir.model.repos.UserRepository;
import com.chat.simbir.service.RoomUserRepositoruService;
import com.chat.simbir.service.UserService;
import com.chat.simbir.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeUserController {

    @Autowired
    UserService userService;



    @GetMapping("/homeUser")
    public String goHomeUser(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("username", "Добро пожаловать: " + user.getUsername());


        List<String> subscriptionsOnRoomOfUser = Converter.toArrayListString(
                userService.getSubscriptionsRoomsOfUser(user.getId()));

        Long idRoom = (long)3;

        makeLinkOnChat(subscriptionsOnRoomOfUser);

        model.addAttribute("subscriptionsOnRoomOfUser", subscriptionsOnRoomOfUser);

        return "homeUser";
    }


    private void makeLinkOnChat(List<String> subscriptionsOnRoomOfUser) {
        for (int index = 0; index < subscriptionsOnRoomOfUser.size(); index++) {
            subscriptionsOnRoomOfUser.set(index, "/chat/" + subscriptionsOnRoomOfUser.get(index));
        }
    }
}
