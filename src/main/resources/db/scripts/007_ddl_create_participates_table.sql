-- liquibase formatted sql
-- changeset liquibase:007
CREATE TABLE participates
(
    id      SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES users (id),
    post_id INT NOT NULL REFERENCES posts (id),
    UNIQUE (user_id, post_id)
);
-- rollback DROP TABLE participates;