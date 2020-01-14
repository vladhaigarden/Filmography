CREATE TABLE actor (
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(255),
last_name VARCHAR(255),
salary DECIMAL(19,2)
);

CREATE TABLE movie (
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255),
genre VARCHAR(255),
budget DECIMAL(19,2)
);

CREATE TABLE actor_movie(
actor_id BIGINT NOT NULL,
movie_id BIGINT NOT NULL,
FOREIGN KEY (actor_id) REFERENCES actor (id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (movie_id) REFERENCES movie (id) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (actor_id, movie_id)
);