
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
  id               INT UNSIGNED NOT NULL AUTO_INCREMENT,PRIMARY KEY (id),
  firstName             VARCHAR(100)                 NOT NULL,
  lastName             VARCHAR(100)                 NOT NULL,
  position             VARCHAR(100)                 NOT NULL,
  telephoneInner             VARCHAR(100)                 NOT NULL,
  mobilePhone             VARCHAR(100)                 NOT NULL,
  email            VARCHAR(64)                 NOT NULL,
  password         VARCHAR(15)                 NOT NULL,
  autoNumber         VARCHAR(15)                 NOT NULL,
  date       TIMESTAMP DEFAULT now() NOT NULL

)AUTO_INCREMENT = 100000;

CREATE UNIQUE INDEX users_unique_email_idx ON users (email);