USE minions;

CREATE TABLE users (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL UNIQUE,
    `password` VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time TIMESTAMP,
    is_deleted BOOLEAN DEFAULT false
);

INSERT INTO users (username, `password`, profile_picture, last_login_time, is_deleted) VALUES
    ('user1', 'password1', NULL, '2024-01-21 12:00:00', false),
    ('user2', 'password2', NULL, '2024-01-20 15:30:00', false),
    ('user3', 'password3', NULL, '2024-01-19 08:45:00', true),
    ('user4', 'password4', NULL, '2024-01-18 10:20:00', false),
    ('user5', 'password5', NULL, '2024-01-17 14:00:00', false);
    
SELECT * FROM users;