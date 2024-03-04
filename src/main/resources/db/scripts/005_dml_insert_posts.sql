-- liquibase formatted sql
-- changeset liquibase:002
INSERT INTO posts (description, created, user_id) VALUES ('Объявление 1', '2024-03-04 12:30', 1);
INSERT INTO posts (description, created, user_id) VALUES ('Объявление 2', '2024-03-04 12:35', 1);
INSERT INTO posts (description, created, user_id) VALUES ('Объявление 3', '2024-03-04 12:40', 2);
INSERT INTO posts (description, created, user_id) VALUES ('Объявление 4', '2024-03-04 13:30', 3);
-- rollback DELETE FROM users;