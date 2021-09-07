
ALTER TABLE user_credentials
  ADD CONSTRAINT fk1_u FOREIGN KEY (employee_id) REFERENCES employees (employee_id);
