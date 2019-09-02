package com.chat.simbir.controller;

import com.chat.simbir.model.entity.User;
import com.chat.simbir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    UserService userService;


    @GetMapping({"/", "home"})
    public String homePage(){

            List<String> dgdgdg = userService.getRolesOfUserFromRoom((long)1, (long)1);

            List<User> users = userService.getAll();

        return "home";
    }


}
