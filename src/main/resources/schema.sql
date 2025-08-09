CREATE TABLE users (
  id INT PRIMARY KEY,
  full_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL
);

CREATE TABLE classroom (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    capacity INT NOT NULL
);
CREATE TABLE reservation (
    id INT PRIMARY KEY,
    classroom_id INT NOT NULL,
    user_id INT NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    CONSTRAINT fk_classroom FOREIGN KEY (classroom_id) REFERENCES classroom(id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);
