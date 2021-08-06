USE testingmanagement;

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
-- output: AccountID   Username    FullName     DepartmentName
SELECT a.AccountID, a.Username, a.FullName, d.DepartmentName
FROM `account` a
LEFT JOIN department d ON  a.departmentID = d.DepartmentID;

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT * FROM `account`
WHERE Createdate > '2010-12-20';

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 3: Viết lệnh để lấy ra tất cả các developer 
-- output: AccountID  Username   FullName     PositionName
SELECT a.AccountID, a.Username, a.FullName, p.PositionName
FROM `account` a
INNER JOIN position p ON a.PositionID = p.PositionID
WHERE PositionName = 'dev';

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
-- output: DepartmentID    DepartmentName    count(AccountID)
SELECT d.DepartmentID, d.DepartmentName, count(a.AccountID) AS number_of_accounts
FROM department d
INNER JOIN `account` a ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID
HAVING count(a.AccountID) > 3;

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
-- output: QuestionID   Content    count(ExamID)  
SELECT q.QuestionID, q.Content, count(e.ExamID) AS number_of_exams
FROM question q
LEFT JOIN examquestion e ON q.QuestionID = e.QuestionID
GROUP BY e.QuestionID
ORDER BY count(e.ExamID) DESC
LIMIT 1;

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
-- output: CategoryID   CategoryName   QuestionID
SELECT c.CategoryID, c.CategoryName, count(q.QuestionID) AS number_of_questions
FROM categoryquestion c
LEFT JOIN question q ON c.CategoryID = q.CategoryID
GROUP BY q.CategoryID;

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
-- output: QuestionID   Content   ExamID
SELECT q.QuestionID, q.Content, count(e.ExamID) AS number_of_exams
FROM question q
LEFT JOIN examquestion e ON q.QuestionID = e.QuestionID
GROUP BY q.QuestionID
HAVING count(e.ExamID);

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
-- output: QuestionID  Content    AnswerID
SELECT q.QuestionID, q.Content, count(an.AnswerID) AS number_of_answers
FROM question q
LEFT JOIN answer an ON q.QuestionID = an.QuestionID
GROUP BY q.QuestionID
ORDER BY count(an.AnswerID) DESC
LIMIT 1;

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 9: Thống kê số lượng account trong mỗi group 
-- output:  GroupID  AccountID
SELECT g.GroupID, count(a.AccountID) AS number_of_accounts
FROM `account` a
LEFT JOIN groupaccount g ON a.AccountID = g.AccountID
GROUP BY g.GroupID
HAVING count(g.AccountID);

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 10: Tìm chức vụ có ít người nhất
SELECT p.PositionID, count(a.AccountID) AS number_of_accounts
FROM position p
LEFT JOIN `account` a ON p.PositionID = a.PositionID
GROUP BY a.PositionID
ORDER BY count(a.AccountID) ASC
LIMIT 1;

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, 
-- ai là người tạo ra câu hỏi, câu trả lời là gì, …
-- output: QuestionID  Content   TypeName   AccountID   Username   FullName   AnswerID  Content
SELECT q.QuestionID, q.Content, t.TypeName, a.AccountID, a.Username, a.FullName, an.AnswerID, an.Content
FROM question q
LEFT JOIN typequestion t ON q.TypeID = t.TypeID
LEFT JOIN `account` a ON q.CreatorID = a.AccountID
LEFT JOIN answer an ON q.QuestionID = an.QuestionID;


 
--------------------------------------------------------------------------------------------------------------------------------------------------
--  Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT q.QuestionID, t.TypeName, count(q.QuestionID) AS number_of_questions
FROM question q
INNER JOIN typequestion t ON q.TypeID = t.TypeID
GROUP BY q.TypeID
HAVING count(q.QuestionID);

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 14:Lấy ra group không có account nào
SELECT g.GroupName, count(ga.AccountID) AS number_of_account
FROM `group` g
LEFT JOIN groupaccount ga ON g.GroupID = ga.GroupID
GROUP BY ga.GroupID 
HAVING count(ga.AccountID) = 0;

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 15: Lấy ra group không có account nào
--------------------------------------------------------------------------------------------------------------------------------------------------
-- Question 16: Lấy ra question không có answer nào
SELECT q.QuestionID, q.Content, count(an.AnswerID) AS number_of_answer
FROM `question` q
LEFT JOIN `answer` an ON q.QuestionID = an.QuestionID
GROUP BY an.QuestionID
HAVING count(an.AnswerID) = 0;

------------------------ Exercise 2: Union ------------------

-- Question 17: 
-- a) Lấy các account thuộc nhóm thứ 1
SELECT AccountID FROM groupaccount
WHERE GroupID = 1;
-- b) Lấy các account thuộc nhóm thứ 2
SELECT AccountID FROM groupaccount
WHERE GroupID = 2;
-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT AccountID FROM groupaccount
WHERE GroupID = 1
UNION
SELECT AccountID FROM groupaccount
WHERE GroupID = 2;

-- Question 18: 
-- a) Lấy các group có lớn hơn 5 thành viên
SELECT groupID, count(AccountID) AS number_of_accounts
FROM groupaccount
GROUP BY GroupID
HAVING count(AccountID) > 5;
-- b) Lấy các group có nhỏ hơn 7 thành viên 
SELECT groupID, count(AccountID) AS number_of_accounts
FROM groupaccount
GROUP BY groupID
HAVING count(AccountID) < 7;
-- c) Ghép 2 kết quả từ câu a) và câu b)
SELECT groupID, count(AccountID) AS number_of_accounts
FROM groupaccount
GROUP BY GroupID
HAVING count(AccountID) > 5
UNION
SELECT groupID, count(AccountID) AS number_of_accounts
FROM groupaccount
GROUP BY groupID
HAVING count(AccountID) < 7;