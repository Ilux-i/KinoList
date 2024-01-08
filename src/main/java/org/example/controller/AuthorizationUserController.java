package org.example.controller;

import jakarta.annotation.Resource;
import org.example.entity.UserEntity;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorizationUserController {

    @Resource
    private UserService service;

    @PostMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        var entity = new UserEntity();
        entity.setLogin(username);
        entity.setPassword(password);
        model.addAttribute(entity);
        return "login";
    }

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("username");
        return "login";
    }
}
