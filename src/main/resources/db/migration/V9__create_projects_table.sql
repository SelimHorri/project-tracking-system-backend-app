
CREATE TABLE projects (
  project_id int(11) NOT NULL primary key auto_increment,
  title varchar(255) DEFAULT NULL,
  start_date date DEFAULT NULL,
  end_date date DEFAULT NULL,
  status varchar(255) DEFAULT NULL
);
