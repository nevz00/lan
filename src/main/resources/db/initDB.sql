DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
  id               INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,PRIMARY KEY (id),
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

CREATE TABLE user_roles
(
  user_id INTEGER UNSIGNED NOT NULL,
  role    VARCHAR(100),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);