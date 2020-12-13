CREATE TABLE departments (
  department_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  department_name VARCHAR(255) DEFAULT NULL,
  location_id INT(11) DEFAULT NULL,
  ADD CONSTRAINT fk1_dept FOREIGN KEY (location_id) REFERENCES locations (location_id)
);