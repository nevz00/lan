DELETE FROM user_roles;
DELETE FROM users;


INSERT INTO users (firstName, lastName, email) VALUES
  ('User','Name', 'user@yandex.ru'),
  ('Admin','Name2', 'admin@gmail.com');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);