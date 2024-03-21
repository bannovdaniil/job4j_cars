package ru.job4j.repository;

import ru.job4j.model.Post;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post create(Post post);

    void update(Post post);

    void delete(int postId);

    List<Post> findAll();

    Optional<Post> findById(int postId);

    List<Post> findAll(LocalDate date);

    List<Post> findAll(String model);

    List<Post> findWithPhotos();

}
