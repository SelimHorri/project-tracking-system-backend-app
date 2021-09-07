
CREATE TABLE assignments (
  employee_id int(11) NOT NULL,
  project_id int(11) NOT NULL,
  -- commit_date timestamp NOT NULL DEFAULT current_timestamp,
  commit_date TIMESTAMP DEFAULT LOCALTIMESTAMP NOT NULL NULL_TO_DEFAULT, -- H2 1.x
  -- commit_date TIMESTAMP DEFAULT LOCALTIMESTAMP DEFAULT ON NULL NOT NULL, -- must be added in H2 2.x 
  commit_emp_desc varchar(255) DEFAULT NULL,
  commit_mgr_desc varchar(255) DEFAULT NULL,
  primary key (employee_id, project_id, commit_date)
);
