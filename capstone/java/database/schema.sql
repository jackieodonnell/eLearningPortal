BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS course CASCADE;
DROP TABLE IF EXISTS course_student CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE course (
  course_id SERIAL PRIMARY KEY,
  teacher_id int,
  course_title varchar(50),
  course_description varchar (200),
  difficulty_level varchar(2),
  cost decimal(10,2)
);

CREATE TABLE course_student (
  student_id int,
  course_id int,
  PRIMARY KEY (student_id, course_id)
);

--CREATE TABLE curriculum (
--  curriculum_id SERIAL PRIMARY KEY,
--  course_id int
--);
--
--CREATE TABLE daily_instructions (
--  current_day date,
--  curriculum_id int,
--  instructions varchar,
--  assignment_id int,
--  PRIMARY KEY (current_date, curriculum_id)
--);
--
--CREATE TABLE assignment (
--  assignment_id int PRIMARY KEY,
--  assigned_date date,
--  due_date date,
--  assignment_title varchar,
--  assignment_description varchar,
--  assignment_type varchar
--);
--
--CREATE TABLE grades (
--  student_id int,
--  assignment_id int,
--  course_id int,
--  grade int,
--  PRIMARY KEY (student_id, assignment_id)
--);

ALTER TABLE course ADD FOREIGN KEY (teacher_id) REFERENCES users (user_id);

ALTER TABLE course_student ADD FOREIGN KEY (student_id) REFERENCES users (user_id);

ALTER TABLE course_student ADD FOREIGN KEY (course_id) REFERENCES course (course_id);

--ALTER TABLE curriculum ADD FOREIGN KEY (course_id) REFERENCES course (course_id);
--
--ALTER TABLE daily_instructions ADD FOREIGN KEY (curriculum_id) REFERENCES curriculum (curriculum_id);
--
--ALTER TABLE assignment ADD FOREIGN KEY (assignment_id) REFERENCES daily_instructions (assignment_id);
--
--ALTER TABLE grades ADD FOREIGN KEY (student_id) REFERENCES users (user_id);
--
--ALTER TABLE grades ADD FOREIGN KEY (assignment_id) REFERENCES assignment (assignment_id);
--
--ALTER TABLE grades ADD FOREIGN KEY (course_id) REFERENCES course (course_id);

COMMIT TRANSACTION;