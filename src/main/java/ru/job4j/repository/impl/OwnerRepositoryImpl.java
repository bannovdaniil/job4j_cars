package ru.job4j.repository.impl;

import lombok.RequiredArgsConstructor;
import ru.job4j.model.Owner;
import ru.job4j.repository.OwnerRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class OwnerRepositoryImpl implements OwnerRepository {
    private final CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param owner владелец.
     * @return владелец с id.
     */
    @Override
    public Owner create(Owner owner) {
        crudRepository.run(session -> session.persist(owner));
        return owner;
    }

    /**
     * Обновить в базе владелец.
     *
     * @param owner владелец.
     */
    @Override
    public void update(Owner owner) {
        crudRepository.run(session -> session.merge(owner));
    }

    /**
     * Удалить владельца по id.
     *
     * @param ownerId ID
     */
    @Override
    public void delete(int ownerId) {
        crudRepository.run(
                "delete from Owner where id = :ownerId",
                Map.of("ownerId", ownerId)
        );
    }

    /**
     * Список владельцев.
     *
     * @return список.
     */
    @Override
    public List<Owner> findAllOrderById() {
        return crudRepository.query("from Owner", Owner.class);
    }

    /**
     * Найти владельца по ID
     *
     * @return владелец.
     */
    @Override
    public Optional<Owner> findById(int ownerId) {
        return crudRepository.optional(
                "from Owner where id = :ownerId", Owner.class,
                Map.of("ownerId", ownerId)
        );
    }
}
