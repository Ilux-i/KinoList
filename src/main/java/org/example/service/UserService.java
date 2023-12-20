package org.example.service;

import org.example.dto.columnDto.*;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    public void createdUser(CrudDto dto){
        var user = new UserEntity();
        user.setLogin(dto.login());
        user.setPassword(dto.password());
        repository.save(user);
    }
}
