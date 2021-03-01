
CREATE TABLE user_credentials (
  user_id int(11) NOT NULL primary key auto_increment,
  username varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  enabled BOOLEAN DEFAULT true NOT NULL,
  role varchar(255) DEFAULT NULL,
  employee_id int(11) DEFAULT NULL
);
