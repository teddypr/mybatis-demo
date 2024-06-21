DROP TABLE IF EXISTS users;

CREATE TABLE users (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL,
 email VARCHAR(255) NOT NULL UNIQUE,
 PRIMARY KEY(id)
);

INSERT INTO users (name, email) VALUES ('Alice', 'alice@example.com');

