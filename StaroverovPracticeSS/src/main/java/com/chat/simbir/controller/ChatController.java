package com.chat.simbir.controller;

import com.chat.simbir.model.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ChatController {

    @RequestMapping("/publicChat")
    public String index(Model model,
                        @AuthenticationPrincipal User user) {

        model.addAttribute("username", user.getUsername());

        return "chat";
    }


    @RequestMapping(path = "/room/{roomid}")
    @ResponseBody
    public String roomtest(@PathVariable Integer roomid) {
        return "Hello " + roomid;
    }


}
