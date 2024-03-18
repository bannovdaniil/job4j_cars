-- liquibase formatted sql
-- changeset liquibase:009
CREATE TABLE engines
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128)
);
-- rollback DROP TABLE engines;