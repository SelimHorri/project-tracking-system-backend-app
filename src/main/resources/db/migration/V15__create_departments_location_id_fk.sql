
ALTER TABLE departments
  ADD CONSTRAINT fk1_dept FOREIGN KEY (location_id) REFERENCES locations (location_id);
