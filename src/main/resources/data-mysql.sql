INSERT INTO address (STREET_NAME, HOUSE_NUMBER, CITY_NAME, CITY_CODE, COUNTRY_NAME)
VALUES ('Hauptstrasse', '1', 'Berlin', '12345', 'Deutschland'),
       ('Hauptstrasse', '2', 'Essen', '99999', 'England'),
       ('Hauptstrasse', '3', 'Bern', '45678', 'Schweiz'),
       ('Hauptstrasse', '4', 'Köln', '45678', 'Deutschland'),
       ('Hauptstrasse', '5', 'Rostock', '45678', 'Deutschland'),
       ('Universitätsstrasse', '1', 'Hamburg', '45678', 'Deutschland'),
       ('Universitätsstrasse', '2', 'München', '99999', 'Deutschland'),
       ('Universitätsstrasse', '3', 'Bern', '1234', 'Schweiz');

INSERT INTO course (COURSE_TITLE)
VALUES ('Course 1'),
       ('Course 2'),
       ('Course 3'),
       ('Course 4'),
       ('Course 5');

INSERT INTO university(NAME, ADDRESS_ID)
VALUES ('Universität Hamburg', 4),
       ('TU München', 5),
       ('Berguniversität', 6);

INSERT INTO student (FIRST_NAME, LAST_NAME, EMAIL, ADDRESS_ID, UNIVERSITY_ID)
VALUES ('Holger', 'Schmutz', 'holger@gmail123.com', 1, 1),
       ('Klaus', 'Sauber', 'klaus@gmail123.com', 2, 1),
       ('Dieter', 'Dreckig', 'dieter@gmail123.com', 3, 2),
       ('Berta', 'Blau', 'berta@gmail123.com', 4, 3),
       ('Karl-Heinz', 'Schmackofksy', 'karlheinz@gmail123.com', 5, 1);

INSERT INTO booked_courses (STUDENT_ID, COURSE_ID)
VALUES ('1', '1'),
       ('1', '2'),
       ('1', '3'),
       ('1', '4'),
       ('2', '1'),
       ('2', '2'),
       ('2', '3');

