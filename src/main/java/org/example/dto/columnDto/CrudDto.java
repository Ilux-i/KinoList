package org.example.dto.columnDto;

public record CrudDto(
        Long id,
        String login,
        String password
) {
}
