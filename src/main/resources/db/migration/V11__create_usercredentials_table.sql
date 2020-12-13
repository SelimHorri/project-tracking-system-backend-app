CREATE TABLE user_credentials (
  user_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) DEFAULT NULL,
  password VARCHAR(255) DEFAULT NULL,
  enabled BOOLEAN DEFAULT true,
  role VARCHAR(255) DEFAULT NULL,
  employee_id INT(11) DEFAULT NULL,
  ADD CONSTRAINT fk1_u FOREIGN KEY (employee_id) REFERENCES employees (employee_id)
);