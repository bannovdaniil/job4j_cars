-- liquibase formatted sql
-- changeset liquibase:013
CREATE TABLE photos
(
    id      SERIAL PRIMARY KEY,
    post_id INT REFERENCES posts (id),
    path    VARCHAR NOT NULL UNIQUE,
    name    VARCHAR NOT NULL
);
-- rollback DROP TABLE photos;