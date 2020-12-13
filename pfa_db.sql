
DROP DATABASE IF EXISTS pfa_db;


SELECT '===========================>> PFA_DEV_DB <<===========================' AS DESC_SCRIPT
FROM dual;


DROP DATABASE IF EXISTS pfa_dev_db;

CREATE DATABASE pfa_dev_db;
USE pfa_dev_db;



CREATE TABLE assignments (
  employee_id INT(11) NOT NULL,
  project_id INT(11) NOT NULL,
  commit_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  commit_emp_desc VARCHAR(255) DEFAULT NULL,
  commit_mgr_desc VARCHAR(255) DEFAULT NULL
);



INSERT INTO assignments (employee_id, project_id, commit_date, commit_emp_desc, commit_mgr_desc) VALUES
(1, 1, '2020-11-26 12:50:09', NULL, 'init'),
(1, 1, '2020-11-26 15:14:22', 'set up some configs', 'you need to implement sec solution'),
(1, 1, '2020-12-12 18:49:42', 'implement customer by invoice', NULL),
(1, 1, '2020-12-12 19:04:14', 'suspend customers...', NULL),
(1, 1, '2020-12-12 19:04:30', 'suspe', NULL),
(1, 1, '2020-12-12 19:25:48', 'created new customer suspension', NULL),
(1, 2, '2020-11-26 12:51:59', NULL, 'init'),
(1, 2, '2020-11-26 15:14:22', 'generate xml file', 'check out marshaling correctness'),
(1, 2, '2020-12-12 13:57:18', 'files on CRMIMX', NULL),
(1, 2, '2020-12-12 14:13:51', '00000', NULL),
(1, 2, '2020-12-12 14:23:39', 'Set up xml for CRMIMX1', NULL),
(1, 2, '2020-12-12 14:30:14', 'implement BSCSIMX2 business layer', NULL),
(1, 2, '2020-12-12 14:37:53', 'synchronize BSCSIMX2', NULL),
(1, 2, '2020-12-12 18:40:17', 'create a simple xml file for IMX CX', NULL),
(1, 2, '2020-12-12 18:43:48', 'synchronize xml and Java file', NULL),
(1, 4, '2020-12-13 21:55:14', NULL, 'init'),
(2, 1, '2020-11-26 12:51:44', NULL, 'init'),
(2, 1, '2020-12-12 17:14:05', 'implement invoice menu logic for mass category', NULL),
(2, 1, '2020-12-12 17:14:21', 'have new interface ', NULL),
(2, 1, '2020-12-12 17:26:03', 'design border menu', NULL),
(2, 4, '2020-12-13 21:55:14', NULL, 'init'),
(2, 5, '2020-11-26 12:52:32', NULL, 'init'),
(2, 5, '2020-12-12 17:10:28', 'samtan l ma9rouna', NULL),
(2, 5, '2020-12-12 17:10:57', 'sa9i l ma9rouna fel keskess', NULL),
(2, 5, '2020-12-12 17:12:10', '7ot salsa 3al ma9rouna', NULL),
(3, 1, '2020-11-26 12:51:25', NULL, 'init'),
(3, 1, '2020-12-12 17:07:23', 'implement invoice menu', NULL),
(3, 1, '2020-12-12 17:09:02', 'design invoice menu', NULL),
(3, 4, '2020-12-13 21:55:14', NULL, 'init'),
(3, 5, '2020-11-26 12:52:19', NULL, 'init'),
(3, 5, '2020-12-12 17:01:49', '9asan l sfénéria', NULL),
(3, 5, '2020-12-12 17:04:37', '9asan l batata', NULL),
(3, 5, '2020-12-12 17:06:39', 'tajmirrrrr', NULL),
(6, 1, '2020-11-26 12:49:41', NULL, 'init'),
(6, 1, '2020-11-26 12:50:53', 'SET UP DIFFERENT LAYERS', NULL),
(6, 1, '2020-12-12 17:16:55', 'import new libs', NULL),
(6, 1, '2020-12-12 17:17:31', 'set exception payload', NULL);



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
  email VARCHAR(255) DEFAULT 'springabcxyzboot@gmail.com',
  phone VARCHAR(50) DEFAULT '22125144',
  hiredate DATE DEFAULT NULL,
  job VARCHAR(255) DEFAULT NULL,
  salary DECIMAL(7,2) DEFAULT NULL,
  manager_id INT(11) DEFAULT NULL,
  department_id INT(11) DEFAULT NULL
);



INSERT INTO employees (employee_id, first_name, last_name, phone, hiredate, job, salary, manager_id, department_id) VALUES
(1, 'Selim', 'Horri', '22125144', '2019-04-15', 'Billing', '5000.00', 4, 6),
(2, 'Badr', 'Idoudi', '22125144', '2019-04-15', 'Digital', '5000.00', 9, 5),
(3, 'Imen', 'Touk', '22125144', '2019-04-15', 'Data Warehouse', '5000.00', 5, 4),
(4, 'Soumaya', 'Hajjem', '22125144', NULL, 'Chef service Billing', '6000.00', NULL, 6),
(5, 'Nour', 'Larguech', '22125144', NULL, 'Chef service Data Warehouse', '6000.00', NULL, 4),
(6, 'Khdija', 'Ben Ghachame', '22125144', '2559-01-01', 'Billing', '5000.50', 4, 6),
(7, 'Maryem', 'Tlemseni', '22125144', NULL, 'Billing', '5000.00', 4, 6),
(8, 'Malek', 'Aissa', '22125144', '2020-09-01', 'Billing', '5000.00', 4, 6),
(9, 'John', 'Doe', '22125144', NULL, 'Chef service digital', '6000.00', NULL, 5);



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
  enabled BOOLEAN DEFAULT true,
  role VARCHAR(255) DEFAULT NULL,
  employee_id INT(11) DEFAULT NULL
);



INSERT INTO user_credentials (user_id, username, password, enabled, role, employee_id) VALUES
(1, 'imentouk', '$2y$04$8jC1Xb/fKB3EQIHy0XoFUunQNhjiVpvuMZys6iCOkphCAsyBkmCTC', 1, 'ROLE_EMP', 3),
(2, 'badridoudi', '$2y$04$c09yvJ4rcadTRGaoVQRRZugld/9z377uaIHwRCWxexBADCVT.jC4S', 1, 'ROLE_EMP', 2),
(3, 'selimhorri', '$2y$04$WmddgY6/UU/vOqsh.6CIe.80/DiPJcvtEopEDk/6EkyOP5APcYWsy', 1, 'ROLE_EMP', 1),
(4, 'admin', '$2y$04$HLi44N6cb6xmLYHdABF/euCgpk0LofYk4VdIeO1DAn.Ol1Bnaj3vW', 1, 'ROLE_ADMIN', NULL),
(5, 'soumayahajjem', '$2y$04$ljw6KJaAkzMzJZOf8eU6qOoq7jV2SXRqeg7uHS7tQb6x86SBS/oEW', 1, 'ROLE_MGR', 4),
(6, 'nourlarguech', '$2y$04$ngbUBXKPaTRFAUFEifgPpuqmBTf4VjUJL.eGpeEIGwI/iiE18ZSny', 1, 'ROLE_MGR', 5),
(7, 'johndoe', '$2y$04$CT3Jad4jrOq1zGt0Q4maEeTV57rdLtYNVnBM96vyVaGbaE4YgwfvO', 1, 'ROLE_MGR', 9),
(8, 'kbenghachame', '$2y$04$SE6NDj5qAIbCehmTsvU0jeocRrdZTDxDMQ9GapIhD9bnBgtQX.HA.', '1', 'ROLE_EMP', '6'), 
(9, 'malekaissa', '$2y$04$tajXWCrvBC7ow/rqfmz1i.Z4IPcZdoBa0GMltMFkkzPIiTGguHIgi', '1', 'ROLE_EMP', '8'), 
(10, 'maryemtlemseni', '$2y$04$PYOfQrM6MgHVY6myHfczsOlNVGXxllW0VD0/LYavV218kXluGm6km', '1', 'ROLE_EMP', '7');











SELECT '===========================>> Setting PRIMARY KEYs && UNIQUE CONSTRAINTs <<===========================' AS DESC_SCRIPT
FROM DUAL;





ALTER TABLE assignments
  ADD PRIMARY KEY (employee_id, project_id, commit_date),
  ADD KEY fk1_assign (project_id);

ALTER TABLE departments
  ADD PRIMARY KEY (department_id),
  ADD KEY fk1_dept (location_id);

ALTER TABLE employees
  ADD PRIMARY KEY (employee_id),
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





SELECT '===========================>> Setting AUTO_INCREMENTs <<===========================' AS DESC_SCRIPT
FROM DUAL;





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





SELECT '===========================>> Setting FOREIGN KEY CONSTRAINTs <<===========================' AS DESC_SCRIPT
FROM DUAL;





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





SELECT '===========================>> COMMIT <<===========================' AS DESC_SCRIPT
FROM DUAL;





COMMIT;




-- ***************************************************************************************************************************************

SELECT '===========================>> PFA_TEST_DB <<===========================' AS DESC_SCRIPT
FROM dual;


DROP DATABASE IF EXISTS pfa_test_db;

CREATE DATABASE pfa_test_db;
USE pfa_test_db;



CREATE TABLE assignments (
  employee_id INT(11) NOT NULL,
  project_id INT(11) NOT NULL,
  commit_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  commit_emp_desc VARCHAR(255) DEFAULT NULL,
  commit_mgr_desc VARCHAR(255) DEFAULT NULL
);



INSERT INTO assignments (employee_id, project_id, commit_date, commit_emp_desc, commit_mgr_desc) VALUES
(1, 1, '2020-11-26 12:50:09', NULL, 'init'),
(1, 1, '2020-11-26 15:14:22', 'set up some configs', 'you need to implement sec solution'),
(1, 1, '2020-12-12 18:49:42', 'implement customer by invoice', NULL),
(1, 1, '2020-12-12 19:04:14', 'suspend customers...', NULL),
(1, 1, '2020-12-12 19:04:30', 'suspe', NULL),
(1, 1, '2020-12-12 19:25:48', 'created new customer suspension', NULL),
(1, 2, '2020-11-26 12:51:59', NULL, 'init'),
(1, 2, '2020-11-26 15:14:22', 'generate xml file', 'check out marshaling correctness'),
(1, 2, '2020-12-12 13:57:18', 'files on CRMIMX', NULL),
(1, 2, '2020-12-12 14:13:51', '00000', NULL),
(1, 2, '2020-12-12 14:23:39', 'Set up xml for CRMIMX1', NULL),
(1, 2, '2020-12-12 14:30:14', 'implement BSCSIMX2 business layer', NULL),
(1, 2, '2020-12-12 14:37:53', 'synchronize BSCSIMX2', NULL),
(1, 2, '2020-12-12 18:40:17', 'create a simple xml file for IMX CX', NULL),
(1, 2, '2020-12-12 18:43:48', 'synchronize xml and Java file', NULL),
(1, 4, '2020-12-13 21:55:14', NULL, 'init'),
(2, 1, '2020-11-26 12:51:44', NULL, 'init'),
(2, 1, '2020-12-12 17:14:05', 'implement invoice menu logic for mass category', NULL),
(2, 1, '2020-12-12 17:14:21', 'have new interface ', NULL),
(2, 1, '2020-12-12 17:26:03', 'design border menu', NULL),
(2, 4, '2020-12-13 21:55:14', NULL, 'init'),
(2, 5, '2020-11-26 12:52:32', NULL, 'init'),
(2, 5, '2020-12-12 17:10:28', 'samtan l ma9rouna', NULL),
(2, 5, '2020-12-12 17:10:57', 'sa9i l ma9rouna fel keskess', NULL),
(2, 5, '2020-12-12 17:12:10', '7ot salsa 3al ma9rouna', NULL),
(3, 1, '2020-11-26 12:51:25', NULL, 'init'),
(3, 1, '2020-12-12 17:07:23', 'implement invoice menu', NULL),
(3, 1, '2020-12-12 17:09:02', 'design invoice menu', NULL),
(3, 4, '2020-12-13 21:55:14', NULL, 'init'),
(3, 5, '2020-11-26 12:52:19', NULL, 'init'),
(3, 5, '2020-12-12 17:01:49', '9asan l sfénéria', NULL),
(3, 5, '2020-12-12 17:04:37', '9asan l batata', NULL),
(3, 5, '2020-12-12 17:06:39', 'tajmirrrrr', NULL),
(6, 1, '2020-11-26 12:49:41', NULL, 'init'),
(6, 1, '2020-11-26 12:50:53', 'SET UP DIFFERENT LAYERS', NULL),
(6, 1, '2020-12-12 17:16:55', 'import new libs', NULL),
(6, 1, '2020-12-12 17:17:31', 'set exception payload', NULL);



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
  email VARCHAR(255) DEFAULT 'springabcxyzboot@gmail.com',
  phone VARCHAR(50) DEFAULT '22125144',
  hiredate DATE DEFAULT NULL,
  job VARCHAR(255) DEFAULT NULL,
  salary DECIMAL(7,2) DEFAULT NULL,
  manager_id INT(11) DEFAULT NULL,
  department_id INT(11) DEFAULT NULL
);



INSERT INTO employees (employee_id, first_name, last_name, phone, hiredate, job, salary, manager_id, department_id) VALUES
(1, 'Selim', 'Horri', '22125144', '2019-04-15', 'Billing', '5000.00', 4, 6),
(2, 'Badr', 'Idoudi', '22125144', '2019-04-15', 'Digital', '5000.00', 9, 5),
(3, 'Imen', 'Touk', '22125144', '2019-04-15', 'Data Warehouse', '5000.00', 5, 4),
(4, 'Soumaya', 'Hajjem', '22125144', NULL, 'Chef service Billing', '6000.00', NULL, 6),
(5, 'Nour', 'Larguech', '22125144', NULL, 'Chef service Data Warehouse', '6000.00', NULL, 4),
(6, 'Khdija', 'Ben Ghachame', '22125144', '2559-01-01', 'Billing', '5000.50', 4, 6),
(7, 'Maryem', 'Tlemseni', '22125144', NULL, 'Billing', '5000.00', 4, 6),
(8, 'Malek', 'Aissa', '22125144', '2020-09-01', 'Billing', '5000.00', 4, 6),
(9, 'John', 'Doe', '22125144', NULL, 'Chef service digital', '6000.00', NULL, 5);



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
  enabled BOOLEAN DEFAULT true,
  role VARCHAR(255) DEFAULT NULL,
  employee_id INT(11) DEFAULT NULL
);



INSERT INTO user_credentials (user_id, username, password, enabled, role, employee_id) VALUES
(1, 'imentouk', '$2y$04$8jC1Xb/fKB3EQIHy0XoFUunQNhjiVpvuMZys6iCOkphCAsyBkmCTC', 1, 'ROLE_EMP', 3),
(2, 'badridoudi', '$2y$04$c09yvJ4rcadTRGaoVQRRZugld/9z377uaIHwRCWxexBADCVT.jC4S', 1, 'ROLE_EMP', 2),
(3, 'selimhorri', '$2y$04$WmddgY6/UU/vOqsh.6CIe.80/DiPJcvtEopEDk/6EkyOP5APcYWsy', 1, 'ROLE_EMP', 1),
(4, 'admin', '$2y$04$HLi44N6cb6xmLYHdABF/euCgpk0LofYk4VdIeO1DAn.Ol1Bnaj3vW', 1, 'ROLE_ADMIN', NULL),
(5, 'soumayahajjem', '$2y$04$ljw6KJaAkzMzJZOf8eU6qOoq7jV2SXRqeg7uHS7tQb6x86SBS/oEW', 1, 'ROLE_MGR', 4),
(6, 'nourlarguech', '$2y$04$ngbUBXKPaTRFAUFEifgPpuqmBTf4VjUJL.eGpeEIGwI/iiE18ZSny', 1, 'ROLE_MGR', 5),
(7, 'johndoe', '$2y$04$CT3Jad4jrOq1zGt0Q4maEeTV57rdLtYNVnBM96vyVaGbaE4YgwfvO', 1, 'ROLE_MGR', 9),
(8, 'kbenghachame', '$2y$04$SE6NDj5qAIbCehmTsvU0jeocRrdZTDxDMQ9GapIhD9bnBgtQX.HA.', '1', 'ROLE_EMP', '6'), 
(9, 'malekaissa', '$2y$04$tajXWCrvBC7ow/rqfmz1i.Z4IPcZdoBa0GMltMFkkzPIiTGguHIgi', '1', 'ROLE_EMP', '8'), 
(10, 'maryemtlemseni', '$2y$04$PYOfQrM6MgHVY6myHfczsOlNVGXxllW0VD0/LYavV218kXluGm6km', '1', 'ROLE_EMP', '7');











SELECT '===========================>> Setting PRIMARY KEYs && UNIQUE CONSTRAINTs <<===========================' AS DESC_SCRIPT
FROM DUAL;





ALTER TABLE assignments
  ADD PRIMARY KEY (employee_id, project_id, commit_date),
  ADD KEY fk1_assign (project_id);

ALTER TABLE departments
  ADD PRIMARY KEY (department_id),
  ADD KEY fk1_dept (location_id);

ALTER TABLE employees
  ADD PRIMARY KEY (employee_id),
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





SELECT '===========================>> Setting AUTO_INCREMENTs <<===========================' AS DESC_SCRIPT
FROM DUAL;





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





SELECT '===========================>> Setting FOREIGN KEY CONSTRAINTs <<===========================' AS DESC_SCRIPT
FROM DUAL;





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





SELECT '===========================>> COMMIT <<===========================' AS DESC_SCRIPT
FROM DUAL;





COMMIT;




-- ***************************************************************************************************************************************

SELECT '===========================>> PFA_PROD_DB <<===========================' AS DESC_SCRIPT
FROM dual;


DROP DATABASE IF EXISTS pfa_prod_db;

CREATE DATABASE pfa_prod_db;
USE pfa_prod_db;



CREATE TABLE assignments (
  employee_id INT(11) NOT NULL,
  project_id INT(11) NOT NULL,
  commit_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  commit_emp_desc VARCHAR(255) DEFAULT NULL,
  commit_mgr_desc VARCHAR(255) DEFAULT NULL
);



INSERT INTO assignments (employee_id, project_id, commit_date, commit_emp_desc, commit_mgr_desc) VALUES
(1, 1, '2020-11-26 12:50:09', NULL, 'init'),
(1, 1, '2020-11-26 15:14:22', 'set up some configs', 'you need to implement sec solution'),
(1, 1, '2020-12-12 18:49:42', 'implement customer by invoice', NULL),
(1, 1, '2020-12-12 19:04:14', 'suspend customers...', NULL),
(1, 1, '2020-12-12 19:04:30', 'suspe', NULL),
(1, 1, '2020-12-12 19:25:48', 'created new customer suspension', NULL),
(1, 2, '2020-11-26 12:51:59', NULL, 'init'),
(1, 2, '2020-11-26 15:14:22', 'generate xml file', 'check out marshaling correctness'),
(1, 2, '2020-12-12 13:57:18', 'files on CRMIMX', NULL),
(1, 2, '2020-12-12 14:13:51', '00000', NULL),
(1, 2, '2020-12-12 14:23:39', 'Set up xml for CRMIMX1', NULL),
(1, 2, '2020-12-12 14:30:14', 'implement BSCSIMX2 business layer', NULL),
(1, 2, '2020-12-12 14:37:53', 'synchronize BSCSIMX2', NULL),
(1, 2, '2020-12-12 18:40:17', 'create a simple xml file for IMX CX', NULL),
(1, 2, '2020-12-12 18:43:48', 'synchronize xml and Java file', NULL),
(1, 4, '2020-12-13 21:55:14', NULL, 'init'),
(2, 1, '2020-11-26 12:51:44', NULL, 'init'),
(2, 1, '2020-12-12 17:14:05', 'implement invoice menu logic for mass category', NULL),
(2, 1, '2020-12-12 17:14:21', 'have new interface ', NULL),
(2, 1, '2020-12-12 17:26:03', 'design border menu', NULL),
(2, 4, '2020-12-13 21:55:14', NULL, 'init'),
(2, 5, '2020-11-26 12:52:32', NULL, 'init'),
(2, 5, '2020-12-12 17:10:28', 'samtan l ma9rouna', NULL),
(2, 5, '2020-12-12 17:10:57', 'sa9i l ma9rouna fel keskess', NULL),
(2, 5, '2020-12-12 17:12:10', '7ot salsa 3al ma9rouna', NULL),
(3, 1, '2020-11-26 12:51:25', NULL, 'init'),
(3, 1, '2020-12-12 17:07:23', 'implement invoice menu', NULL),
(3, 1, '2020-12-12 17:09:02', 'design invoice menu', NULL),
(3, 4, '2020-12-13 21:55:14', NULL, 'init'),
(3, 5, '2020-11-26 12:52:19', NULL, 'init'),
(3, 5, '2020-12-12 17:01:49', '9asan l sfénéria', NULL),
(3, 5, '2020-12-12 17:04:37', '9asan l batata', NULL),
(3, 5, '2020-12-12 17:06:39', 'tajmirrrrr', NULL),
(6, 1, '2020-11-26 12:49:41', NULL, 'init'),
(6, 1, '2020-11-26 12:50:53', 'SET UP DIFFERENT LAYERS', NULL),
(6, 1, '2020-12-12 17:16:55', 'import new libs', NULL),
(6, 1, '2020-12-12 17:17:31', 'set exception payload', NULL);



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
  email VARCHAR(255) DEFAULT 'springabcxyzboot@gmail.com',
  phone VARCHAR(50) DEFAULT '22125144',
  hiredate DATE DEFAULT NULL,
  job VARCHAR(255) DEFAULT NULL,
  salary DECIMAL(7,2) DEFAULT NULL,
  manager_id INT(11) DEFAULT NULL,
  department_id INT(11) DEFAULT NULL
);



INSERT INTO employees (employee_id, first_name, last_name, phone, hiredate, job, salary, manager_id, department_id) VALUES
(1, 'Selim', 'Horri', '22125144', '2019-04-15', 'Billing', '5000.00', 4, 6),
(2, 'Badr', 'Idoudi', '22125144', '2019-04-15', 'Digital', '5000.00', 9, 5),
(3, 'Imen', 'Touk', '22125144', '2019-04-15', 'Data Warehouse', '5000.00', 5, 4),
(4, 'Soumaya', 'Hajjem', '22125144', NULL, 'Chef service Billing', '6000.00', NULL, 6),
(5, 'Nour', 'Larguech', '22125144', NULL, 'Chef service Data Warehouse', '6000.00', NULL, 4),
(6, 'Khdija', 'Ben Ghachame', '22125144', '2559-01-01', 'Billing', '5000.50', 4, 6),
(7, 'Maryem', 'Tlemseni', '22125144', NULL, 'Billing', '5000.00', 4, 6),
(8, 'Malek', 'Aissa', '22125144', '2020-09-01', 'Billing', '5000.00', 4, 6),
(9, 'John', 'Doe', '22125144', NULL, 'Chef service digital', '6000.00', NULL, 5);



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
  enabled BOOLEAN DEFAULT true,
  role VARCHAR(255) DEFAULT NULL,
  employee_id INT(11) DEFAULT NULL
);



INSERT INTO user_credentials (user_id, username, password, enabled, role, employee_id) VALUES
(1, 'imentouk', '$2y$04$8jC1Xb/fKB3EQIHy0XoFUunQNhjiVpvuMZys6iCOkphCAsyBkmCTC', 1, 'ROLE_EMP', 3),
(2, 'badridoudi', '$2y$04$c09yvJ4rcadTRGaoVQRRZugld/9z377uaIHwRCWxexBADCVT.jC4S', 1, 'ROLE_EMP', 2),
(3, 'selimhorri', '$2y$04$WmddgY6/UU/vOqsh.6CIe.80/DiPJcvtEopEDk/6EkyOP5APcYWsy', 1, 'ROLE_EMP', 1),
(4, 'admin', '$2y$04$HLi44N6cb6xmLYHdABF/euCgpk0LofYk4VdIeO1DAn.Ol1Bnaj3vW', 1, 'ROLE_ADMIN', NULL),
(5, 'soumayahajjem', '$2y$04$ljw6KJaAkzMzJZOf8eU6qOoq7jV2SXRqeg7uHS7tQb6x86SBS/oEW', 1, 'ROLE_MGR', 4),
(6, 'nourlarguech', '$2y$04$ngbUBXKPaTRFAUFEifgPpuqmBTf4VjUJL.eGpeEIGwI/iiE18ZSny', 1, 'ROLE_MGR', 5),
(7, 'johndoe', '$2y$04$CT3Jad4jrOq1zGt0Q4maEeTV57rdLtYNVnBM96vyVaGbaE4YgwfvO', 1, 'ROLE_MGR', 9),
(8, 'kbenghachame', '$2y$04$SE6NDj5qAIbCehmTsvU0jeocRrdZTDxDMQ9GapIhD9bnBgtQX.HA.', '1', 'ROLE_EMP', '6'), 
(9, 'malekaissa', '$2y$04$tajXWCrvBC7ow/rqfmz1i.Z4IPcZdoBa0GMltMFkkzPIiTGguHIgi', '1', 'ROLE_EMP', '8'), 
(10, 'maryemtlemseni', '$2y$04$PYOfQrM6MgHVY6myHfczsOlNVGXxllW0VD0/LYavV218kXluGm6km', '1', 'ROLE_EMP', '7');











SELECT '===========================>> Setting PRIMARY KEYs && UNIQUE CONSTRAINTs <<===========================' AS DESC_SCRIPT
FROM DUAL;





ALTER TABLE assignments
  ADD PRIMARY KEY (employee_id, project_id, commit_date),
  ADD KEY fk1_assign (project_id);

ALTER TABLE departments
  ADD PRIMARY KEY (department_id),
  ADD KEY fk1_dept (location_id);

ALTER TABLE employees
  ADD PRIMARY KEY (employee_id),
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





SELECT '===========================>> Setting AUTO_INCREMENTs <<===========================' AS DESC_SCRIPT
FROM DUAL;





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





SELECT '===========================>> Setting FOREIGN KEY CONSTRAINTs <<===========================' AS DESC_SCRIPT
FROM DUAL;





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





SELECT '===========================>> COMMIT <<===========================' AS DESC_SCRIPT
FROM DUAL;





COMMIT;




