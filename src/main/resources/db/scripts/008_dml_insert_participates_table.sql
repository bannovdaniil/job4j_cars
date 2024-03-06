-- liquibase formatted sql
-- changeset liquibase:008
INSERT INTO participates (user_id, post_id) VALUES (1, 1);
INSERT INTO participates (user_id, post_id) VALUES (2, 1);
INSERT INTO participates (user_id, post_id) VALUES (3, 1);
INSERT INTO participates (user_id, post_id) VALUES (1, 2);
-- rollback  DELETE FROM participates;