package org.example.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Table(name = "user", schema = "kino_list")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private ERole role = ERole.USER_ROLE;
}