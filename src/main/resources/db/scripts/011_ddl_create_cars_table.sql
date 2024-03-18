-- liquibase formatted sql
-- changeset liquibase:011
CREATE TABLE cars
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(128),
    engine_id INT REFERENCES engines (id)
);
-- rollback DROP TABLE cars;