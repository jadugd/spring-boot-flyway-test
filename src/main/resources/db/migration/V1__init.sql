CREATE TABLE posts (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  title varchar(100) NOT NULL,
  description varchar(250) NOT NULL,
  content text DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_title (title)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;