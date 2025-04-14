CREATE DATABASE movie_reviews_db;
USE movie_reviews_db;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    email VARCHAR(40) UNIQUE,
    mobile VARCHAR(15),
    birth_date DATE,
    password VARCHAR(100) -- Should store hashed passwords
);

CREATE TABLE movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) UNIQUE,
    rel_date DATE,
    genre VARCHAR(50)
);

CREATE TABLE reviews (
    id INT PRIMARY KEY AUTO_INCREMENT,
    movie_id INT,
    review VARCHAR(1024),
    rating INT CHECK (rating BETWEEN 1 AND 5),
    user_id INT,
    modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE,
    UNIQUE (user_id, movie_id)
);

CREATE TABLE shares (
    review_id INT,
    user_id INT,
    share_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (review_id) REFERENCES reviews(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    PRIMARY KEY (review_id, user_id)
);

-- Insert users
INSERT INTO users (first_name, last_name, email, mobile, birth_date, password) VALUES
('John', 'Doe', 'john.doe@example.com', '+12025550123', '1990-05-15', 'hashed_pass1'),
('Jane', 'Smith', 'jane.smith@example.com', '+12025550124', '1985-08-22', 'hashed_pass2'),
('Alice', 'Johnson', 'alice.j@example.com', '+12025550125', '1995-03-10', 'hashed_pass3'),
('Bob', 'Brown', 'bob.brown@example.com', '+12025550126', '1988-11-30', 'hashed_pass4');

-- Insert movies
INSERT INTO movies (title, rel_date, genre) VALUES
('Inception', '2010-07-16', 'Sci-Fi'),
('The Shawshank Redemption', '1994-09-23', 'Drama'),
('The Dark Knight', '2008-07-18', 'Action'),
('Pulp Fiction', '1994-10-14', 'Crime');

-- Insert reviews
INSERT INTO reviews (movie_id, review, rating, user_id) VALUES
(1, 'Mind-bending and thrilling!', 5, 1),
(1, 'Confusing but brilliant.', 4, 2),
(2, 'A timeless masterpiece.', 5, 3),
(3, 'Heath Ledger was phenomenal.', 4, 4),
(4, 'Quentin at his best.', 5, 1),
(3, 'Action-packed and intense.', 4, 2);

-- Insert shares
INSERT INTO shares (review_id, user_id) VALUES
(1, 2), -- Jane shares John's Inception review
(2, 3), -- Alice shares Jane's Inception review
(3, 4), -- Bob shares Alice's Shawshank review
(4, 1); -- John shares Bob's Dark Knight review