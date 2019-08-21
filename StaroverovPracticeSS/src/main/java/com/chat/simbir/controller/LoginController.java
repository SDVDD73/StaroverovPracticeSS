package com.chat.simbir.controller;

import com.chat.simbir.model.entity.Role;
import com.chat.simbir.model.entity.User;
import com.chat.simbir.model.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession(true).invalidate();

        return "redirect:/";
    }

    @GetMapping("/registration")
    public String registration() {
        return "/registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        com.chat.simbir.model.entity.User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            model.put("message", "Юзер существует");
            return "/registration";
        }

        user.setEnable(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }




    /*@RequestMapping(path = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @PostMapping(path = "/login")
    public String doLogin(HttpServletRequest request, @RequestParam(defaultValue = "") String username)
    {

        request.getSession().setAttribute("username", username);

        return "redirect:/publicChat";
    }*/
}
