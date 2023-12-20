package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.dto.columnDto.CrudDto;

@Entity
@Getter
@Setter
@Table(name = "user", schema = "kino_list")
public class UserEntity {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String login;
    @Column
    String password;

    public CrudDto ofuserEntity(UserEntity entity){
        return new CrudDto(entity.getId(), entity.getLogin(), entity.getPassword());
    }
}