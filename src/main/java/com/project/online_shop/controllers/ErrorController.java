package com.project.online_shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ErrorController {

    @GetMapping("/403")
    public String error() {
        return "/403";
    }
}
