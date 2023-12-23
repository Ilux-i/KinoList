package org.example.controller;

import jakarta.annotation.Resource;
import org.example.dto.columnDto.CrudDto;
import org.example.dto.security.UserPrincipal;
import org.example.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Resource
    private UserService service;

    @PostMapping("create")
    public void createUser(@RequestParam("login") String login, @RequestParam("password") String password){
        var dto = new CrudDto(null, login, password);
        service.createdUser(dto);
    }

    @GetMapping("test")
    public UserPrincipal test(){
        var principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;
    }
}
