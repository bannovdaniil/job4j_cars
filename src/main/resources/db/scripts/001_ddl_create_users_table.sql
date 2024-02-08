-- liquibase formatted sql
-- changeset liquibase:001
CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    login    VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL
);
-- rollback DROP TABLE users;
