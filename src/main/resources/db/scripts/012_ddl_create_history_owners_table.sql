-- liquibase formatted sql
-- changeset liquibase:012
CREATE TABLE history_owners
(
    id       SERIAL PRIMARY KEY,
    car_id   INT REFERENCES cars (id),
    owner_id INT REFERENCES owners (id),
    UNIQUE (car_id, owner_id)
);
-- rollback DROP TABLE history_owners;