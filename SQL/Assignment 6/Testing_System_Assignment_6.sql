USE Testing_System_1;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE get_list_accounts_by_department_name;
DELIMITER $$
	CREATE PROCEDURE get_list_accounts_by_department_name(in_DepartmentName VARCHAR(50))
    BEGIN
		SELECT a.AccountID, a.Username, a.Email, a.Fullname, d.DepartmentName
        FROM `account` a
        RIGHT JOIN department d ON a.DepartmentID = d.DepartmentID
        WHERE d.DepartmentName LIKE in_DepartmentName;
    END$$
DELIMITER ;
CALL get_list_accounts_by_department_name('%sale%');
--------------------------------------------------------------------------------------------------------------------------------------------
-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE sp_count_account_in_group;
DELIMITER $$
	CREATE PROCEDURE sp_count_account_in_group()
    BEGIN
		SELECT ga.GroupID, count(ga.AccountID)AS TotalAccount
        FROM groupaccount ga
        LEFT JOIN `account` a ON ga.AccountID = a.AccountID
        GROUP BY ga.GroupID;
    END$$
DELIMITER ;
CALL sp_count_account_in_group();
--------------------------------------------------------------------------------------------------------------------------------------------
-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS get_number_of_questions_in_this_month;
DELIMITER $$
	CREATE PROCEDURE get_number_of_questions_in_this_month()
		BEGIN
            SELECT tq.TypeName, count(q.questionID) AS number_of_questions
            FROM typequestion tq
            LEFT JOIN question q ON tq.TypeID = q.TypeID
            WHERE MONTH(q.CreateDate) = MONTH(NOW())
            GROUP BY q.TypeID;
		END$$
DELIMITER ;
CALL get_number_of_questions_in_this_month();
--------------------------------------------------------------------------------------------------------------------------------------------
-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất

DROP PROCEDURE IF EXISTS spTypeIdHasMaxQuestion;
DELIMITER $$
	CREATE PROCEDURE spTypeIdHasMaxQuestion(OUT type_question TINYINT)
		BEGIN
			DECLARE countQ INT;
			SELECT TypeID, count(TypeID) AS number_of_questions INTO type_question, countQ
            FROM question 
			GROUP BY TypeID 
            ORDER BY number_of_questions DESC LIMIT 1;
        END$$
DELIMITER ;
CALL spTypeIdHasMaxQuestion(@typeIdOut);
SELECT @typeIdOut;
--------------------------------------------------------------------------------------------------------------------------------------------
-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
CALL spTypeIdHasMaxQuestion(@typeIdOut);
SELECT typeName FROM typequestion
WHERE TypeID = @typeIdOut;
--------------------------------------------------------------------------------------------------------------------------------------------
/* Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên 
chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào*/
DROP PROCEDURE IF EXISTS sp_getNameOfGroupOrAccount;
DELIMITER $$
	CREATE PROCEDURE sp_getNameOfGroupOrAccount(IN in_input_string VARCHAR(50), IN in_select TINYINT UNSIGNED)
		BEGIN 
			IF in_select = 1 THEN
				SELECT 'Ban dang su dung chuc nang tim kiem group';
				SELECT GroupName
                FROM `group`
                WHERE GroupName LIKE CONCAT('%',in_input_string, '%');
			ELSEIF in_select = 2 THEN
				SELECT 'Ban dang su dung chuc nang tim kiem username';
				SELECT Username
				FROM `account`
				WHERE Username LIKE CONCAT('%',in_input_string, '%');
             ELSE 
				SELECT 'Lua chon la 1 hoac 2 (1: Tim kiem ten group, 2: Tim kiem username)';
			END IF;
        END$$
DELIMITER ; 
CALL sp_getNameOfGroupOrAccount('o', 1);

--------------------------------------------------------------------------------------------------------------------------------------------
/* Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
username sẽ giống email nhưng bỏ phần @..mail đi
positionID: sẽ có default là developer
departmentID: sẽ được cho vào 1 phòng chờ
sau do in ra ket qua tao thanh cong*/
DROP PROCEDURE IF EXISTS insert_into_account;
DELIMITER $$
CREATE PROCEDURE insert_into_account (IN in_FullName VARCHAR(50), IN in_Email VARCHAR(50))
BEGIN 
	DECLARE v_Username VARCHAR(50);
	DECLARE v_DepartmentID TINYINT UNSIGNED;
	DECLARE v_PositionID TINYINT UNSIGNED;
	
	SELECT SUBSTRING_INDEX(in_Email, '@', 1) INTO v_Username;
	
	SELECT DepartmentID INTO v_DepartmentID
	FROM department
	WHERE DepartmentName = 'Phong Cho';
	
	SELECT PositionID INTO v_PositionID
	FROM `position`
	WHERE PositionName = 'Dev1';
	
	INSERT INTO `account`	(Email, 	Username, 	Fullname,		 DepartmentID, PositionID, CreateDate)
	VALUES					(in_Email,	v_Username, in_FullName, 	v_DepartmentID,v_PositionID, now());
	SELECT N'Tạo thành công';
END$$
DELIMITER ;
CALL insert_into_account('Nguyen Thi Nga', 'nguyennga0302@gmail.com');

 --------------------------------------------------------------------------------------------------------------------------------------------
/* Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất*/
DROP PROCEDURE IF EXISTS sp_get_question_longest_content;
DELIMITER $$
	CREATE PROCEDURE sp_get_question_longest_content(IN in_typeName ENUM('Essay', 'Multiple-Choice'))
		BEGIN
			SELECT q.Content, LENGTH(q.Content) AS length_of_content
            FROM question q
            WHERE LENGTH(q.Content) = (SELECT MAX(LENGTH(q.Content))
										FROM question q
                                        INNER JOIN typequestion tq ON q.TypeID = tq.TypeID
                                        WHERE tq.TypeName = in_typeName);
        END$$
DELIMITER ;
CALL sp_get_question_longest_content('Essay');
CALL sp_get_question_longest_content('Multiple-Choice');
--------------------------------------------------------------------------------------------------------------------------------------------
-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_delete_exam_from_id;
DELIMITER $$
	CREATE PROCEDURE sp_delete_exam_from_id(in_exam_id TINYINT UNSIGNED)
		BEGIN
			DELETE
            FROM examquestion
            WHERE ExamID = in_exam_id;
        END$$
DELIMITER ;
CALL sp_delete_exam_from_id(1);
SELECT * FROM examquestion;
--------------------------------------------------------------------------------------------------------------------------------------------
/*Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử 
 dụng store ở câu 9 để xóa)
 Sau đó in số lượng record đã remove từ các table liên quan trong khi 
 removing*/
 DROP PROCEDURE IF EXISTS insert_into_account;
DELIMITER $$
CREATE PROCEDURE insert_into_account (IN in_FullName VARCHAR(50), IN in_Email VARCHAR(50))
BEGIN 
	DECLARE v_Username VARCHAR(50);
	DECLARE v_DepartmentID TINYINT UNSIGNED;
	DECLARE v_PositionID TINYINT UNSIGNED;
	
	SELECT SUBSTRING_INDEX(in_Email, '@', 1) INTO v_Username;
	
	SELECT DepartmentID INTO v_DepartmentID
	FROM department
	WHERE DepartmentName = 'Phong Cho';
	
	SELECT PositionID INTO v_PositionID
	FROM `position`
	WHERE PositionName = 'Dev1';
	
	INSERT INTO `account`	(Email, 	Username, 	Fullname,		 DepartmentID, PositionID, CreateDate)
	VALUES					(in_Email,	v_Username, in_FullName, 	v_DepartmentID,v_PositionID, now());
	SELECT N'Tạo thành công';
END$$
DELIMITER ;
CALL insert_into_account('Nguyen Thi Nga', 'nguyennga0302@gmail.com');

 --------------------------------------------------------------------------------------------------------------------------------------------
/*Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng 
 nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được 
 chuyển về phòng ban default là phòng ban chờ việc*/
DROP PROCEDURE IF EXISTS get_deleted_department;
DELIMITER $$
	CREATE PROCEDURE get_deleted_department(IN in_DepartmentName VARCHAR(50))
		BEGIN
			DECLARE v_Department_ID TINYINT UNSIGNED;
            DECLARE v_Department_ID_cua_phong_cho TINYINT UNSIGNED;
            
            SELECT departmentID INTO v_Department_ID
            FROM department 
            WHERE departmentName = in_DepartmentName;
            
            SELECT departmentID INTO v_Department_ID_cua_phong_cho
            FROM department 
            WHERE departmentName = 'Phong Cho';
            
            UPDATE `account` 
            SET departmentID = v_Department_ID_cua_phong_cho
            WHERE departmentID = v_Department_ID;
            
            DELETE FROM department
            WHERE departmentName = in_DepartmentName;
		
        END$$
DELIMITER ;
BEGIN WORK;
CALL get_deleted_department('Phong Sale');
ROLLBACK;

 --------------------------------------------------------------------------------------------------------------------------------------------
-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS get_number_question_in_this_year;
DELIMITER $$
	CREATE PROCEDURE get_number_question_in_this_year()
		BEGIN
			SELECT MONTH(CreateDate), count(QuestionID) AS number_of_questions
            FROM question 
            WHERE YEAR(CreateDate) = YEAR(NOW())
            GROUP BY MONTH(CreateDate);
        END$$
DELIMITER ;
CALL get_number_question_in_this_year();
--------------------------------------------------------------------------------------------------------------------------------------------
/*Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 
 tháng gần đây nhất
 (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong 
tháng")*/
DROP PROCEDURE IF EXISTS sp_list_question_create_6_month;
DELIMITER $$
	CREATE PROCEDURE sp_list_question_create_6_month()
		BEGIN
			SELECT month(CreateDate), count(QuestionID)
            FROM question 
            WHERE month(CreateDate > '2021-02-14')
            GROUP BY month(CreateDate);
        END$$
DELIMITER ;
