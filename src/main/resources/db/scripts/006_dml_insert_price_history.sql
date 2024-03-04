-- liquibase formatted sql
-- changeset liquibase:006
INSERT INTO price_history (before, after, post_id) VALUES (10, 100, 1);
INSERT INTO price_history (before, after, post_id) VALUES (110, 100, 1);
INSERT INTO price_history (before, after, post_id) VALUES (50, 60, 2);
INSERT INTO price_history (before, after, post_id) VALUES (60, 90, 2);
INSERT INTO price_history (before, after, post_id) VALUES (0, 45, 3);
-- rollback DELETE FROM price_history;