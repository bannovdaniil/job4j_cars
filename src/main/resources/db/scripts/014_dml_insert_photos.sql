-- liquibase formatted sql
-- changeset liquibase:014
INSERT INTO photos (post_id, path, name) VALUES (1, '1.png', 'front view');
INSERT INTO photos (post_id, path, name) VALUES (1, '2.png', 'left side view');
INSERT INTO photos (post_id, path, name) VALUES (3, '3.png', 'front view');
INSERT INTO photos (post_id, path, name) VALUES (3, '4.png', 'top view');

-- rollback DELETE FROM photos;