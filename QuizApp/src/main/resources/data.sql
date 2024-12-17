INSERT INTO QUESTION (question_text, option_a, option_b, option_c, option_d, correct_answer)
VALUES ('What is the capital of France?', 'Berlin', 'Madrid', 'Paris', 'Rome', 'C'),
       ('What is 2 + 2?', '3', '4', '5', '6', 'B'),
       ('Which language runs on JVM?', 'C++', 'Python', 'Java', 'JavaScript', 'C');

INSERT INTO USER_SESSION (user_id, total_questions_answered, correct_answers, incorrect_answers)
VALUES (1, 0, 0, 0);