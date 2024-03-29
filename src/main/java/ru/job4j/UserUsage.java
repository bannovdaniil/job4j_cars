package ru.job4j;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.model.Post;
import ru.job4j.model.User;
import ru.job4j.repository.PostRepository;
import ru.job4j.repository.PriceHistoryRepository;
import ru.job4j.repository.UserRepository;
import ru.job4j.repository.impl.CrudRepository;
import ru.job4j.repository.impl.PostRepositoryImpl;
import ru.job4j.repository.impl.PriceHistoryRepositoryImpl;
import ru.job4j.repository.impl.UserRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class UserUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            CrudRepository cr = new CrudRepository(sf);
            UserRepository userRepository = new UserRepositoryImpl(cr);

            PostRepository postRepository = new PostRepositoryImpl(cr);
            PriceHistoryRepository priceHistoryRepository = new PriceHistoryRepositoryImpl(cr);

            User user = new User();
            user.setLogin("admin");
            user.setPassword("admin");
            userRepository.create(user);
            userRepository.findAllOrderById().forEach(System.out::println);
            userRepository.findByLikeLogin("e").forEach(System.out::println);
            userRepository.findById(user.getId()).ifPresent(System.out::println);
            userRepository.findByLogin("admin").ifPresent(System.out::println);

            user.setPassword("password");
            userRepository.update(user);
            userRepository.findById(user.getId()).ifPresent(System.out::println);
            userRepository.delete(user.getId());
            userRepository.findAllOrderById().forEach(System.out::println);

            List<Post> postList = postRepository.findAll();
            for (Post post : postList) {
                System.out.println("post. = " + post);
            }

            postList = postRepository.findWithPhotos();
            for (Post post : postList) {
                System.out.println("post. = " + post);
            }

            postList = postRepository.findAll("ение 3");
            for (Post post : postList) {
                System.out.println("post. = " + post);
            }

            postList = postRepository.findAll(LocalDate.now());
            for (Post post : postList) {
                System.out.println("post. = " + post);
            }

            priceHistoryRepository.findAll().forEach(System.out::println);
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
