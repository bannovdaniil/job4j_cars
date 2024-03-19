package ru.job4j.repository.impl;

import lombok.RequiredArgsConstructor;
import ru.job4j.model.Engine;
import ru.job4j.repository.EngineRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class EngineRepositoryImpl implements EngineRepository {
    private final CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param engine двигатель.
     * @return двигатель с id.
     */
    @Override
    public Engine create(Engine engine) {
        crudRepository.run(session -> session.persist(engine));
        return engine;
    }

    /**
     * Обновить в базе двигатель.
     *
     * @param engine двигатель.
     */
    @Override
    public void update(Engine engine) {
        crudRepository.run(session -> session.merge(engine));
    }

    /**
     * Удалить двигатель по id.
     *
     * @param engineId ID
     */
    @Override
    public void delete(int engineId) {
        crudRepository.run(
                "delete from Engine where id = :engineId",
                Map.of("engineId", engineId)
        );
    }

    /**
     * Список двигателей.
     *
     * @return список.
     */
    @Override
    public List<Engine> findAllOrderById() {
        return crudRepository.query("from Engine ", Engine.class);
    }

    /**
     * Найти двигатель по ID
     *
     * @return двигатель.
     */
    @Override
    public Optional<Engine> findById(int engineId) {
        return crudRepository.optional(
                "from Engine where id = :engineId", Engine.class,
                Map.of("engineId", engineId)
        );
    }
}
