CREATE TABLE tariffs (
    id TEXT PRIMARY KEY NOT NULL,
    description TEXT NOT NULL DEFAULT ''
);

CREATE TABLE subscriptions (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    client TEXT NOT NULL,
    tariff_id TEXT NOT NULL REFERENCES tariffs(id),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT current_timestamp
);

CREATE TABLE payments (
    id BIGSERIAL NOT NULL PRIMARY KEY,

    subscription_id BIGINT NOT NULL REFERENCES subscriptions(id),
    created_at TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updated_at TIMESTAMP NOT NULL DEFAULT current_timestamp
);