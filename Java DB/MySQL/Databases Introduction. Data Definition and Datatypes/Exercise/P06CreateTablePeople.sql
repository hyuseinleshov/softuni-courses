USE minions;

CREATE TABLE people (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    picture LONGBLOB,
    height DECIMAL(8, 2),
    weight DECIMAL(8, 2),
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO people (name, picture, height, weight, gender, birthdate, biography)
VALUES ('John Doe', NULL, 1.75, 70.5, 'm', '1990-05-15', 'John Doe is a software engineer with a passion for coding and technology.');

INSERT INTO people (name, picture, height, weight, gender, birthdate, biography)
VALUES ('Jane Smith', NULL, 1.65, 55.2, 'f', '1988-08-22', 'Jane Smith works in marketing and enjoys outdoor activities.');

INSERT INTO people (name, picture, height, weight, gender, birthdate, biography)
VALUES ('Alex Johnson', NULL, 1.80, 80.0, 'm', '1995-02-10', 'Alex Johnson is a graphic designer and loves creating digital art.');

INSERT INTO people (name, picture, height, weight, gender, birthdate, biography)
VALUES ('Emily Davis', NULL, 1.68, 62.3, 'f', '1992-11-30', 'Emily Davis is a teacher who is passionate about education and helping students.');

INSERT INTO people (name, picture, height, weight, gender, birthdate, biography)
VALUES ('Michael Brown', NULL, 1.85, 75.8, 'm', '1985-07-05', 'Michael Brown is a chef known for his culinary expertise and creativity.');
