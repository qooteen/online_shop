package com.project.online_shop.controllers;

import com.project.online_shop.domain.Users;
import com.project.online_shop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Users());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registration(@ModelAttribute Users userForm, Model model) {
        Users users = usersService.findByUsername(userForm.getUsername());
        if (users == null) {
            usersService.saveUser(userForm);
            return "redirect:/login";
        }
        model.addAttribute("error", "Already exists");
        model.addAttribute("userForm", userForm);

        return "registration";
    }
}