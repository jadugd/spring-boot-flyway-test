CREATE TABLE posts (
  id bigint(20) NOT NULL,
  title varchar(100) NOT NULL,
  description varchar(250) NOT NULL,
  content varchar(50) DEFAULT NULL,
  created_at datetime NOT NULL,
  updated_at datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;