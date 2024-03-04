package ru.job4j;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.model.User;
import ru.job4j.repository.CrudRepository;
import ru.job4j.repository.PostRepository;
import ru.job4j.repository.PriceHistoryRepository;
import ru.job4j.repository.UserRepository;

public class UserUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            CrudRepository cr = new CrudRepository(sf);
            UserRepository userRepository = new UserRepository(cr);

            PostRepository postRepository = new PostRepository(cr);
            PriceHistoryRepository priceHistoryRepository = new PriceHistoryRepository(cr);

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

            postRepository.findAll().forEach(System.out::println);
            priceHistoryRepository.findAll().forEach(System.out::println);
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
