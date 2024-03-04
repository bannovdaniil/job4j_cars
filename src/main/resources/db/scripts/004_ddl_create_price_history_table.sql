-- liquibase formatted sql
-- changeset liquibase:004
CREATE TABLE price_history
(
    id      SERIAL PRIMARY KEY,
    before  BIGINT NOT NULL,
    after   BIGINT NOT NULL,
    created TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    post_id INT    NOT NULL REFERENCES posts (id)
);
-- rollback DROP TABLE price_history;