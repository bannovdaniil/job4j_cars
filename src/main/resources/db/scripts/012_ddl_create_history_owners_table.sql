-- liquibase formatted sql
-- changeset liquibase:012
CREATE TABLE history_owners
(
    id       SERIAL PRIMARY KEY,
    car_id   INT REFERENCES cars (id),
    owner_id INT REFERENCES owners (id),
    start_at TIMESTAMP WITHOUT TIME ZONE,
    end_at   TIMESTAMP WITHOUT TIME ZONE
);
-- rollback DROP TABLE history_owners;