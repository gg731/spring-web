CREATE SEQUENCE IF NOT EXISTS authorities_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE IF NOT EXISTS course_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE IF NOT EXISTS student_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE IF NOT EXISTS teacher_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
CREATE SEQUENCE IF NOT EXISTS users_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

DELETE FROM COURSE;
INSERT INTO COURSE(ID, NAME, DURATION) VALUES(nextval('course_seq'), 'Java 1', 10);
INSERT INTO COURSE(ID, NAME, DURATION) VALUES(nextval('course_seq'), 'Java 2', 20);
INSERT INTO COURSE(ID, NAME, DURATION) VALUES(nextval('course_seq'), 'Java 3', 30);
INSERT INTO COURSE(ID, NAME, DURATION) VALUES(nextval('course_seq'), 'Java 4', 40);
INSERT INTO COURSE(ID, NAME, DURATION) VALUES(nextval('course_seq'), 'Java 5', 50);
INSERT INTO COURSE(ID, NAME, DURATION) VALUES(nextval('course_seq'), 'Java 6', 60);
INSERT INTO COURSE(ID, NAME, DURATION) VALUES(nextval('course_seq'), 'Java 7', 70);
INSERT INTO COURSE(ID, NAME, DURATION) VALUES(nextval('course_seq'), 'Java 8', 80);

DELETE FROM TEACHER;
INSERT INTO TEACHER(ID, FIO, ABOUT) VALUES(nextval('teacher_seq'), 'Иванов Иван', 'Java junior');
INSERT INTO TEACHER(ID, FIO, ABOUT) VALUES(nextval('teacher_seq'), 'Петров Петр', 'Java middle');
INSERT INTO TEACHER(ID, FIO, ABOUT) VALUES(nextval('teacher_seq'), 'Сидоров Сидр', 'Java senior');

DELETE FROM STUDENT;
INSERT INTO STUDENT(ID, FIO, BIRTH, SCORE) VALUES(nextval('student_seq'), 'Иванов Иван', '2020-05-17 0000:00:00', 100);
INSERT INTO STUDENT(ID, FIO, BIRTH, SCORE) VALUES(nextval('student_seq'), 'Петров Петр', '2020-05-17 0000:00:00', 200);
INSERT INTO STUDENT(ID, FIO, BIRTH, SCORE) VALUES(nextval('student_seq'), 'Сидоров Сидр', '2020-05-17 0000:00:00', 300);


DELETE FROM AUTHORITIES;
DELETE FROM USERS;
INSERT INTO USERS(id, username, password, enabled) VALUES (nextval('users_seq'), 'admin', '$2a$10$/nQbhIIuxbFzhz2RGKQaVuXbrvs4LcbO0Owmdbun8.NJ65SUZwMcm', true);
INSERT INTO AUTHORITIES(id, username, authority) VALUES(nextval('authorities_seq'), 'admin', 'ROLE_ADMIN');