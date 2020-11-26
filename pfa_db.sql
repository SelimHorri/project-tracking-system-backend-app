
DROP DATABASE IF EXISTS pfa_db;

CREATE DATABASE pfa_db;
USE pfa_db;

CREATE TABLE assignments (
  employee_id INT NOT NULL,
  project_id INT NOT NULL,
  commit_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  commit_emp_desc VARCHAR(200) DEFAULT NULL,
  commit_mgr_desc VARCHAR(200) DEFAULT NULL
);

CREATE TABLE departments (
  department_id INT NOT NULL,
  department_name VARCHAR(200) DEFAULT NULL,
  location_id INT DEFAULT NULL
);

CREATE TABLE employees (
  employee_id INT NOT NULL,
  first_name VARCHAR(200) DEFAULT NULL,
  last_name VARCHAR(200) DEFAULT NULL,
  email VARCHAR(200) DEFAULT NULL,
  phone VARCHAR(20) DEFAULT NULL,
  hiredate DATE DEFAULT NULL,
  job VARCHAR(200) DEFAULT NULL,
  salary decimal(7, 2) DEFAULT NULL,
  manager_id INT DEFAULT NULL,
  department_id INT DEFAULT NULL
);

CREATE TABLE locations (
  location_id INT NOT NULL,
  adr VARCHAR(200) DEFAULT NULL,
  postal_code VARCHAR(200) DEFAULT NULL,
  city VARCHAR(200) DEFAULT NULL
);

CREATE TABLE projects (
  project_id INT NOT NULL,
  title VARCHAR(200) DEFAULT NULL,
  start_date DATE DEFAULT NULL,
  end_date DATE DEFAULT NULL,
  status VARCHAR(200) DEFAULT NULL
);

CREATE TABLE user_credentials (
  user_id INT NOT NULL,
  username VARCHAR(200) DEFAULT NULL,
  password VARCHAR(200) DEFAULT NULL,
  enabled boolean DEFAULT true,
  role VARCHAR(200) DEFAULT NULL,
  employee_id INT DEFAULT NULL
);





ALTER TABLE assignments
  ADD PRIMARY KEY (employee_id, project_id, commit_date),
  ADD KEY fk1_assign (project_id);

ALTER TABLE departments
  ADD PRIMARY KEY (department_id),
  ADD KEY fk1_dept (location_id);

ALTER TABLE employees
  ADD PRIMARY KEY (employee_id),
  ADD UNIQUE KEY uk1_emp (email),
  ADD KEY fk1_emp (department_id),
  ADD KEY fk2_emp (manager_id);

ALTER TABLE locations
  ADD PRIMARY KEY (location_id);

ALTER TABLE projects
  ADD PRIMARY KEY (project_id);

ALTER TABLE user_credentials
  ADD PRIMARY KEY (user_id),
  ADD UNIQUE KEY uk1_u (username),
  ADD KEY fk1_u (employee_id);





ALTER TABLE departments
  MODIFY department_id INT(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE employees
  MODIFY employee_id INT(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE locations
  MODIFY location_id INT(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE projects
  MODIFY project_id INT(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE user_credentials
  MODIFY user_id INT(11) NOT NULL AUTO_INCREMENT;





ALTER TABLE assignments
  ADD CONSTRAINT fk1_assign FOREIGN KEY (project_id) REFERENCES projects (project_id),
  ADD CONSTRAINT fk2_assign FOREIGN KEY (employee_id) REFERENCES employees (employee_id);

ALTER TABLE departments
  ADD CONSTRAINT fk1_dept FOREIGN KEY (location_id) REFERENCES locations (location_id);

ALTER TABLE employees
  ADD CONSTRAINT fk1_emp FOREIGN KEY (department_id) REFERENCES departments (department_id),
  ADD CONSTRAINT fk2_emp FOREIGN KEY (manager_id) REFERENCES employees (employee_id);

ALTER TABLE user_credentials
  ADD CONSTRAINT fk1_u FOREIGN KEY (employee_id) REFERENCES employees (employee_id);





COMMIT;




