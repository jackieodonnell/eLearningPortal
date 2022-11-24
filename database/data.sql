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
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('jasonhelms','$2a$10$iE97sq59HBlkA1l8NlO5ZOIOdsPlv6wMPJCueIJjRnEnG4Xkj0za6','ROLE_STUDENT',
																			'Jason', 'Helms'); --7
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('cameronbowling','$2a$10$iE97sq59HBlkA1l8NlO5ZOIOdsPlv6wMPJCueIJjRnEnG4Xkj0za6','ROLE_STUDENT',
                                                                			'Cameron', 'Bowling'); --8
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('connorrilling','$2a$10$iE97sq59HBlkA1l8NlO5ZOIOdsPlv6wMPJCueIJjRnEnG4Xkj0za6','ROLE_STUDENT',
																			'Connor', 'Rilling'); --9
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('kylebones','$2a$10$iE97sq59HBlkA1l8NlO5ZOIOdsPlv6wMPJCueIJjRnEnG4Xkj0za6','ROLE_STUDENT',
																			'Kyle', 'Bones'); --10
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('student','$2a$10$pLH4VOqejQdahvM7.H5.c./09eU9yh.4Cb0GoL.Vk5nOBRfBStRuS','ROLE_STUDENT',
																			'Sally', 'Demo'); --11
INSERT INTO users (username,password_hash,role, first_name, last_name) VALUES ('teacher','$2a$10$f0nTn/8Jor8YEaMALF25jO8BppxaJ4MuOX9TpQ6Qd8vsc.NGrnfQu','ROLE_TEACHER',
																			'Sally', 'Demo'); --12

INSERT INTO course(teacher_id, course_title, course_description, difficulty_level, cost, isArchived)
	VALUES(3, 'Algebra 1', 'This course introduces students to variables, algebraic expressions, equations, inequalities, functions, and all their multiple representations.', 6, 0, false);
INSERT INTO course(teacher_id, course_title, course_description, difficulty_level, cost, isArchived)
	VALUES(3, 'Biology', 'This course focuses on introducing students to the diversity of life found on our planet.', 7, 0, false);
INSERT INTO course(teacher_id, course_title, course_description, difficulty_level, cost, isArchived)
	VALUES(12, 'English', 'This course adheres to the Common Core Standards for 8th grade English.', 8, 0, false);
INSERT INTO course(teacher_id, course_title, course_description, difficulty_level, cost, isArchived)
	VALUES(12, 'US History', 'In this course students will study United States History focusing on the Great Awakening to westward expansion.', 7, 0, false);
	
INSERT INTO course_student(student_id, course_id) VALUES(4, 1);
INSERT INTO course_student(student_id, course_id) VALUES(5, 1);
INSERT INTO course_student(student_id, course_id) VALUES(6, 1);
INSERT INTO course_student(student_id, course_id) VALUES(4, 2);
INSERT INTO course_student(student_id, course_id) VALUES(5, 2);
INSERT INTO course_student(student_id, course_id) VALUES(6, 3);
INSERT INTO course_student(student_id, course_id) VALUES(5, 3);
INSERT INTO course_student(student_id, course_id) VALUES(4, 4);
INSERT INTO course_student(student_id, course_id) VALUES(6, 4); --
INSERT INTO course_student(student_id, course_id) VALUES(7, 1);
INSERT INTO course_student(student_id, course_id) VALUES(8, 4);
INSERT INTO course_student(student_id, course_id) VALUES(9, 1);
INSERT INTO course_student(student_id, course_id) VALUES(7, 2);
INSERT INTO course_student(student_id, course_id) VALUES(8, 2);
INSERT INTO course_student(student_id, course_id) VALUES(9, 3);
INSERT INTO course_student(student_id, course_id) VALUES(8, 3);
INSERT INTO course_student(student_id, course_id) VALUES(7, 4);
INSERT INTO course_student(student_id, course_id) VALUES(9, 4);
INSERT INTO course_student(student_id, course_id) VALUES(10, 3);
INSERT INTO course_student(student_id, course_id) VALUES(10, 4);
INSERT INTO course_student(student_id, course_id) VALUES(10, 1);
INSERT INTO course_student(student_id, course_id) VALUES(11, 3);
INSERT INTO course_student(student_id, course_id) VALUES(11, 4);


INSERT INTO curriculum (course_id, curriculum_title, curriculum_description)
    VALUES (4, 'U.S. History', 'American History is a course designed for furthering your knowledge and appreciation of our nation''s past, present, and future. The course will develop an understanding of social, political, economical, cultural, and military experiences that have played a crucial role in shaping the history of our country.');
INSERT INTO curriculum (course_id, curriculum_title, curriculum_description)
    VALUES (3, 'English Writing', 'The 8th Grade curriculum is designed to expose you to many forms of text, reading skills, vocabulary, writing techniques, and grammatical concepts. We will work together to develop your ability to understand texts and think abstractly about what you have read.');
INSERT INTO curriculum (course_id, curriculum_title, curriculum_description)
    VALUES (2, 'Intro to Biology', 'Students will investigate biological concepts including the chemical basis of life, cell structure and function, metabolism, reproduction, genetics, evolution, biological diversity and classification, plant structure and function, animal structure and function and ecology.');
INSERT INTO curriculum (course_id, curriculum_title, curriculum_description)
    VALUES (1, 'Algebra 1', 'This curriculum develops basic algebraic skills, which prepare students to successfully complete other math courses, such as Geometry and Algebra II. Some of the topics studied are operations on real numbers, simplifying expressions, absolute value, solving linear equations and inequalities, exponential functions, ratios and proportions.');


-- US HISTORY INSTRUCTIONS & ASSIGNMENTS
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-03', 1, '1.01 Creating a New Government', 'The United States government is based on the principles of federalism and republicanism, in which power is shared between the national government and state governments. The interpretation and execution of these principles, including what powers the federal government should have and how those powers can be exercised, have been debated ever since the adoption of the Constitution. Some make a case for expansive federal powers while others argue for a more limited role for the central government in relation to individuals, the states, or other recognized entities. Since the American Civil War, the powers of the federal government have generally expanded greatly, although there have been periods since that time of legislative branch dominance (e.g., the decades immediately following the Civil War) or when states'' rights proponents have succeeded in limiting federal power through legislative action, executive prerogative or by a constitutional interpretation by the courts.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-04', 1, '1.02 The Bill Of Rights', 'The United States Bill of Rights comprises the first ten amendments to the United States Constitution. Proposed following the often bitter 1787–88 debate over the ratification of the Constitution and written to address the objections raised by Anti-Federalists, the Bill of Rights amendments add to the Constitution specific guarantees of personal freedoms and rights, clear limitations on the government''s power in judicial and other proceedings, and explicit declarations that all powers not specifically granted to the federal government by the Constitution are reserved to the states or the people. The concepts codified in these amendments are built upon those in earlier documents, especially the Virginia Declaration of Rights (1776), as well as the Northwest Ordinance (1787),[1] the English Bill of Rights (1689), and Magna Carta (1215). Largely because of the efforts of Representative James Madison, who studied the deficiencies of the Constitution pointed out by anti-federalists and then crafted a series of corrective proposals, Congress approved twelve articles of amendment on September 25, 1789, and submitted them to the states for ratification. Contrary to Madison''s proposal that the proposed amendments be incorporated into the main body of the Constitution (at the relevant articles and sections of the document), they were proposed as supplemental additions (codicils) to it.[3] Articles Three through Twelve were ratified as additions to the Constitution on December 15, 1791, and became Amendments One through Ten of the Constitution. Article Two became part of the Constitution on May 5, 1992, as the Twenty-seventh Amendment. Article One is still pending before the states.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-05', 1, '1.03 US Westward Expansion', 'A significant push toward the west coast of North America began in the 1810s. It was intensified by the belief in manifest destiny, federally issued Indian removal acts, and economic promise. Pioneers traveled to Oregon and California using a network of trails leading west. In 1893 historian Frederick Jackson Turner declared the frontier closed, citing the 1890 census as evidence, and with that, the period of westward expansion ended. Explore these resources to learn more about what happened between 1810 and 1893, as immigrants, American Indians, United States citizens, and freed slaves moved west.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-06', 1, '1.04 US Antebellum Movement','The Antebellum Period is a five-decade period in American history that spans the years after the War of 1812 but before the Civil War in 1861. This period saw the end of the Founding Fathers and their generation when questions of slavery and states rights remained unresolved in the grand experiment of the United States. Northern and Southern economies developed along different trajectories; abolitionists battled with slavery defenders in the courts of public opinion and sometimes with actual firearms, and political factions moved toward an unavoidable collision that resulted in the Civil War.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-07', 1, '1.05 Before US Civil War','Between the years 1849 and 1865, events that took place in the United States included the American Civil War and the turbulent years leading up to it, during which occurred many events that were critical in its origins. The nation underwent several economic and cultural changes as industrialization and the transportation revolution changed the economics of the Northern United States and the Western United States. Immigration also shifted the majority of the population further to the Northern United States and began a mass cultural change in the United States from the 1840s until the 1850s. Industrialization went forward in the Northwestern United States. A rail network and a telegraph network linked the nation economically, opening up new markets. Immigration brought millions of European workers and farmers to the Northern United States. In the Southern United States, planters shifted operations (and slaves) from the poor soils of the Southeastern United States to the rich cotton lands of the Southwestern United States. Issues of slavery in the new territories acquired in the Mexican–American War (1846–1848) were temporarily resolved by the Compromise of 1850. One provision, the Fugitive Slave Law, sparked intense controversy, as revealed in the enormous interest in the plight of the escaped slave in Uncle Tom''s Cabin, an 1852 anti-slavery novel and play.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-10', 1, '1.06 Reconstruction','Reconstruction, in U.S. history, the period (1865–77) that followed the American Civil War and during which attempts were made to redress the inequities of slavery and its political, social, and economic legacy and to solve the problems arising from the readmission to the Union of the 11 states that had seceded at or before the outbreak of war. Long portrayed by many historians as a time when vindictive Radical Republicans fastened Black supremacy upon the defeated Confederacy, Reconstruction has since the late 20th century been viewed more sympathetically as a laudable experiment in interracial democracy. Reconstruction witnessed far-reaching changes in America’s political life. At the national level, new laws and constitutional amendments permanently altered the federal system and the definition of American citizenship. In the South, a politically mobilized Black community joined with white allies to bring the Republican Party to power, and with it a redefinition of the responsibilities of government.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-11', 1, '1.07 The US - End of 20th Century','America''s postwar economy was the envy of the globe. A consumer-driven middle class built the highest standard of living in the world. American popular culture was everywhere. Levi''s jeans, Coca-Cola, McDonald''s, and Hollywood movies were enjoyed around the world.When the Soviet Union collapsed in 1991, the United States was the only remaining military superpower, and the world looked to Washington for leadership at combating aggression in the Persian Gulf, ending ethnic cleansing in places such as Kosovo, and halting nuclear proliferation. The NORTH AMERICAN FREE TRADE AGREEMENT (NAFTA) ended economic barriers with Canada and Mexico and promised even more prosperity.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-12', 1, '1.08 Historical Thinking','History has been integrally related to political and economic decision-making for centuries.  Our sense of our past in some ways shapes our sense of identity today.  This is why it is so easy to argue about what history is the "right" history.  Many individuals believe that we should not teach American students about some of the controversial problems in our country''s past (slavery, destroying the lives of Native Americans, the treatment of late nineteenth and early twentieth century immigrants from Japan, China, and Mexico, the internment of Japanese-Americans during World War II, the use of atomic weapons, and so forth).  Other individuals find greater inclusivity in history to be liberating.  What is important is to be able to identify issues and problems in the past and to analyze the interests, values, perspectives, and points of view of all of those involved.  One should examine the events of the past and think about what led up to them.  What might have been done differently to resolve problems?  What alternative actions might have been taken?  What can we learn about how people made decisions to do the things they did?  To answer these questions, you should be able to evaluate the implementation of a decision by analyzing the interests it served, by estimating the position, power, and priorities of each actor involved; by assessing the ethical dimensions of the decision; and by evaluating its costs and benefits from a variety of perspectives.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-13', 1, '1.09 Foundations of Gov','This unit builds the constitutional foundation for the study of nineteenth century American history. Throughout the unit students analyze the evolution of political thought that resulted in the adoption of the Constitution. Students begin their studies by exploring what life would be like without government. Using ideas from the Age of Enlightenment, they apply the natural rights philosophy and the social contract theory to examine the purposes of government and the meaning of a constitutional form of government. Next, students build upon what they learned in elementary school and develop more sophisticated understandings of colonial ideas about government and how the relationship between Great Britain and her colonies changed after the French and Indian War. As students examine the mounting tensions between Great Britain and its colonies, they reconsider concepts such as limited government, liberty under the rule of law (republicanism), and representative government. Using the Declaration of Independence as a touchstone, they examine how ideas from the Age of Enlightenment, the colonists’ experiences with self-government, and the changing interactions with Great Britain resulted in the colonists’ decision to declare independence. After exploring the colonists’ arguments in the Declaration, students learn how to write their own historical argument using evidence to support their assertions. Students then analyze the reasons for the adoption and subsequent failure of the Articles of Confederation. They use primary and secondary sources to examine the issues debated at the Constitutional Convention and analyze how and why the Framers resolved or compromised major concerns. In doing so, students examine the structure and functioning of the United States government under the Constitution through the principles of checks and balances, separation of powers, federalism, limited government, and popular sovereignty. By investigating the branches of government with particular focus on the powers, limits, structure, and function of each, students learn how the Constitution dramatically increased the powers of the central government in comparison to the Articles of Confederation. Students then examine the reasons for the inclusion of the Bill of Rights by exploring the arguments of the Federalists and Anti-Federalists over ratification of the Constitution. This unit sets the foundation for the course as students continue to explore the question: How have critical issues debated at the Constitutional Convention influenced government and policy throughout United States history?');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-14', 1, '1.10 Public Policy','Public policy can change the future of almost anything, even great wars. The participation of the United States in World War I and World War II reflected a dramatic shift in U.S. public policy, showing an expansion of U.S. policy influence. The evolution of public policy is marked by expansion of the power of the people as well as government. Throughout history public policy leaders have contributed to the approaches now seen in modern government. History takes place every day. People with a master of public administration and policy develop the skills and experience necessary for the analysis and administration of local and world-changing policies.');

INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (1, '2022-10-03', '2022-10-05', '1.01 Checks and Balances Review Assignment', 'Write a 500 word summary on the importance of checks and balances in government', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (2, '2022-10-04', '2022-10-06', '1.02 Create Your Own Bill of Rights', 'Create your own Bill of Rights, modeled after the United States Constitution.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (3, '2022-10-05', '2022-10-07', '1.03 Westward Expansion Short-Answer Questions', 'Submit brief answers to each of the questions regarding Westward Expansions, as discussed in class.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (5, '2022-10-07', '2022-10-11', '1.05 Group Project on Pre-Civil War America', 'Collaborate with your assigned group - each student will submit a one-page summary of the events that led to the Civil War', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (6, '2022-10-10', '2022-10-12', '1.06 Reconstruction Review Questions', 'How did the end of the war affect the nation? How did the ending of the Civil War affect newly freed enslaved people? What roles did newly freed enslaved people play after the Civil War and what was the reaction of Southern whites? What changes in the Constitution resulted from the Civil War? How did the decision to remove Union troops and end Reconstruction affect the nation?', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (7, '2022-10-11', '2022-10-13', '1.07 US 20th Century Vocabulary Exercise', 'Define the following content vocabulary from this unit in your own words: Dawes Act of 1887, Homestead Act, Plessy v. Ferguson, Transcontinental Railroad, George Armstrong Custer, Sitting Bull, Crazy Horse, Indian Wars, The Little Big Horn, John D. Rockefeller, J.P. Morgan, Henry Ford', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (8, '2022-10-12', '2022-10-17', '1.08 Pair Assignment - 10 Historical Thinking Questions', 'Work with your assigned partner to come up with a list of 10 historical thinking questions.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (9, '2022-10-13', '2022-10-17', '1.08 Pair Assignment - 10 Historical Thinking Questions', 'Work with your assigned partner to come up with a list of 10 historical thinking questions.', 'homework');

--ENGLISH INSTRUCTIONS & ASSIGNMENTS
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-10', 2, '1.1: The Writing Process', 'Writing can’t be done without going through certain stages. All writers go through their own unique writing processes before they make their final drafts. Usually, writers start with choosing topics and brainstorming, and then they may outline their papers, and compose sentences and paragraphs to make a rough draft. After they make a rough draft, writers may begin revising their work by adding more sentences, or removing sentences. Writers may then edit their rough draft by changing words and sentences that are grammatically incorrect or inappropriate for a topic.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-11', 2, '1.2: Effective Sentences and Word Choice', 'As an author, choosing the right words while writing a manuscript is crucial for success. Academic writing, like most other forms of writing, is a series of choices. When it’s time to write, you have to carefully choose words that can clearly express the idea and then decide how you will rearrange those words into phrases, sentences, and even paragraphs. A strong word choice makes it easier for readers to understand the concept. It clarifies, explains, and expands ideas. While evaluating word choice, it is important to address the concerns that restrict the author from disseminating correct information to the readers.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-12', 2, '1.3: Sentence Structure', 'Sentence structure is how the basic grammatical elements (a subject, predicate, and sometimes direct or indirect objects) of a sentence are put together. The rules for how a sentence is constructed are simple but firm. These include the necessity for a subject, predicate, and object (in that order) in every sentence. Beyond that, we can add additional elements like prepositions and dependent clauses. Advanced sentences can weave these elements together to create more and more complex structures. There are four types of sentence structure: Simple, Compound, Complex, Compound-Complex');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-13', 2, '1.4: Effective Paragraphs', 'There are two structures to learn in English that are important in writing: the sentence and the paragraph. Paragraphs can be described as a collection of sentences. These sentences combine to express a specific idea, main point, topic and so on. A number of paragraphs are then combined to write a report, an essay, or even a book. This guide to writing paragraphs describe the basic structure of each paragraph you will write. In general, the purpose of a paragraph is to express one main point, idea or opinion. Of course, writers may provide multiple examples to support their point. However, any supporting details should support the main idea of a paragraph.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-14', 2, '1.5: Writing an Essay', 'An English essay is an organized and analytical discussion and interpretation of a work or works of literature in English. There are many approaches to writing the English essay, but most start with you closely and actively reading, responding to and thinking about the text(s) being written about. You, the reader and essay writer, must ask and try to answer questions about what the work means, how it makes meaning, and how the author’s choices affect meaning. An English essay is built around what the essay writer thinks about the text(s), and the most important evidence and support in the essay will come from the texts themselves. Many English essays, then, are not research essays and require no use of secondary sources.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-17', 2, '2.1: Parts of a Sentence', 'Every word in a sentence serves a specific purpose within the structure of that particular sentence. According to rules of grammar, sentence structure can sometimes be quite complicated. For the sake of simplicity, however, the basic parts of a sentence are discussed here. The two most basic parts of a sentence are the subject and predicate. The subject of a sentence is the person, place, or thing that is performing the action of the sentence. The subject represents what or whom the sentence is about. The simple subject usually contains a noun or pronoun and can include modifying words, phrases, or clauses. The predicate expresses action or being within the sentence. The simple predicate contains the verb and can also contain modifying words, phrases, or clauses.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-18', 2, '2.2: Nouns and Pronouns', 'Nouns are one of the four major word classes, along with verbs, adjectives and adverbs. A noun identifies a person, animal or thing. Pronouns are words like he, she, yourself, mine, who, this and someone. Pronouns commonly refer to or fill the position of a noun or noun phrase. A determiner specifies the kind of reference a noun has. Common determiners are: the, those, my, her, both, all, several and no.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-19', 2, '2.3: Verbs', 'When most people think about verbs, they think about the first type: action verbs, also called dynamic verbs. This kind of verb tells you what''s happening or what someone is doing. Some action verbs describe physical actions, and they are easy to spot because you can observe them with at least one of your five senses. These are words such as jump, sing, and eat. On the other hand, some action verbs are more abstract, and they''re easy to miss sometimes because you can''t always observe them with your five senses. These are words such as think, learn, and decide. Unlike action verbs, linking verbs show a relationship between the main noun (also called the subject) and another word that describes that noun. The describing word can be an adjective or another noun. The most common linking verb is to be and its forms am, is, are, was, were, be, being, and been.');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-20', 2, '2.4: Adjectives, Adverbs, and Other Parts of Speech', 'Traditional grammar classifies words based on eight parts of speech: the verb, the noun, the pronoun, the adjective, the adverb, the preposition, the conjunction, and the interjection. Each part of speech explains not what the word is, but how the word is used. In fact, the same word can be a noun in one sentence and a verb or adjective in the next. An adjective modifies a noun or a pronoun by describing, identifying, or quantifying words. An adjective usually precedes the noun or the pronoun which it modifies. An adverb can modify a verb, an adjective, another adverb, a phrase, or a clause. An adverb indicates manner, time, place, cause, or degree and answers questions such as "how," "when," "where," "how much".');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-21', 2, '2.5: Subject-Verb Agreement', 'Subject-verb agreement, also called “subject-verb concord,” refers to matching the subject and verb of a sentence in tense, aspect, and mood (abbreviated as TAM), which translates to number, person, and gender. English doesn’t use grammatical gender (except for pronouns), and only the verb be changes based on whether it’s first, second, or third person. That means most English subject-verb agreement is about quantity: if the subject is singular, the verb must be singular; if the subject is plural, the verb must be plural. Even this can get confusing, though, because talking in the first-person singular (“I climb the fence”) uses the same verb format as talking in the first-person plural (“We climb the fence”). Aside from the verb be, subject-verb agreement in English adapts verbs to the third-person singular (“It climbs the fence”). ');
INSERT INTO daily_instructions (current_day, curriculum_id, instructions, content)
    VALUES ('2022-10-24', 2, '2.6: Punctuation', 'Punctuation is the tool that allows us to organize our thoughts and make it easier to review and share our ideas. The standard English punctuation is as follows: period, comma, apostrophe, quotation, question, exclamation, brackets, braces, parenthesis, dash, hyphen, ellipsis, colon, semicolon. In speaking, we use pauses and the pitch of the voice to make what we say clear. Punctuation plays a similar role in writing, making it easier to read. Punctuation consists of both rules and conventions. There are rules of punctuation that have to be followed; but there are also punctuation conventions that give writers greater choice.');

INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (11, '2022-10-10', '2022-10-11', '1.1 Your Writing Process!', 'Create a step-by-step plan that follows the writing process discussed in class. Make it personal! You will be following your own writing process guide on future assignments in this course.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (12, '2022-10-11', '2022-10-12', '1.2 Assigned Reading #1', 'Read chapters 1-2 of the Intro to English textbook. Answer the Critical Questions at the end of each chapter summary.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (13, '2022-10-12', '2022-10-14', '1.3 Sentence CHALLENGE!', 'Find an example of each four types of sentence structures from your favorite book. Be prepared to present your selected sentences in class.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (14, '2022-10-13', '2022-10-11', '1.4 Assigned Reading #2', 'Read chapters 3-4 of the Intro to English textbook. Answer the Critical Questions at the end of each chapter summary.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (15, '2022-10-14', '2022-10-17', '1.5 Assigned Reading #3', 'Read chapter 5 of the Intro to English textbook. Answer the Critical Questions at the end of the chapter summary.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (16, '2022-10-14', '2022-10-17', 'Persuasive Essay Outline', 'For this assignment you are not required to write a complete draft of your Argument Essay. Instead, you are to select a topic for your Argument Essay and write a detailed outline of your essay based on the model discussed in class.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (17, '2022-10-17', '2022-10-18', '2.1 Sentence Diagramming Exercise', 'Complete the sentence diagramming exercise started during today''s lesson. Please be prepared to share your answers, we will review these sentences in our next lesson.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (18, '2022-10-18', '2022-10-21', 'Persuasive Essay Rough Draft', 'In this assignment, you will create a minimum 525-word rough draft of your persuasive essay. Review your thesis statement and research you gathered in Weeks 1 and 2 before beginning. Be sure to note any feedback on your outline.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (19, '2022-10-19', '2022-10-20', '2.3 Assigned Reading #4', 'Read chapters 6-7 of the Intro to English textbook. Answer the Critical Questions at the end of each chapter summary.', 'homework');
INSERT INTO assignment (daily_instructions_id, assigned_date, due_date, assignment_title, assignment_description, assignment_type)
    VALUES (21, '2022-10-24', '2022-10-28', 'Persuasive Essay Final Draft', 'Submit the final draft of your Persuasive Essay. Please include a copy of your previous rough draft and your outline with your final essay submission.', 'homework');


INSERT INTO grades (student_id, assignment_id, course_id, total_points, earned_points, status, submission_content, feedback)
	VALUES (4, 1, 4, 100, 95, 'Graded', 'This is Jackie''s submission for US History assignment 1.', 'Jackie did an awesome job on US History assignment 1!'),
		    (4, 2, 4, 100, 0, 'Submitted', 'This is Jackie''s submission for US History assignment 2.', ''),
			(4, 3, 4, 100, 0, 'Incomplete', '', ''),
			(8, 1, 4, 100, 91, 'Graded', 'This is Cameron''s submission for US History assignment 1.', 'Cameron did an awesome job on US History assignment 1!'),
            (8, 2, 4, 100, 0, 'Submitted', 'This is Cameron''s submission for US History assignment 2.', ''),
            (8, 3, 4, 100, 0, 'Incomplete', '', ''),
            (9, 1, 4, 100, 95, 'Graded', 'This is Connor''s submission for US History assignment 1.', 'Connor did an awesome job on US History assignment 1!'),
            (9, 2, 4, 100, 0, 'Submitted', 'This is Connor''s submission for US History assignment 2.', ''),
            (9, 3, 4, 100, 0, 'Incomplete', '', ''),
            (10, 1, 4, 100, 95, 'Graded', 'This is Kyle''s submission for US History assignment 1.', 'Kyle did an awesome job on US History assignment 1!'),
            (10, 2, 4, 100, 0, 'Submitted', 'This is Kyle''s submission for US History assignment 2.', ''),
            (10, 3, 4, 100, 0, 'Incomplete', '', ''),
			(7, 1, 4, 100, 96, 'Graded', 'This is Jason''s submission for US History assignment 1.', 'Jason did an awesome job on US History assignment 1!'),
            (7, 2, 4, 100, 0, 'Submitted', 'This is Jason''s submission for US History assignment 2.', ''),
            (7, 3, 4, 100, 0, 'Incomplete', '', ''),
			(6, 1, 4, 100, 0, 'Submitted', 'This is William''s submission for US History assignment 1.', ''),
		    (6, 2, 4, 100, 100, 'Graded', 'This is William''s submission for US History assignment 2.', 'William did an outstanding job on US History assignment 2!'),
			(6, 3, 4, 100, 0, 'Incomplete', '', ''),
			(5, 9, 3, 100, 99, 'Graded', 'This is Preston''s submission for English assignment 1.', 'Preston did an excellent job on English assignment 1!'),
		    (5, 10, 3, 100, 0, 'Submitted', 'This is Preston''s submission for English assignment 2.', ''),
			(5, 11, 3, 100, 0, 'Incomplete', '', ''),
			(6, 9, 3, 100, 0, 'Incomplete', '', ''),
		    (6, 10, 3, 100, 91, 'Graded', 'This is William''s submission for English assignment 2.', 'William did a great job on English assignment 2!'),
			(6, 11, 3, 100, 0, 'Submitted', 'This is William''s submission for English assignment 3.', ''),
			(8, 9, 3, 100, 0, 'Incomplete', '', ''),
            (8, 10, 3, 100, 97, 'Graded', 'This is Cameron''s submission for English assignment 2.', 'Cameron did a great job on English assignment 2!'),
            (8, 11, 3, 100, 0, 'Submitted', 'This is Cameron''s submission for English assignment 3.', ''),
            (9, 9, 3, 100, 0, 'Incomplete', '', ''),
            (9, 10, 3, 100, 98, 'Graded', 'This is Connor''s submission for English assignment 2.', 'Connor did a great job on English assignment 2!'),
            (9, 11, 3, 100, 0, 'Submitted', 'This is Connor''s submission for English assignment 3.', ''),
            (10, 9, 3, 100, 0, 'Incomplete', '', ''),
            (10, 10, 3, 100, 92, 'Graded', 'This is Kyle''s submission for English assignment 2.', 'Kyle did a great job on English assignment 2!'),
            (10, 11, 3, 100, 0, 'Submitted', 'This is Kyle''s submission for English assignment 3.', ''),
            (11, 1, 4, 100, 90, 'Graded', 'This is Sally Demo''s submission for US History assignment 1.', 'Nice job on this assignment!'),
            (11, 2, 4, 100, 0, 'Submitted', 'This is Sally Demo''s submission for US History assignment 2.', ''),
            (11, 3, 4, 100, 0, 'Incomplete', '', ''),
            (11, 5, 4, 100, 0, 'Incomplete', '', ''),
            (11, 6, 4, 100, 0, 'Incomplete', '', ''),
            (11, 7, 4, 100, 0, 'Incomplete', '', ''),
            (11, 8, 4, 100, 0, 'Incomplete', '', ''),
            (11, 9, 3, 100, 70, 'Graded', 'This is Sally Demo''s submission for English assignment 1.', 'Not your best work here, Sally!'),
            (11, 10, 3, 100, 82, 'Graded', 'This is Sally Demo''s submisoin for English assignment 2.', 'Good job on this one, just watch out for those typos!'),
            (11, 11, 3, 100, 0, 'Submitted', 'This is Sally Demo''s submission for English assignment 3.', ''),
            (11, 12, 3, 100, 0, 'Submitted', 'This is Sally Demo''s submission for English assignment 4.', ''),
            (11, 13, 3, 100, 0, 'Incomplete', '', ''),
            (11, 14, 3, 100, 0, 'Incomplete', '', ''),
            (11, 15, 3, 100, 0, 'Incomplete', '', '');

COMMIT TRANSACTION;


