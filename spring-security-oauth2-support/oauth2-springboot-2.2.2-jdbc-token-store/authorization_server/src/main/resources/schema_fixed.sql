drop table if exists oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(255),
  token bytea,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

drop table if exists oauth_client_details;
CREATE TABLE oauth_client_details (
  client_id varchar(255) primary key,
  resource_ids varchar(255),
  client_secret varchar(255),
  scope varchar(255),
  authorized_grant_types varchar(255),
  web_server_redirect_uri varchar(255),
  authorities varchar(255),
  access_token_validity integer,
  refresh_token_validity integer,
  additional_information varchar(4096),
  autoapprove varchar(255)
);

drop table if exists oauth_access_token;
create table oauth_access_token (
  token_id VARCHAR(255),
  token bytea,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication bytea,
  refresh_token VARCHAR(255)
);

drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
  token_id VARCHAR(255),
  token bytea,
  authentication bytea
);

drop table if exists authority;
CREATE TABLE authority (
  id  integer,
  authority varchar(255),
  primary key (id)
);

drop table if exists credentials;
CREATE TABLE credentials (
  id  integer,
  enabled boolean not null,
  name varchar(255) not null,
  password varchar(255) not null,
  version integer,
  primary key (id)
);

drop table if exists credentials_authorities;
CREATE TABLE credentials_authorities (
  credentials_id bigint not null,
  authorities_id bigint not null
);

drop table if exists oauth_code;
create table oauth_code (
  code VARCHAR(255),
  authentication bytea
);

drop table if exists oauth_approvals;
create table oauth_approvals (
    userId VARCHAR(255),
    clientId VARCHAR(255),
    scope VARCHAR(255),
    status VARCHAR(10),
    expiresAt DATETIME,
    lastModifiedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
