package com.project.online_shop.controllers;

import com.project.online_shop.domain.Users;
import com.project.online_shop.service.UsersService;
import com.project.online_shop.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UsersService usersService;
    private UserValidator userValidator;

    @Autowired
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

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
    public String registration(@ModelAttribute("userForm") @Validated Users userForm, BindingResult bindingResult) {

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        usersService.saveUser(userForm);

        return "redirect:/login";
    }
}