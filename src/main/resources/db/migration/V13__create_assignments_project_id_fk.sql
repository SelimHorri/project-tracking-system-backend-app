
ALTER TABLE assignments
  ADD CONSTRAINT fk1_assign FOREIGN KEY (project_id) REFERENCES projects (project_id);
