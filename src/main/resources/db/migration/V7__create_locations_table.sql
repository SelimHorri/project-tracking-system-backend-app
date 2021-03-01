
CREATE TABLE locations (
  location_id INT(11) NOT NULL primary key auto_increment,
  adr VARCHAR(255) DEFAULT NULL,
  postal_code VARCHAR(255) DEFAULT NULL,
  city VARCHAR(255) DEFAULT NULL
);
