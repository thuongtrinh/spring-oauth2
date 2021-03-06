create table if not exists oauth_access_token (
    token_id VARCHAR(255),
    token BYTEA,
    authentication_id VARCHAR(255) PRIMARY KEY,
    user_name VARCHAR(255),
    client_id VARCHAR(255),
    authentication BYTEA,
    refresh_token VARCHAR(255)
);

create table if not exists oauth_refresh_token (
    token_id VARCHAR(255),
    token LONG VARBINARY,
    authentication LONG VARBINARY
);

INSERT INTO users (username,password,enabled) VALUES ('javadevelopertxt', 'secret', TRUE);