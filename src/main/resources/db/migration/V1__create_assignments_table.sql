
CREATE TABLE assignments (
  employee_id int(11) NOT NULL,
  project_id int(11) NOT NULL,
  commit_date timestamp NOT NULL DEFAULT current_timestamp,
  commit_emp_desc varchar(255) DEFAULT NULL,
  commit_mgr_desc varchar(255) DEFAULT NULL,
  primary key (employee_id, project_id, commit_date)
);
