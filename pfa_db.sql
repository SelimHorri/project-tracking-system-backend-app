
DROP DATABASE IF EXISTS pfa_db;

CREATE DATABASE pfa_db;
USE pfa_db;

CREATE TABLE projects (
	project_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title varchar(200) DEFAULT NULL,
	start_date date DEFAULT NULL,
	end_date date DEFAULT NULL,
	status varchar(200) DEFAULT NULL
);

CREATE TABLE locations (
	location_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	adr varchar(200) DEFAULT NULL,
	postal_code varchar(200) DEFAULT NULL,
	city varchar(200) DEFAULT NULL
);

CREATE TABLE departments (
	department_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	department_name varchar(200) DEFAULT NULL,
	location_id int DEFAULT NULL,
	CONSTRAINT FOREIGN KEY (location_id) REFERENCES locations (location_id)
);

CREATE TABLE employees (
	employee_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	first_name varchar(200) DEFAULT NULL,
	last_name varchar(200) DEFAULT NULL,
	email varchar(200) DEFAULT NULL,
	phone varchar(20) DEFAULT NULL,
	hiredate date DEFAULT NULL,
	job varchar(200) DEFAULT NULL,
	salary decimal(7, 2) DEFAULT NULL,
	manager_id int DEFAULT NULL,
	department_id int DEFAULT NULL,
	UNIQUE(email)
);

CREATE TABLE user_credentials (
	user_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	username varchar(200) DEFAULT NULL,
	password varchar(200) DEFAULT NULL,
	enabled boolean DEFAULT true,
	role varchar(200) DEFAULT NULL,
	employee_id int DEFAULT NULL,
	UNIQUE(username)
);

CREATE TABLE assignments (
	employee_id int NOT NULL,
	project_id int NOT NULL,
	commit_date date NOT NULL,
	commit_emp_desc varchar(200) DEFAULT NULL,
	commit_mgr_desc varchar(200) DEFAULT NULL,
	PRIMARY KEY (employee_id, project_id, commit_date)
);


ALTER TABLE user_credentials
	ADD CONSTRAINT fk1_u FOREIGN KEY (employee_id) REFERENCES employees (employee_id);

ALTER TABLE assignments
	ADD CONSTRAINT fk1_a FOREIGN KEY (employee_id) REFERENCES employees (employee_id);

ALTER TABLE assignments
	ADD CONSTRAINT fk2_a FOREIGN KEY (project_id) REFERENCES projects (project_id);

ALTER TABLE employees
	ADD CONSTRAINT fk1_e FOREIGN KEY (department_id) REFERENCES departments(department_id);

ALTER TABLE employees
	ADD CONSTRAINT fk2_e FOREIGN KEY (manager_id) REFERENCES employees (manager_id);


COMMIT;















