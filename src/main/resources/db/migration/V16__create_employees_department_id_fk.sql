
ALTER TABLE employees
  ADD CONSTRAINT fk1_emp FOREIGN KEY (department_id) REFERENCES departments (department_id);
