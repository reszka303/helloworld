DROP DATABASE IF EXISTS secret;

CREATE DATABASE IF NOT EXISTS secret;

CREATE TABLE secret.notes (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(45) NOT NULL UNIQUE,
    pass VARCHAR(45) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO
    secret.notes (title, pass, content)
VALUES
    ('abc', 'ABC123!@#', 'Na wczorajszym spotkaniu zarządu ustaliliśmy, że dywidenda wyniesie 10zł za akcję. Ta informajca nie może wypłynąć!'),
    ('xyz', 'trudnehaslo', 'Data premiery naszej nowej gry to 19 listopada. Proszę nie przekazywać tej informacji nikomu przed oficjalnym ogłoszeniem.');
