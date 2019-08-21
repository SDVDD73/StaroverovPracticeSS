package com.chat.simbir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@Controller
public class HomeController {

    @GetMapping({"/", "home"})
    public String homePage(){
        return "home";
    }


}
