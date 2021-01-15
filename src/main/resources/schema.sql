
CREATE TABLE users (
  id BIGINT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50),
  name VARCHAR(50),
  password VARCHAR(255),
  roles VARCHAR(100),
  enabled BOOLEAN,
  PRIMARY KEY(id),
  UNIQUE(username)
);
