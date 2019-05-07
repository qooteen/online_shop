package com.project.online_shop.controllers;

import com.project.online_shop.domain.Roles;
import com.project.online_shop.domain.Users;
import com.project.online_shop.service.RolesService;
import com.project.online_shop.service.UsersService;
import com.project.online_shop.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private RolesService rolesService;

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setRolesService(RolesService rolesService) {
        this.rolesService = rolesService;
    }


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Users user, Model model) {
        Users userFromDb = usersService.findUsersByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(rolesService.getRolesByDescriptionrole("user"));
        usersService.saveUser(user);

        return "redirect:/login";
    }
}