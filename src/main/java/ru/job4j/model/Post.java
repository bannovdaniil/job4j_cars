package ru.job4j.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int id;
    private String description;
    private LocalDateTime created;
    private int user_id;
}
