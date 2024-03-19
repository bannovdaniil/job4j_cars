package ru.job4j.repository.impl;

import lombok.RequiredArgsConstructor;
import ru.job4j.model.PriceHistory;
import ru.job4j.repository.PriceHistoryRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class PriceHistoryRepositoryImpl implements PriceHistoryRepository {
    private final CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param priceHistory - история цены.
     * @return priceHistory с id.
     */
    @Override
    public PriceHistory create(PriceHistory priceHistory) {
        crudRepository.run(session -> session.persist(priceHistory));
        return priceHistory;
    }

    /**
     * Обновить историю цены в базе.
     *
     * @param priceHistory - история цены.
     */
    @Override
    public void update(PriceHistory priceHistory) {
        crudRepository.run(session -> session.merge(priceHistory));
    }

    /**
     * Удалить историю цены по id.
     *
     * @param priceHistoryId ID
     */
    @Override
    public void delete(int priceHistoryId) {
        crudRepository.run(
                "delete from PriceHistory where id = :priceHistoryId",
                Map.of("priceHistoryId", priceHistoryId)
        );
    }

    /**
     * Список истории цен.
     *
     * @return список объявлений.
     */
    @Override
    public List<PriceHistory> findAll() {
        return crudRepository.query("from PriceHistory", PriceHistory.class);
    }

    /**
     * Найти историю цены по ID
     *
     * @return объявление.
     */
    @Override
    public Optional<PriceHistory> findById(int priceHistoryId) {
        return crudRepository.optional(
                "from PriceHistory where id = :priceHistoryId", PriceHistory.class,
                Map.of("priceHistoryId", priceHistoryId)
        );
    }

}
