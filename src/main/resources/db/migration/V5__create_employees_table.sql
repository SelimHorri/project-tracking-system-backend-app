CREATE TABLE employees (
  employee_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(255) DEFAULT NULL,
  last_name VARCHAR(255) DEFAULT NULL,
  email VARCHAR(255) DEFAULT 'springabcxyzboot@gmail.com',
  phone VARCHAR(50) DEFAULT '22125144',
  hiredate DATE DEFAULT NULL,
  job VARCHAR(255) DEFAULT NULL,
  salary DECIMAL(7,2) DEFAULT NULL,
  manager_id INT(11) DEFAULT NULL,
  department_id INT(11) DEFAULT NULL,
  ADD CONSTRAINT fk1_emp FOREIGN KEY (department_id) REFERENCES departments (department_id),
  ADD CONSTRAINT fk2_emp FOREIGN KEY (manager_id) REFERENCES employees (employee_id)
);