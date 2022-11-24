BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

---------------OUR TEST DATA------------------
INSERT INTO users (username,password_hash,role) VALUES ('user4','user4','ROLE_TEACHER');
INSERT INTO users (username,password_hash,role) VALUES ('user5','user5','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('user6','user6','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('user7','user7','ROLE_TEACHER');

INSERT INTO course (teacher_id, course_title, course_description, difficulty_level, cost) VALUES (4, 'course1', 'courseStuff', '5', 0);
INSERT INTO course (teacher_id, course_title, course_description, difficulty_level, cost) VALUES (7, 'course2', 'courseStuff', '4', 0);

INSERT INTO course_student (student_id, course_id) VALUES (5, 1);
INSERT INTO course_student (student_id, course_id) VALUES (6, 1);
INSERT INTO course_student (student_id, course_id) VALUES (5, 2);
INSERT INTO course_student (student_id, course_id) VALUES (6, 2);

COMMIT TRANSACTION;
