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

INSERT INTO curriculum (course_id, curriculum_title, curriculum_description) VALUES (4, 'U.S. History', 'We will cover the history of the United States of America.');
INSERT INTO curriculum (course_id, curriculum_title, curriculum_description) VALUES (3, 'English 1', 'An introduction to basic English grammar.');

INSERT INTO daily_instructions (current_day, curriculum_id, instructions, assignment_id) VALUES ('03-10-2022', 1, '1.01 Creating a New Government', 1);
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, assignment_id) VALUES ('04-10-2022', 1, '1.02 The Bill Of Rights', 2);
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, assignment_id) VALUES ('05-10-2022', 1, '1.03 US Westward Expansion', 3);
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, assignment_id) VALUES ('06-10-2022', 1, '1.04 US Antebellum Movement', 4);
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, assignment_id) VALUES ('07-10-2022', 1, '1.05 Before US Civil War', 5);
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, assignment_id) VALUES ('10-10-2022', 1, '1.06 Reconstruction', 6);
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, assignment_id) VALUES ('11-10-2022', 1, '1.07 The US - End of 20th Century', 7);
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, assignment_id) VALUES ('12-10-2022', 1, '1.08 Historical Thinking', 8);
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, assignment_id) VALUES ('13-10-2022', 1, '1.09 Foundations of Gov', 9);
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, assignment_id) VALUES ('14-10-2022', 1, '1.10 Public Policy', 10);

INSERT INTO assignment (assignment_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES ('03-10-2022', '05-10-2022', '')

COMMIT TRANSACTION;

SELECT user_id, username, first_name, last_name, course.course_title FROM users
JOIN course_student ON users.user_id = course_student.student_id
JOIN course ON course.course_id = course_student.course_id;

SELECT * FROM users