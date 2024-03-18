-- liquibase formatted sql
-- changeset liquibase:010
CREATE TABLE owners
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(128),
    user_id INT REFERENCES users (id)
);
-- rollback DROP TABLE owners;