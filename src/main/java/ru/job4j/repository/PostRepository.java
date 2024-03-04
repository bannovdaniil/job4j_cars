package ru.job4j.repository;

import lombok.RequiredArgsConstructor;
import ru.job4j.model.Post;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class PostRepository {
    private final CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param post - объявление.
     * @return post с id.
     */
    public Post create(Post post) {
        crudRepository.run(session -> session.persist(post));
        return post;
    }

    /**
     * Обновить объявление в базе.
     *
     * @param post - объявление.
     */
    public void update(Post post) {
        crudRepository.run(session -> session.merge(post));
    }

    /**
     * Удалить объявление по id.
     *
     * @param postId ID
     */
    public void delete(int postId) {
        crudRepository.run(
                "delete from Post where id = :postId",
                Map.of("postId", postId)
        );
    }

    /**
     * Список объявлений.
     *
     * @return список объявлений.
     */
    public List<Post> findAll() {
        return crudRepository.query("from Post", Post.class);
    }

    /**
     * Найти объявление по ID
     *
     * @return объявление.
     */
    public Optional<Post> findById(int postId) {
        return crudRepository.optional(
                "from Post where id = :postId", Post.class,
                Map.of("postId", postId)
        );
    }

}
