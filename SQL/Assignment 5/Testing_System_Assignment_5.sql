USE Testing_System_1;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
DROP VIEW IF EXISTS v_staffs_sale;
CREATE VIEW v_accounts_sale AS
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
			
-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ  được coi là quá dài) và xóa nó đi
-- P VIEW IF EXISTS delete_longcontent_question;
	
        
        
		
-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
a
-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
