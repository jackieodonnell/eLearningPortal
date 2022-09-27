BEGIN TRANSACTION;
DELETE FROM users;
DELETE FROM course;
DELETE FROM course_student;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('markdarby','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TEACHER');
INSERT INTO users (username,password_hash,role) VALUES ('jackieodonnell','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('prestonphillips','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');
INSERT INTO users (username,password_hash,role) VALUES ('williamkendig','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT');


INSERT INTO course(teacher_id, course_title, course_description, difficulty_level, cost) 
	VALUES(3, 'Algebra 1', 'algebra and stuff', 6, 0);
INSERT INTO course(teacher_id, course_title, course_description, difficulty_level, cost) 
	VALUES(3, 'Biology', 'biology and stuff', 7, 0);
INSERT INTO course(teacher_id, course_title, course_description, difficulty_level, cost) 
	VALUES(3, 'English 1', 'english and stuff', 8, 0);
INSERT INTO course(teacher_id, course_title, course_description, difficulty_level, cost) 
	VALUES(3, 'US History', 'us history and stuff', 7, 0);
	
INSERT INTO course_student(student_id, course_id) VALUES(4, 1);
INSERT INTO course_student(student_id, course_id) VALUES(5, 1);
INSERT INTO course_student(student_id, course_id) VALUES(6, 1);
INSERT INTO course_student(student_id, course_id) VALUES(4, 2);
INSERT INTO course_student(student_id, course_id) VALUES(5, 2);
INSERT INTO course_student(student_id, course_id) VALUES(6, 3);
INSERT INTO course_student(student_id, course_id) VALUES(5, 3);
INSERT INTO course_student(student_id, course_id) VALUES(4, 4);
INSERT INTO course_student(student_id, course_id) VALUES(6, 4);

COMMIT TRANSACTION;