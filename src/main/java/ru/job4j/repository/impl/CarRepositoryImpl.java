package ru.job4j.repository.impl;

import lombok.RequiredArgsConstructor;
import ru.job4j.model.Car;
import ru.job4j.repository.CarRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class CarRepositoryImpl implements CarRepository {
    private final CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param car машина.
     * @return машина с id.
     */
    @Override
    public Car create(Car car) {
        crudRepository.run(session -> session.persist(car));
        return car;
    }

    /**
     * Обновить в базе машину.
     *
     * @param car машина.
     */
    @Override
    public void update(Car car) {
        crudRepository.run(session -> session.merge(car));
    }

    /**
     * Удалить машину по id.
     *
     * @param carId ID
     */
    @Override
    public void delete(int carId) {
        crudRepository.run(
                "delete from Car where id = :carId",
                Map.of("carId", carId)
        );
    }

    /**
     * Список машин.
     *
     * @return список.
     */
    @Override
    public List<Car> findAllOrderById() {
        return crudRepository.query("""
                        FROM Car c
                            LEFT JOIN FETCH c.engine
                            LEFT JOIN FETCH t.owners
                """, Car.class);
    }

    /**
     * Найти машину по ID
     *
     * @return машина.
     */
    @Override
    public Optional<Car> findById(int carId) {
        return crudRepository.optional("""
                                FROM Car c
                                    LEFT JOIN FETCH c.engine
                                    LEFT JOIN FETCH t.owners
                                WHERE c.id = :carId
                        """, Car.class,
                Map.of("carId", carId)
        );
    }
}
