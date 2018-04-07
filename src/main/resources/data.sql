CREATE TABLE Company
(
id NUMERIC not null,
title VARCHAR(255) not null,
PRIMARY KEY(id)
);
INSERT INTO Company(id, title) VALUES(1, 'Apple');
INSERT INTO Company(id, title) VALUES(2, 'Samsung');
INSERT INTO Company(id, title) VALUES(3, 'Xiaomi');
INSERT INTO Company(id, title) VALUES(4, 'Hp');

CREATE TABLE Owner
(
id NUMERIC not null,
companyId NUMERIC not null,
firstName VARCHAR(255) not null,
secondName VARCHAR(255) not null,
PRIMARY KEY(id)
);
INSERT INTO Owner(id, companyId, firstName, secondName) VALUES(1, 1, 'Sansa', 'Stark');
INSERT INTO Owner(id, companyId, firstName, secondName) VALUES(2, 2, 'Daenerys', 'Targaryen');
INSERT INTO Owner(id, companyId, firstName, secondName) VALUES(3, 3, 'Jon', 'Snow');
INSERT INTO Owner(id, companyId, firstName, secondName) VALUES(4, 4, 'Tyrion', 'Lannister');

CREATE TABLE Account
(
id NUMERIC not null,
ownerId NUMERIC not null,
name VARCHAR(255) not null,
rate NUMERIC not null,
PRIMARY KEY(id)
);
INSERT INTO Account(id, ownerId, name, rate) VALUES(1, 1, 'Sansa', 20.0);
INSERT INTO Account(id, ownerId, name, rate) VALUES(2, 2, 'Daenerys', 25.0);
INSERT INTO Account(id, ownerId, name, rate) VALUES(3, 3, 'Jon', 35.0);
INSERT INTO Account(id, ownerId, name, rate) VALUES(4, 4, 'Tyrion', 30.0);