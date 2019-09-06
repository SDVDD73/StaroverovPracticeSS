package com.chat.simbir.controller;

import com.chat.simbir.constant.Constants;
import com.chat.simbir.model.entity.*;
import com.chat.simbir.service.RolesService;
import com.chat.simbir.service.RoomUserRoleService;
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

    @Autowired
    RoomUserRoleService RoomUserRoleService;

    @Autowired
    RolesService rolesServices;

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
        User userFromDB = userService.getByUser(user.getUsername());

        if (isExistingUser(model, userFromDB)) return "/registration";

        if (isNotValidationPassword(user, model)) return "/registration";

        user.setEnable(true);


        userService.addUserWithRoom(user, Constants.ID_PUBLIC_ROOM);


        return "redirect:/login";

    }

    private boolean isNotValidationPassword(User user, Map<String, Object> model) {
        if (!validationPassword(user.getPassword())) {
            model.put("message", "введи нормальный пароль негодяй");
            return true;
        }
        return false;
    }

    private boolean isExistingUser(Map<String, Object> model, User userFromDB) {
        if (userFromDB != null) {
            model.put("message", "Юзер существует");
            return true;
        }
        return false;
    }

    private void addUserPublicRoom(User user) {
        Roles role = rolesServices.findByRole(Role.USER);
        int idPublicRoom = 1;

        RoomUserRole roomUserRole = new RoomUserRole(user,
                new Roles(role.getId()),
                new Room(idPublicRoom),
                true);

        RoomUserRoleService.save(roomUserRole);
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

