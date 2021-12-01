CREATE TABLE person (
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);

INSERT INTO person(id, name, location, birth_date) VALUES(1001, 'Piyush', 'Bangalore', sysdate());

INSERT INTO person(id, name, location, birth_date) VALUES(1004, 'Piyush', 'Bangalore', sysdate());

INSERT INTO person(id, name, location, birth_date) VALUES(1002, 'Naruto', 'Konoha', sysdate());

INSERT INTO person(id, name, location, birth_date) VALUES(1003, 'Hinata', 'Karasuno', sysdate());

INSERT INTO person(id, name, location, birth_date) VALUES(1006, 'Eren yeager', 'Paradise', sysdate());