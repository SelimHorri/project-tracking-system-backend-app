
CREATE TABLE employees (
  employee_id int(11) NOT NULL primary key auto_increment,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT 'springabcxyzboot@gmail.com' NOT NULL,
  phone varchar(50) DEFAULT '22125144' NOT NULL,
  hiredate date DEFAULT NULL,
  job varchar(255) DEFAULT NULL,
  salary double DEFAULT NULL,
  manager_id int(11) DEFAULT NULL,
  department_id int(11) DEFAULT NULL
);
