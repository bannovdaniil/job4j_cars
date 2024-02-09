package ru.job4j.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private int id;
    private String description;
    private LocalDateTime created;
    private int user_id;
}
