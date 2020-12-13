CREATE TABLE assignments (
  employee_id INT(11) NOT NULL,
  project_id INT(11) NOT NULL,
  commit_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  commit_emp_desc VARCHAR(255) DEFAULT NULL,
  commit_mgr_desc VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (employee_id, project_id, commit_date),
  ADD CONSTRAINT fk1_assign FOREIGN KEY (project_id) REFERENCES projects (project_id),
  ADD CONSTRAINT fk2_assign FOREIGN KEY (employee_id) REFERENCES employees (employee_id)
);