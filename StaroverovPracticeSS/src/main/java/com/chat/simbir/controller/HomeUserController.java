package com.chat.simbir.controller;

import com.chat.simbir.model.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeUserController {

    @GetMapping("/homeUser")
    public String goHomeUser(Map<String, String> model,
                             @AuthenticationPrincipal User user) {


            model.put("username", "Добро пожаловать: " + user.getUsername());

        return "homeUser";
    }
}
