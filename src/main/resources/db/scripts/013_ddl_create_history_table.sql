-- liquibase formatted sql
-- changeset liquibase:013
CREATE TABLE history
(
    id       SERIAL PRIMARY KEY,
    start_at TIMESTAMP WITHOUT TIME ZONE,
    end_at   TIMESTAMP WITHOUT TIME ZONE
);
-- rollback DROP TABLE history;