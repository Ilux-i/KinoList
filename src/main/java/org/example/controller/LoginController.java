package org.example.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.security.UserPrincipal;
import org.example.filter.UserAuthorisationFilter;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.example.filter.UserAuthorisationFilter.COOKIE_NAME;

@RestController
public class LoginController {
    private Map<String, String> userMap = new HashMap();

    {
        userMap.put("nikita", "pass123");
    }

    @GetMapping("/login")
    public void login(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            HttpServletResponse response
    ) {
        var passwordFromDb = userMap.get(login);
        if (passwordFromDb == null) {
            throw new BadCredentialsException("Пользователь с логином " + login + " не найден");
        }
        if (!passwordFromDb.equals(password)) {
            throw new BadCredentialsException("Введен неверный пароль");
        }
        var sessionId = UUID.randomUUID().toString();
        UserAuthorisationFilter.sessionMap.put(sessionId, login);
        response.addCookie(new Cookie(COOKIE_NAME, sessionId));
    }

    @GetMapping("test")
    public UserPrincipal test() {
        var principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;
    }
}
