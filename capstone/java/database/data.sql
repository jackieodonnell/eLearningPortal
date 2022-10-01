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

INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-03', 1, '1.01 Creating a New Government', 'The United States government is based on the principles of federalism and republicanism, in which power is shared between the national government and state governments. The interpretation and execution of these principles, including what powers the federal government should have and how those powers can be exercised, have been debated ever since the adoption of the Constitution. Some make a case for expansive federal powers while others argue for a more limited role for the central government in relation to individuals, the states, or other recognized entities. Since the American Civil War, the powers of the federal government have generally expanded greatly, although there have been periods since that time of legislative branch dominance (e.g., the decades immediately following the Civil War) or when states'' rights proponents have succeeded in limiting federal power through legislative action, executive prerogative or by a constitutional interpretation by the courts.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-04', 1, '1.02 The Bill Of Rights', E'The House and Senate each have particular exclusive powers. For example, the Senate must approve (give "advice and consent" to) many important presidential appointments, including cabinet officers, federal judges (including nominees to the Supreme Court), department secretaries (heads of federal executive branch departments), U.S. military and naval officers, and ambassadors to foreign countries. All legislative bills for raising revenue must originate in the House of Representatives. The approval of both chambers is required to pass all legislation, which then may only become law by being signed by the president (or, if the president vetoes the bill, both houses of Congress then re-pass the bill, but by a two-thirds majority of each chamber, in which case the bill becomes law without the president''s signature).\r\n\r\nThe powers of Congress are limited to those enumerated in the Constitution; all other powers are reserved to the states and the people. The Constitution also includes the "Necessary and Proper Clause", which grants Congress the power to "make all laws which shall be necessary and proper for carrying into execution the foregoing powers". Members of the House and Senate are elected by first-past-the-post voting in every state except Louisiana and Georgia, which have runoffs, and Maine and Alaska, which use ranked-choice voting.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-05', 1, '1.03 US Westward Expansion', 'The Constitution grants numerous powers to Congress. Enumerated in Article I, Section 8, these include the powers to levy and collect taxes; to coin money and regulate its value; provide for punishment for counterfeiting; establish post offices and roads, issue patents, create federal courts inferior to the Supreme Court, combat piracies and felonies, declare war, raise and support armies, provide and maintain a navy, make rules for the regulation of land and naval forces, provide for, arm and discipline the militia, exercise exclusive legislation in the District of Columbia, regulate interstate commerce, and to make laws necessary to properly execute powers. Over the two centuries since the United States was formed, many disputes have arisen over the limits on the powers of the federal government. These disputes have often been the subject of lawsuits that have ultimately been decided by the United States Supreme Court.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-06', 1, '1.04 US Antebellum Movement','');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-07', 1, '1.05 Before US Civil War','');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-10', 1, '1.06 Reconstruction','');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-11', 1, '1.07 The US - End of 20th Century','');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-12', 1, '1.08 Historical Thinking','');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-13', 1, '1.09 Foundations of Gov','');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-14', 1, '1.10 Public Policy','');

INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (1, '2022-10-03', '2022-10-05', '1.01 Checks and Balances Review Assignment', 'Write a 500 word summary on the importance of checks and balances in government', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (2, '2022-10-04', '2022-10-06', '1.02 Create Your Own Bill of Rights', 'Create your own Bill of Rights, modeled after the United States Constitution.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (3, '2022-10-05', '2022-10-07', '1.03 Westward Expansion Short-Answer Questions', 'Submit brief answers to each of the questions regarding Westward Expansions, as discussed in class.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (5, '2022-10-07', '2022-10-11', '1.05 Group Project on Pre-Civil War America', 'Collaborate with your assigned group - each student will submit a one-page summary of the events that led to the Civil War', 'homework');

COMMIT TRANSACTION;

