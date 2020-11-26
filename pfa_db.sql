
DROP DATABASE IF EXISTS pfa_db;

CREATE DATABASE pfa_db;
USE pfa_db;

CREATE TABLE assignments (
  employee_id INT(11) NOT NULL,
  project_id INT(11) NOT NULL,
  commit_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  commit_emp_desc VARCHAR(255) DEFAULT NULL,
  commit_mgr_desc VARCHAR(255) DEFAULT NULL
);

CREATE TABLE departments (
  department_id INT(11) NOT NULL,
  department_name VARCHAR(255) DEFAULT NULL,
  location_id INT(11) DEFAULT NULL
);

INSERT INTO departments (department_id, department_name, location_id) VALUES
(4, 'DWH', 1),
(5, 'Digital', 1),
(6, 'Billing', 1);

CREATE TABLE employees (
  employee_id INT(11) NOT NULL,
  first_name VARCHAR(255) DEFAULT NULL,
  last_name VARCHAR(255) DEFAULT NULL,
  email VARCHAR(255) DEFAULT NULL,
  phone VARCHAR(50) DEFAULT NULL,
  hiredate DATE DEFAULT NULL,
  job VARCHAR(255) DEFAULT NULL,
  salary decimal(7,2) DEFAULT NULL,
  manager_id INT(11) DEFAULT NULL,
  department_id INT(11) DEFAULT NULL
);

INSERT INTO employees (employee_id, first_name, last_name, email, phone, hiredate, job, salary, manager_id, department_id) VALUES
(1, 'Selim', 'Horri', 'selim.horri@ooredoo.tn', '22125144', '2019-04-15', 'Billing', '5000.00', 4, 6),
(2, 'Badr', 'Idoudi', 'badr.idoudi@ooredo.tn', '22125195', '2019-04-15', 'Digital', '5000.00', 9, 5),
(3, 'Imen', 'Touk', 'imen.touk@ooredoo.tn', '22124788', '2019-04-15', 'Data Warehouse', '5000.00', 5, 4),
(4, 'Soumaya', 'Hajjem', 'soumaya.hajjem@ooredoo.tn', '22124823', NULL, 'Chef service Billing', '6000.00', NULL, 6),
(5, 'Nour', 'Larguech', 'nour.larguech@ooredoo.tn', NULL, NULL, 'Chef service Data Warehouse', '6000.00', NULL, 4),
(6, 'Khdija', 'Ben Ghachame', 'khdija.benghachame@ooredoo.tn', NULL, '2559-01-01', 'Billing', '5000.50', 4, 6),
(7, 'Maryem', 'Tlemseni', 'maryem.tlemseni@ooredoo.tn', '2212', NULL, 'Billing', '5000.00', 4, 6),
(8, 'Malek', 'Aissa', 'malek.aissa@ooredoo.tn', '2212', '2020-09-01', 'Billing', '5000.00', 4, 6),
(9, 'John', 'Doe', 'john.doe@ooredoo.tn', '2212', NULL, 'Chef service digital', '6000.00', NULL, 5);

CREATE TABLE locations (
  location_id INT(11) NOT NULL,
  adr VARCHAR(255) DEFAULT NULL,
  postal_code VARCHAR(255) DEFAULT NULL,
  city VARCHAR(255) DEFAULT NULL
);

INSERT INTO locations (location_id, adr, postal_code, city) VALUES
(1, 'RUE DE LA BOURSE', '2016', 'LAC2'),
(2, 'RUE DE BLA BLA', '2016', 'CHARGUIA');

CREATE TABLE projects (
  project_id INT(11) NOT NULL,
  title VARCHAR(255) DEFAULT NULL,
  start_date DATE DEFAULT NULL,
  end_date DATE DEFAULT NULL,
  status VARCHAR(255) DEFAULT NULL
);

INSERT INTO projects (project_id, title, start_date, end_date, status) VALUES
(1, 'TRANSBSCS', '2020-09-28', '2020-11-04', 'COMPLETED'),
(2, 'SYNCH_BSCS_IMX', '2020-11-26', NULL, 'IN_PROGRESS'),
(3, 'TASYI9A LILVIRANDA', '2020-11-26', '2020-11-26', 'COMPLETED'),
(4, 'MACHYA_RANDONNEE', NULL, NULL, 'NOT_STARTED'),
(5, 'TATIB LEFTOUR', '2020-11-08', '2020-11-14', 'IN_PROGRESS');

CREATE TABLE user_credentials (
  user_id INT(11) NOT NULL,
  username VARCHAR(255) DEFAULT NULL,
  password VARCHAR(255) DEFAULT NULL,
  enabled tinyINT(1) DEFAULT 1,
  role VARCHAR(255) DEFAULT NULL,
  employee_id INT(11) DEFAULT NULL
);

INSERT INTO user_credentials (user_id, username, password, enabled, role, employee_id) VALUES
(1, 'imentouk', '$2a$04$itGCczcleGS8jlTCSCBkH.BgXBXWVPm5vV/JOe4PNh9IcReXtrp.W', 1, 'ROLE_EMP', 3),
(2, 'badridoudi', '$2a$04$8WmxdwyZbTrYitZ4fbrYoOKE7ZkU1R//DMKA.Uyq1qpNkHhL1z3cG', 1, 'ROLE_EMP', 2),
(3, 'selimhorri', '$2a$04$n7VuAe284sF7fKzHuIrjPemfly5HZrBKqAsAENKw9qI17U2n9ryxy', 1, 'ROLE_EMP', 1),
(4, 'admin', '$2a$04$7LWGXhf.7BtZVeycAZHCQOuqdVvyQuP3u6KVnpW6ovZWzAgcNsTzK', 1, 'ROLE_ADMIN', NULL),
(5, 'soumayahajjem', '$2a$04$i0f5KDnYzT3ePEzNqTQIPew1VUqrMOuWVkiNxSPmAoHZUVMGY3Nea', 1, 'ROLE_MGR', 4),
(6, 'nourlarguech', '$2a$04$yKXSqlRcZBi160H00awwzOnGZzLRfou8shQNiQapy0J3Ze9tCKEfe', 1, 'ROLE_MGR', 5),
(7, 'johndoe', '$2a$04$SgQRzuXukck2vcM1dadai.9ZP3/1ENwROD5Uij0Fe6xMBuQPqV2D2', 1, 'ROLE_MGR', 9);





ALTER TABLE assignments
  ADD PRIMARY KEY (employee_id,project_id,commit_date),
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
  MODIFY department_id INT(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE employees
  MODIFY employee_id INT(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE locations
  MODIFY location_id INT(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE projects
  MODIFY project_id INT(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE user_credentials
  MODIFY user_id INT(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;





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




