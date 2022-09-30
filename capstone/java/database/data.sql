BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 
																			'user', 'user');
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN',
																			'admin', 'admin');
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('markdarby','$2a$10$iE97sq59HBlkA1l8NlO5ZOIOdsPlv6wMPJCueIJjRnEnG4Xkj0za6','ROLE_TEACHER',
																			'Mark', 'Darby');
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('jackieodonnell','$2a$10$iE97sq59HBlkA1l8NlO5ZOIOdsPlv6wMPJCueIJjRnEnG4Xkj0za6','ROLE_STUDENT', 
																			'Jackie', 'O''Donnell');
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('prestonphillips','$2a$10$iE97sq59HBlkA1l8NlO5ZOIOdsPlv6wMPJCueIJjRnEnG4Xkj0za6','ROLE_STUDENT', 
																			'Preston', 'Phillips');
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('williamkendig','$2a$10$iE97sq59HBlkA1l8NlO5ZOIOdsPlv6wMPJCueIJjRnEnG4Xkj0za6','ROLE_STUDENT', 
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

INSERT INTO curriculum (course_id, curriculum_title, curriculum_description)
    VALUES (4, 'U.S. History', 'We will cover the history of the United States of America.');
INSERT INTO curriculum (course_id, curriculum_title, curriculum_description)
    VALUES (3, 'English 1', 'An introduction to basic English grammar.');

INSERT INTO daily_instructions (current_day, curriculum_id, instructions)
    VALUES ('2022-10-03', 1, '1.01 Creating a New Government');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions)
    VALUES ('2022-10-04', 1, '1.02 The Bill Of Rights');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions)
    VALUES ('2022-10-05', 1, '1.03 US Westward Expansion');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions)
    VALUES ('2022-10-06', 1, '1.04 US Antebellum Movement');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions)
    VALUES ('2022-10-07', 1, '1.05 Before US Civil War');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions)
    VALUES ('2022-10-10', 1, '1.06 Reconstruction');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions)
    VALUES ('2022-10-11', 1, '1.07 The US - End of 20th Century');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions)
    VALUES ('2022-10-12', 1, '1.08 Historical Thinking');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions)
    VALUES ('2022-10-13', 1, '1.09 Foundations of Gov');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions)
    VALUES ('2022-10-14', 1, '1.10 Public Policy');

INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (1, '2022-10-03', '2022-10-05', '1.01 Checks and Balances Review Assignment', 'Write a 500 word summary on the importance of checks and balances in government', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (2, '2022-10-04', '2022-10-06', '1.02 Create Your Own Bill of Rights', 'Create your own Bill of Rights, modeled after the United States Constitution.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (3, '2022-10-05', '2022-10-07', '1.03 Westward Expansion Short-Answer Questions', 'Submit brief answers to each of the questions regarding Westward Expansions, as discussed in class.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (5, '2022-10-07', '2022-10-11', '1.05 Group Project on Pre-Civil War America', 'Collaborate with your assigned group - each student will submit a one-page summary of the events that led to the Civil War', 'homework');

COMMIT TRANSACTION;

