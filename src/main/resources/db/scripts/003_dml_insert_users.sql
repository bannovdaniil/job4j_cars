-- liquibase formatted sql
-- changeset liquibase:002
INSERT INTO users (login, password) VALUES ('Ivanov', 'root');
INSERT INTO users (login, password) VALUES ('Petrov', 'root');
INSERT INTO users (login, password) VALUES ('Sidorov', 'root');
-- rollback DELETE FROM users;