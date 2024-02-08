-- liquibase formatted sql
-- changeset liquibase:002
CREATE TABLE posts
(
    id          SERIAL PRIMARY KEY,
    description VARCHAR NOT NULL UNIQUE,
    created     TIMESTAMP,
    user_id     INT REFERENCES users (id)
);
-- rollback DROP TABLE posts;
