USE Testing_System_1;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
DROP VIEW IF EXISTS v_staffs_sale;
CREATE VIEW v_staffs_sale AS
		SELECT a.AccountID, a.Username, a.FullName
        FROM `account` a
        INNER JOIN department d ON a.DepartmentID = d.DepartmentID
        WHERE d.DepartmentName = 'phong sale';
SELECT * FROM v_staffs_sale;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
DROP VIEW IF EXISTS v_infor_accounts;
CREATE VIEW v_infor_accounts AS
		SELECT a.Username, a.FullName, count(g.GroupID) number_of_groups
        FROM `account` a
        INNER JOIN groupaccount g ON a.AccountID = g.AccountID
        GROUP BY g.AccountID
        HAVING count(g.GroupID) =	(SELECT max(number_of_groups)
									FROM (SELECT count(GroupID) AS number_of_groups
											FROM groupaccount
											GROUP BY AccountID) AS temp);
SELECT * FROM v_infor_accounts;
			
-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 16 từ  được coi là quá dài) và xóa nó đi
DROP VIEW IF EXISTS v_list_question_have_long_content;
CREATE VIEW v_list_question_have_long_content AS
			SELECT QuestionID, Content, length(Content)
            FROM question
            WHERE length(Content) > 16;
SELECT * FROM v_list_question_have_long_content;
DELETE FROM question
WHERE QuestionID IN (SELECT QuestionID FROM v_list_question_have_long_content);
        
DELETE FROM answer
WHERE QuestionID IN (SELECT QuestionID FROM v_list_question_have_long_content);
        
DELETE FROM examquestion
WHERE QuestionID IN (SELECT QuestionID FROM v_list_question_have_long_content);

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS v_list_department_have_the_most_accounts;
CREATE VIEW v_list_department_have_the_most_accounts AS
SELECT d.DepartmentID, d.DepartmentName
FROM department d
		INNER JOIN `account` a ON d.DepartmentID = a.DepartmentID
		GROUP BY a.DepartmentID
		HAVING count(AccountID) = (SELECT max(number_of_accounts) FROM (SELECT count(AccountID) AS number_of_accounts
																		FROM `account` 
																		GROUP BY DepartmentID) AS temp);
SELECT * FROM v_list_department_have_the_most_accounts;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
DROP VIEW IF EXISTS v_questions_content;
CREATE VIEW v_questions_content AS
		SELECT q.Content, a.Fullname 
		FROM question q
		INNER JOIN `account` a ON q.CreatorID = a.AccountID
		WHERE  a.Fullname LIKE 'Nguyen%';
SELECT * FROM v_questions_content;

