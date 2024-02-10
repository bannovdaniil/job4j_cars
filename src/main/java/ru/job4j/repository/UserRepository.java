package ru.job4j.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserRepository {
    private final SessionFactory sessionFactory;
    private static final Logger LOG = LoggerFactory.getLogger(UserRepository.class);

    /**
     * Сохранить в базе.
     *
     * @param user пользователь.
     * @return пользователь с id.
     */
    public User create(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return user;
    }

    /**
     * Обновить в базе пользователя.
     *
     * @param user пользователь.
     */
    public void update(User user) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query<User> query = session.createQuery("""
                    UPDATE User
                    SET login = :login,
                      password = :password
                    WHERE id = :userId
                    """, User.class
            );
            query.setParameter("login", user.getLogin())
                    .setParameter("password", user.getPassword())
                    .setParameter("userId", user.getId())
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    /**
     * Удалить пользователя по id.
     *
     * @param userId ID
     */
    public void delete(int userId) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query<User> query = session.createQuery("DELETE User WHERE id = :userId", User.class);
            query.setParameter("userId", userId).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    /**
     * Список пользователь отсортированных по id.
     *
     * @return список пользователей.
     */
    public List<User> findAllOrderById() {
        Session session = sessionFactory.openSession();
        List<User> userList = List.of();
        try {
            Query<User> query = session.createQuery("FROM User ORDER BY id", User.class);
            userList = query.list();
        } catch (Exception e) {
            LOG.error("Error findAllOrderById: {}", e.getMessage());
        } finally {
            session.close();
        }

        return userList;
    }

    /**
     * Найти пользователя по ID
     *
     * @return пользователь.
     */
    public Optional<User> findById(int userId) {
        Session session = sessionFactory.openSession();
        Optional<User> user = Optional.empty();
        try {
            Query<User> query = session.createQuery("FROM User u WHERE u.id = :userId", User.class);
            user = query.setParameter("userId", userId).uniqueResultOptional();
        } catch (Exception e) {
            LOG.error("Error findById: {}", e.getMessage());
        } finally {
            session.close();
        }

        return user;
    }

    /**
     * Список пользователей по login LIKE %key%
     *
     * @param key key
     * @return список пользователей.
     */
    public List<User> findByLikeLogin(String key) {
        Session session = sessionFactory.openSession();
        List<User> userList = List.of();
        try {
            Query<User> query = session.createQuery("FROM User u WHERE u.login LIKE :key", User.class);
            userList = query.setParameter("key", "%" + key + "%").list();

        } catch (Exception e) {
            LOG.error("Error findByLikeLogin: {}", e.getMessage());
        } finally {
            session.close();
        }

        return userList;
    }

    /**
     * Найти пользователя по login.
     *
     * @param login login.
     * @return Optional or user.
     */
    public Optional<User> findByLogin(String login) {
        Session session = sessionFactory.openSession();
        Optional<User> user = Optional.empty();
        try {
            Query<User> query = session.createQuery("FROM User u WHERE u.login = :login", User.class);
            user = query.setParameter("login", login).uniqueResultOptional();
        } catch (Exception e) {
            LOG.error("Error findByLogin: {}", e.getMessage());
        } finally {
            session.close();
        }

        return user;
    }
}
