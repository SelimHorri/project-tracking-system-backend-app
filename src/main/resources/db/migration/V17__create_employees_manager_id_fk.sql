
ALTER TABLE employees
  ADD CONSTRAINT fk2_emp FOREIGN KEY (manager_id) REFERENCES employees (employee_id);
