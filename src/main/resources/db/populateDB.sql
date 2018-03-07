DELETE FROM user_roles;
DELETE FROM users;


INSERT INTO users (firstName, lastName, email,telephoneInner,mobilePhone, autoNumber, date, position, password) VALUES
  ('User','Name', 'user@yandex.ru','4506','123321','A6555','2015-08-25', 'worker', 'password'),
  ('Admin','Name2', 'admin@gmail.com','5580',' 545565', ' A65757', '2015-07-11', 'sysadmin', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);