
ALTER TABLE assignments
  ADD CONSTRAINT fk2_assign FOREIGN KEY (employee_id) REFERENCES employees (employee_id);
