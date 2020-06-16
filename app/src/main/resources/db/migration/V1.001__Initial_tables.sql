CREATE SCHEMA IF NOT EXISTS ub;

CREATE TABLE IF NOT EXISTS ub.accounts (
    id TEXT PRIMARY KEY NOT NULL
);

CREATE TABLE IF NOT EXISTS ub.plans (
    id          TEXT PRIMARY KEY NOT NULL,
    description TEXT             NOT NULL DEFAULT '',
    price       BIGINT           NOT NULL,
    active      BOOLEAN          NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS ub.subscriptions (
    id         BIGSERIAL NOT NULL PRIMARY KEY,
    account_id TEXT      NOT NULL REFERENCES ub.accounts(id),
    plan_id    TEXT      NOT NULL REFERENCES ub.plans(id),
    deleted    BOOLEAN   NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS ub.payments (
    id              BIGSERIAL NOT NULL PRIMARY KEY,
    subscription_id BIGINT    NOT NULL REFERENCES ub.subscriptions(id),
    created_at      TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updated_at      TIMESTAMP NOT NULL DEFAULT current_timestamp
);

CREATE TABLE IF NOT EXISTS ub.settings (
    name  TEXT NOT NULL,
    value TEXT NULL
);
