
SELECT '===========================>> PFA_TEST_DB <<===========================' AS DESC_SCRIPT
FROM dual;


DROP DATABASE IF EXISTS pfa_test_db;

CREATE DATABASE pfa_test_db;
USE pfa_test_db;



CREATE TABLE assignments (
  employee_id int(11) NOT NULL,
  project_id int(11) NOT NULL,
  commit_date timestamp NOT NULL DEFAULT current_timestamp(),
  commit_emp_desc varchar(255) DEFAULT NULL,
  commit_mgr_desc varchar(255) DEFAULT NULL
);



INSERT INTO assignments (employee_id, project_id, commit_date, commit_emp_desc, commit_mgr_desc) VALUES
(1, 1, '2020-11-26 10:50:09', NULL, 'init'),
(1, 1, '2020-11-26 13:14:22', 'set up some configs', 'you need to implement sec solution'),
(1, 1, '2020-12-12 16:49:42', 'implement customer by invoice', NULL),
(1, 1, '2020-12-12 17:04:14', 'suspend customers...', NULL),
(1, 1, '2020-12-12 17:04:30', 'suspe', NULL),
(1, 1, '2020-12-12 17:25:48', 'created new customer suspension', NULL),
(1, 2, '2020-11-26 10:51:59', NULL, 'init'),
(1, 2, '2020-11-26 13:14:22', 'generate xml file', 'check out marshaling correctness'),
(1, 2, '2020-12-12 11:57:18', 'files on CRMIMX', NULL),
(1, 2, '2020-12-12 12:13:51', '00000', NULL),
(1, 2, '2020-12-12 12:23:39', 'Set up xml for CRMIMX1', NULL),
(1, 2, '2020-12-12 12:30:14', 'implement BSCSIMX2 business layer', NULL),
(1, 2, '2020-12-12 12:37:53', 'synchronize BSCSIMX2', NULL),
(1, 2, '2020-12-12 16:40:17', 'create a simple xml file for IMX CX', NULL),
(1, 2, '2020-12-12 16:43:48', 'synchronize xml and Java file', NULL),
(1, 2, '2020-12-17 19:29:17', 'take it easy with Spring Boot***********', NULL),
(1, 2, '2020-12-19 12:05:23', 'Generate new XML file for CRMIMX2', NULL),
(2, 5, '2020-11-26 10:52:32', NULL, 'init'),
(2, 5, '2020-12-12 15:10:28', 'samtan l ma9rouna', NULL),
(2, 5, '2020-12-12 15:10:57', 'sa9i l ma9rouna fel keskess', NULL),
(2, 5, '2020-12-12 15:12:10', '7ot salsa 3al ma9rouna', NULL),
(2, 6, '2020-12-19 11:04:29', NULL, 'init'),
(2, 6, '2020-12-19 11:16:53', 'set info', NULL),
(2, 6, '2020-12-19 11:17:12', 'set layers', NULL),
(2, 6, '2020-12-19 11:17:29', 'some front', NULL),
(2, 7, '2020-12-19 11:04:29', NULL, 'init'),
(2, 7, '2020-12-19 11:17:44', 'setup some classes', NULL),
(2, 7, '2020-12-19 11:17:58', 'implement some solutions', NULL),
(3, 4, '2020-12-13 19:55:14', NULL, 'init'),
(3, 4, '2020-12-17 11:20:47', 'ta7dhirat..........', NULL),
(3, 4, '2020-12-17 11:30:09', 'ta7dhirat ........$$**', NULL),
(3, 9, '2020-12-19 16:06:20', NULL, 'init'),
(6, 1, '2020-11-26 10:49:41', NULL, 'init'),
(6, 1, '2020-11-26 10:50:53', 'SET UP DIFFERENT LAYERS', NULL),
(6, 1, '2020-12-12 15:16:55', 'import new libs', NULL),
(6, 1, '2020-12-12 15:17:31', 'set exception payload', NULL),
(10, 6, '2020-12-19 11:34:11', NULL, 'init'),
(10, 6, '2020-12-19 11:36:34', 'set some configs', NULL),
(10, 6, '2020-12-19 11:37:11', 'configure some properties', NULL),
(10, 7, '2020-12-19 11:38:00', 'configure some properties', NULL),
(10, 7, '2020-12-19 11:38:22', 'set configs', NULL),
(11, 6, '2020-12-19 11:34:29', NULL, 'init'),
(11, 6, '2020-12-19 11:40:50', 'set up a new container for deployment', NULL),
(11, 6, '2020-12-19 11:41:17', 'configure my new container', NULL),
(11, 7, '2020-12-19 11:41:57', NULL, 'init'),
(11, 7, '2020-12-19 11:42:33', 'containerize a service', NULL),
(11, 7, '2020-12-19 15:48:03', 'create a new container', NULL),
(12, 8, '2020-12-19 16:05:28', NULL, 'init'),
(12, 8, '2020-12-19 16:08:52', 'setting greenplume env locally', NULL),
(12, 8, '2020-12-19 16:09:52', 'open workspace', NULL),
(12, 9, '2020-12-19 16:05:41', NULL, 'init'),
(12, 9, '2020-12-19 16:11:00', 'design first functionality', NULL),
(12, 9, '2020-12-19 16:11:20', 'design second functionality', NULL),
(13, 8, '2020-12-19 16:05:55', NULL, 'init'),
(13, 8, '2020-12-19 16:11:59', 'set envirnment', NULL),
(13, 8, '2020-12-19 16:12:13', 'new click', NULL),
(13, 9, '2020-12-19 16:06:09', NULL, 'init'),
(13, 9, '2020-12-19 16:13:01', 'get first ids', NULL),
(13, 9, '2020-12-19 16:13:17', 'create new workspace', NULL);



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
  employee_id int(11) NOT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT 'springabcxyzboot@gmail.com' NOT NULL,
  phone varchar(50) DEFAULT '22125144' NOT NULL,
  hiredate date DEFAULT NULL,
  job varchar(255) DEFAULT NULL,
  salary decimal(7,2) DEFAULT NULL,
  manager_id int(11) DEFAULT NULL,
  department_id int(11) DEFAULT NULL
);



INSERT INTO employees (employee_id, first_name, last_name, email, phone, hiredate, job, salary, manager_id, department_id) VALUES
(1, 'Selim', 'Horri', 'springabcxyzboot@gmail.com', '22125144', '2019-04-15', 'Billing', '5000.00', 4, 6),
(2, 'Badr', 'Idoudi', 'springabcxyzboot@gmail.com', '22125144', '2019-04-15', 'Digital', '5000.00', 9, 5),
(3, 'Imen', 'Touk', 'springabcxyzboot@gmail.com', '22125144', '2019-04-15', 'Data Warehouse', '5000.00', 5, 4),
(4, 'Soumaya', 'Hajjem', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Chef service Billing', '6000.00', NULL, 6),
(5, 'Nour', 'Larguech', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Chef service Data Warehouse', '6000.00', NULL, 4),
(6, 'Khdija', 'Ben Ghachame', 'springabcxyzboot@gmail.com', '22125144', '2559-01-01', 'Billing', '5000.50', 4, 6),
(7, 'Maryem', 'Tlemseni', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Billing', '5000.00', 4, 6),
(8, 'Malek', 'Aissa', 'springabcxyzboot@gmail.com', '22125144', '2020-09-01', 'Billing', '5000.00', 4, 6),
(9, 'John', 'Doe', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Chef service digital', '6000.00', NULL, 5),
(10, 'Sana', 'Saanouni', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Digital', '5000.00', 9, 5),
(11, 'Marwen', 'Mejri', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Digital', '5000.60', 9, 5),
(12, 'Mayssa', 'Hassine', 'springabcxyzboot@gmail.com', '22125144', '2019-04-30', 'Data Warehouse', '5000.00', 5, 4),
(13, 'Mouna', 'Chaouachi', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Data Warehouse', '5000.50', 5, 4),
(14, 'admin', 'admin', 'springabcxyzboot@gmail.com', '22125144', NULL, 'RH', '5000.00', NULL, NULL);



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
  project_id int(11) NOT NULL,
  title varchar(255) DEFAULT NULL,
  start_date date DEFAULT NULL,
  end_date date DEFAULT NULL,
  status varchar(255) DEFAULT NULL
);



INSERT INTO projects (project_id, title, start_date, end_date, status) VALUES
(1, 'TRANSBSCS', '2020-09-28', '2020-11-04', 'COMPLETED'),
(2, 'SYNCH_BSCS_IMX', '2020-11-26', '2021-03-25', 'IN_PROGRESS'),
(3, 'TASYI9A LILVIRANDA', '2020-11-26', '2020-11-26', 'COMPLETED'),
(4, 'MACHYA_RANDONNEE', '2021-01-29', '2021-04-30', 'NOT_STARTED'),
(5, 'TATIB LEFTOUR', '2020-11-14', '2020-11-14', 'COMPLETED'),
(6, 'ChatBot', '2020-12-11', '2021-01-30', 'NOT_STARTED'),
(7, 'MyOoredoo', '2018-08-01', '2021-05-14', 'IN_PROGRESS'),
(8, 'GREENPLUME_UPGRADE', '2020-11-02', '2021-05-01', 'IN_PROGRESS'),
(9, 'COMMISION_AUTOMATION', '2020-06-01', '2021-03-02', 'IN_PROGRESS');



CREATE TABLE user_credentials (
  user_id int(11) NOT NULL,
  username varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  enabled tinyint(1) DEFAULT 1 NOT NULL,
  role varchar(255) DEFAULT NULL,
  employee_id int(11) DEFAULT NULL
);



INSERT INTO user_credentials (user_id, username, password, enabled, role, employee_id) VALUES
(1, 'imentouk', '$2y$04$8jC1Xb/fKB3EQIHy0XoFUunQNhjiVpvuMZys6iCOkphCAsyBkmCTC', 1, 'ROLE_EMP', 3),
(2, 'badridoudi', '$2y$04$c09yvJ4rcadTRGaoVQRRZugld/9z377uaIHwRCWxexBADCVT.jC4S', 1, 'ROLE_EMP', 2),
(3, 'selimhorri', '$2a$10$ldBd/ZuGtUgxHNKd.qCGxuPVVM5oZ6kHkKyu5By8NIQxrv4rV9O/C', 1, 'ROLE_EMP', 1),
(4, 'admin', '$2y$04$HLi44N6cb6xmLYHdABF/euCgpk0LofYk4VdIeO1DAn.Ol1Bnaj3vW', 1, 'ROLE_ADMIN', 14),
(5, 'soumayahajjem', '$2y$04$ljw6KJaAkzMzJZOf8eU6qOoq7jV2SXRqeg7uHS7tQb6x86SBS/oEW', 1, 'ROLE_MGR', 4),
(6, 'nourlarguech', '$2y$04$ngbUBXKPaTRFAUFEifgPpuqmBTf4VjUJL.eGpeEIGwI/iiE18ZSny', 1, 'ROLE_MGR', 5),
(7, 'johndoe', '$2y$04$CT3Jad4jrOq1zGt0Q4maEeTV57rdLtYNVnBM96vyVaGbaE4YgwfvO', 1, 'ROLE_MGR', 9),
(8, 'kbenghachame', '$2y$04$SE6NDj5qAIbCehmTsvU0jeocRrdZTDxDMQ9GapIhD9bnBgtQX.HA.', 1, 'ROLE_EMP', 6),
(9, 'malekaissa', '$2y$04$tajXWCrvBC7ow/rqfmz1i.Z4IPcZdoBa0GMltMFkkzPIiTGguHIgi', 1, 'ROLE_EMP', 8),
(10, 'maryemtlemseni', '$2y$04$PYOfQrM6MgHVY6myHfczsOlNVGXxllW0VD0/LYavV218kXluGm6km', 1, 'ROLE_EMP', 7),
(11, 'sanasaanouni', '$2y$04$BkD79ayx3QMaejraXzbqpOBkI4o051te7mMHu.srQCXavqqKqQLgG', 1, 'ROLE_EMP', 10),
(12, 'marwenmejri', '$2y$04$CNyDXJky.Z3Y1du0tokD6.rioMTQYlRluFekLrsgItPzzRt/hLKSq', 1, 'ROLE_EMP', 11),
(13, 'mayssahassine', '$2y$04$6Rbak.AKdlBl/ir1rNLNteJAbxnEJDoPjH2F2Zd9B2fIVAHbbDTCq', 1, 'ROLE_EMP', 12),
(14, 'mounachaouachi', '$2y$04$EyNVxSrtBJKMG8NqATSv1uhDeZoEOrY4.uk1Ou/4jZABL8kOssJae', 1, 'ROLE_EMP', 13);











SELECT '===========================>> Setting PRIMARY KEYs && UNIQUE CONSTRAINTs <<===========================' AS DESC_SCRIPT
FROM DUAL;





ALTER TABLE assignments
  ADD PRIMARY KEY (employee_id,project_id,commit_date),
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
  MODIFY department_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE employees
  MODIFY employee_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

ALTER TABLE locations
  MODIFY location_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE projects
  MODIFY project_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE user_credentials
  MODIFY user_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;





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
  employee_id int(11) NOT NULL,
  project_id int(11) NOT NULL,
  commit_date timestamp NOT NULL DEFAULT current_timestamp(),
  commit_emp_desc varchar(255) DEFAULT NULL,
  commit_mgr_desc varchar(255) DEFAULT NULL
);



INSERT INTO assignments (employee_id, project_id, commit_date, commit_emp_desc, commit_mgr_desc) VALUES
(1, 1, '2020-11-26 10:50:09', NULL, 'init'),
(1, 1, '2020-11-26 13:14:22', 'set up some configs', 'you need to implement sec solution'),
(1, 1, '2020-12-12 16:49:42', 'implement customer by invoice', NULL),
(1, 1, '2020-12-12 17:04:14', 'suspend customers...', NULL),
(1, 1, '2020-12-12 17:04:30', 'suspe', NULL),
(1, 1, '2020-12-12 17:25:48', 'created new customer suspension', NULL),
(1, 2, '2020-11-26 10:51:59', NULL, 'init'),
(1, 2, '2020-11-26 13:14:22', 'generate xml file', 'check out marshaling correctness'),
(1, 2, '2020-12-12 11:57:18', 'files on CRMIMX', NULL),
(1, 2, '2020-12-12 12:13:51', '00000', NULL),
(1, 2, '2020-12-12 12:23:39', 'Set up xml for CRMIMX1', NULL),
(1, 2, '2020-12-12 12:30:14', 'implement BSCSIMX2 business layer', NULL),
(1, 2, '2020-12-12 12:37:53', 'synchronize BSCSIMX2', NULL),
(1, 2, '2020-12-12 16:40:17', 'create a simple xml file for IMX CX', NULL),
(1, 2, '2020-12-12 16:43:48', 'synchronize xml and Java file', NULL),
(1, 2, '2020-12-17 19:29:17', 'take it easy with Spring Boot***********', NULL),
(1, 2, '2020-12-19 12:05:23', 'Generate new XML file for CRMIMX2', NULL),
(2, 5, '2020-11-26 10:52:32', NULL, 'init'),
(2, 5, '2020-12-12 15:10:28', 'samtan l ma9rouna', NULL),
(2, 5, '2020-12-12 15:10:57', 'sa9i l ma9rouna fel keskess', NULL),
(2, 5, '2020-12-12 15:12:10', '7ot salsa 3al ma9rouna', NULL),
(2, 6, '2020-12-19 11:04:29', NULL, 'init'),
(2, 6, '2020-12-19 11:16:53', 'set info', NULL),
(2, 6, '2020-12-19 11:17:12', 'set layers', NULL),
(2, 6, '2020-12-19 11:17:29', 'some front', NULL),
(2, 7, '2020-12-19 11:04:29', NULL, 'init'),
(2, 7, '2020-12-19 11:17:44', 'setup some classes', NULL),
(2, 7, '2020-12-19 11:17:58', 'implement some solutions', NULL),
(3, 4, '2020-12-13 19:55:14', NULL, 'init'),
(3, 4, '2020-12-17 11:20:47', 'ta7dhirat..........', NULL),
(3, 4, '2020-12-17 11:30:09', 'ta7dhirat ........$$**', NULL),
(3, 9, '2020-12-19 16:06:20', NULL, 'init'),
(6, 1, '2020-11-26 10:49:41', NULL, 'init'),
(6, 1, '2020-11-26 10:50:53', 'SET UP DIFFERENT LAYERS', NULL),
(6, 1, '2020-12-12 15:16:55', 'import new libs', NULL),
(6, 1, '2020-12-12 15:17:31', 'set exception payload', NULL),
(10, 6, '2020-12-19 11:34:11', NULL, 'init'),
(10, 6, '2020-12-19 11:36:34', 'set some configs', NULL),
(10, 6, '2020-12-19 11:37:11', 'configure some properties', NULL),
(10, 7, '2020-12-19 11:38:00', 'configure some properties', NULL),
(10, 7, '2020-12-19 11:38:22', 'set configs', NULL),
(11, 6, '2020-12-19 11:34:29', NULL, 'init'),
(11, 6, '2020-12-19 11:40:50', 'set up a new container for deployment', NULL),
(11, 6, '2020-12-19 11:41:17', 'configure my new container', NULL),
(11, 7, '2020-12-19 11:41:57', NULL, 'init'),
(11, 7, '2020-12-19 11:42:33', 'containerize a service', NULL),
(11, 7, '2020-12-19 15:48:03', 'create a new container', NULL),
(12, 8, '2020-12-19 16:05:28', NULL, 'init'),
(12, 8, '2020-12-19 16:08:52', 'setting greenplume env locally', NULL),
(12, 8, '2020-12-19 16:09:52', 'open workspace', NULL),
(12, 9, '2020-12-19 16:05:41', NULL, 'init'),
(12, 9, '2020-12-19 16:11:00', 'design first functionality', NULL),
(12, 9, '2020-12-19 16:11:20', 'design second functionality', NULL),
(13, 8, '2020-12-19 16:05:55', NULL, 'init'),
(13, 8, '2020-12-19 16:11:59', 'set envirnment', NULL),
(13, 8, '2020-12-19 16:12:13', 'new click', NULL),
(13, 9, '2020-12-19 16:06:09', NULL, 'init'),
(13, 9, '2020-12-19 16:13:01', 'get first ids', NULL),
(13, 9, '2020-12-19 16:13:17', 'create new workspace', NULL);



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
  employee_id int(11) NOT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT 'springabcxyzboot@gmail.com' NOT NULL,
  phone varchar(50) DEFAULT '22125144' NOT NULL,
  hiredate date DEFAULT NULL,
  job varchar(255) DEFAULT NULL,
  salary decimal(7,2) DEFAULT NULL,
  manager_id int(11) DEFAULT NULL,
  department_id int(11) DEFAULT NULL
);



INSERT INTO employees (employee_id, first_name, last_name, email, phone, hiredate, job, salary, manager_id, department_id) VALUES
(1, 'Selim', 'Horri', 'springabcxyzboot@gmail.com', '22125144', '2019-04-15', 'Billing', '5000.00', 4, 6),
(2, 'Badr', 'Idoudi', 'springabcxyzboot@gmail.com', '22125144', '2019-04-15', 'Digital', '5000.00', 9, 5),
(3, 'Imen', 'Touk', 'springabcxyzboot@gmail.com', '22125144', '2019-04-15', 'Data Warehouse', '5000.00', 5, 4),
(4, 'Soumaya', 'Hajjem', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Chef service Billing', '6000.00', NULL, 6),
(5, 'Nour', 'Larguech', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Chef service Data Warehouse', '6000.00', NULL, 4),
(6, 'Khdija', 'Ben Ghachame', 'springabcxyzboot@gmail.com', '22125144', '2559-01-01', 'Billing', '5000.50', 4, 6),
(7, 'Maryem', 'Tlemseni', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Billing', '5000.00', 4, 6),
(8, 'Malek', 'Aissa', 'springabcxyzboot@gmail.com', '22125144', '2020-09-01', 'Billing', '5000.00', 4, 6),
(9, 'John', 'Doe', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Chef service digital', '6000.00', NULL, 5),
(10, 'Sana', 'Saanouni', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Digital', '5000.00', 9, 5),
(11, 'Marwen', 'Mejri', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Digital', '5000.60', 9, 5),
(12, 'Mayssa', 'Hassine', 'springabcxyzboot@gmail.com', '22125144', '2019-04-30', 'Data Warehouse', '5000.00', 5, 4),
(13, 'Mouna', 'Chaouachi', 'springabcxyzboot@gmail.com', '22125144', NULL, 'Data Warehouse', '5000.50', 5, 4),
(14, 'admin', 'admin', 'springabcxyzboot@gmail.com', '22125144', NULL, 'RH', '5000.00', NULL, NULL);



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
  project_id int(11) NOT NULL,
  title varchar(255) DEFAULT NULL,
  start_date date DEFAULT NULL,
  end_date date DEFAULT NULL,
  status varchar(255) DEFAULT NULL
);



INSERT INTO projects (project_id, title, start_date, end_date, status) VALUES
(1, 'TRANSBSCS', '2020-09-28', '2020-11-04', 'COMPLETED'),
(2, 'SYNCH_BSCS_IMX', '2020-11-26', '2021-03-25', 'IN_PROGRESS'),
(3, 'TASYI9A LILVIRANDA', '2020-11-26', '2020-11-26', 'COMPLETED'),
(4, 'MACHYA_RANDONNEE', '2021-01-29', '2021-04-30', 'NOT_STARTED'),
(5, 'TATIB LEFTOUR', '2020-11-14', '2020-11-14', 'COMPLETED'),
(6, 'ChatBot', '2020-12-11', '2021-01-30', 'NOT_STARTED'),
(7, 'MyOoredoo', '2018-08-01', '2021-05-14', 'IN_PROGRESS'),
(8, 'GREENPLUME_UPGRADE', '2020-11-02', '2021-05-01', 'IN_PROGRESS'),
(9, 'COMMISION_AUTOMATION', '2020-06-01', '2021-03-02', 'IN_PROGRESS');



CREATE TABLE user_credentials (
  user_id int(11) NOT NULL,
  username varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  enabled tinyint(1) DEFAULT 1 NOT NULL,
  role varchar(255) DEFAULT NULL,
  employee_id int(11) DEFAULT NULL
);



INSERT INTO user_credentials (user_id, username, password, enabled, role, employee_id) VALUES
(1, 'imentouk', '$2y$04$8jC1Xb/fKB3EQIHy0XoFUunQNhjiVpvuMZys6iCOkphCAsyBkmCTC', 1, 'ROLE_EMP', 3),
(2, 'badridoudi', '$2y$04$c09yvJ4rcadTRGaoVQRRZugld/9z377uaIHwRCWxexBADCVT.jC4S', 1, 'ROLE_EMP', 2),
(3, 'selimhorri', '$2a$10$ldBd/ZuGtUgxHNKd.qCGxuPVVM5oZ6kHkKyu5By8NIQxrv4rV9O/C', 1, 'ROLE_EMP', 1),
(4, 'admin', '$2y$04$HLi44N6cb6xmLYHdABF/euCgpk0LofYk4VdIeO1DAn.Ol1Bnaj3vW', 1, 'ROLE_ADMIN', 14),
(5, 'soumayahajjem', '$2y$04$ljw6KJaAkzMzJZOf8eU6qOoq7jV2SXRqeg7uHS7tQb6x86SBS/oEW', 1, 'ROLE_MGR', 4),
(6, 'nourlarguech', '$2y$04$ngbUBXKPaTRFAUFEifgPpuqmBTf4VjUJL.eGpeEIGwI/iiE18ZSny', 1, 'ROLE_MGR', 5),
(7, 'johndoe', '$2y$04$CT3Jad4jrOq1zGt0Q4maEeTV57rdLtYNVnBM96vyVaGbaE4YgwfvO', 1, 'ROLE_MGR', 9),
(8, 'kbenghachame', '$2y$04$SE6NDj5qAIbCehmTsvU0jeocRrdZTDxDMQ9GapIhD9bnBgtQX.HA.', 1, 'ROLE_EMP', 6),
(9, 'malekaissa', '$2y$04$tajXWCrvBC7ow/rqfmz1i.Z4IPcZdoBa0GMltMFkkzPIiTGguHIgi', 1, 'ROLE_EMP', 8),
(10, 'maryemtlemseni', '$2y$04$PYOfQrM6MgHVY6myHfczsOlNVGXxllW0VD0/LYavV218kXluGm6km', 1, 'ROLE_EMP', 7),
(11, 'sanasaanouni', '$2y$04$BkD79ayx3QMaejraXzbqpOBkI4o051te7mMHu.srQCXavqqKqQLgG', 1, 'ROLE_EMP', 10),
(12, 'marwenmejri', '$2y$04$CNyDXJky.Z3Y1du0tokD6.rioMTQYlRluFekLrsgItPzzRt/hLKSq', 1, 'ROLE_EMP', 11),
(13, 'mayssahassine', '$2y$04$6Rbak.AKdlBl/ir1rNLNteJAbxnEJDoPjH2F2Zd9B2fIVAHbbDTCq', 1, 'ROLE_EMP', 12),
(14, 'mounachaouachi', '$2y$04$EyNVxSrtBJKMG8NqATSv1uhDeZoEOrY4.uk1Ou/4jZABL8kOssJae', 1, 'ROLE_EMP', 13);











SELECT '===========================>> Setting PRIMARY KEYs && UNIQUE CONSTRAINTs <<===========================' AS DESC_SCRIPT
FROM DUAL;





ALTER TABLE assignments
  ADD PRIMARY KEY (employee_id,project_id,commit_date),
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
  MODIFY department_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE employees
  MODIFY employee_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

ALTER TABLE locations
  MODIFY location_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE projects
  MODIFY project_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

ALTER TABLE user_credentials
  MODIFY user_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;





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




