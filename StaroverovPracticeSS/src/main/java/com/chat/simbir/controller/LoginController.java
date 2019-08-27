package com.chat.simbir.controller;

import com.chat.simbir.model.entity.User;
import com.chat.simbir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

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
        com.chat.simbir.model.entity.User userFromDB = userService.getByUser(user.getUsername());

        if (userFromDB != null) {
            model.put("message", "Юзер существует");
            return "/registration";
        }

        if (!validationPassword(user.getPassword())) {
            model.put("message", "введи нормальный пароль негодяй");
            return "/registration";
        }
            user.setEnable(true);
            //user.setRoles(Collections.singleton(Role.USER));
            userService.addUser(user);

            return "redirect:/login";

    }

    private boolean validationPassword(String password) {
        if (password != null && !password.isEmpty()) {
            return true;
        }
        return false;
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

