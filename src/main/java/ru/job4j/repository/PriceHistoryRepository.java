package ru.job4j.repository;

import ru.job4j.model.PriceHistory;

import java.util.List;
import java.util.Optional;

public interface PriceHistoryRepository {
    PriceHistory create(PriceHistory priceHistory);

    void update(PriceHistory priceHistory);

    void delete(int priceHistoryId);

    List<PriceHistory> findAll();

    Optional<PriceHistory> findById(int priceHistoryId);
}
