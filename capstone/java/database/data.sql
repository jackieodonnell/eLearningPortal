BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 
																			'user', 'user');
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN',
																			'admin', 'admin');
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('markdarby','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_TEACHER',
																			'Mark', 'Darby');
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('jackieodonnell','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT', 
																			'Jackie', 'O''Donnell');
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('prestonphillips','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT', 
																			'Preston', 'Phillips');
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('williamkendig','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_STUDENT', 
																			'William', 'Kendig');


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

SELECT user_id, username, first_name, last_name, course.course_title FROM users
JOIN course_student ON users.user_id = course_student.student_id
JOIN course ON course.course_id = course_student.course_id;

SELECT * FROM users