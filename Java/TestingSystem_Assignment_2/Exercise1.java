import com.sun.source.tree.WhileLoopTree;

import constant.PositionName;
import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;

public class Exercise1 {
	public static void main(String[] args) {
		// tao 4 doi tuong Department
		Department phongDev = new Department();
		phongDev.id = 1;
		phongDev.name = "phong DEV";
		Department phongTest = new Department(3, "phong TEST");
		Department phongHanhChinh = new Department(4, "phong Hanh Chinh");
		Department phongGiamDoc = new Department(2, "phong Giam Doc");

		// tao 4 doi tuong Position
		Position dev = new Position(); // Instance
		dev.setId(1);
		dev.setName(PositionName.DEV);
		Position pm = new Position(2, PositionName.PM);
		Position test = new Position(3, PositionName.TEST);
		Position scrumMaster = new Position(4, PositionName.SCRUMMASTER);

		// tao group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Development";
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Test";
		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Sale";

		// tao 3 doi tuong Account
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "nga123@gmail.com";
		account1.userName = "nguyennga";
		account1.fullName = "Nguyen Thi Nga";
		account1.department = phongDev;
		account1.position = dev;
		Group[] groupAccount1 = { group1, group2 };
		account1.groups = groupAccount1;

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "thule@gmail.com";
		account2.userName = "thule";
		account2.fullName = "Le Minh Thu";
		account2.department = phongTest;
		account2.position = test;
		account2.groups = new Group[] { group3, group2 };

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "thanh22@gmail.com";
		account3.userName = "phamthanh";
		account3.fullName = "Pham Tien Thanh";
		account3.department = phongDev;
		account3.position = pm;
// Question 1:
		System.out.println("------Question 1: Kiem tra account2------");
		if (account2.department == null) {
			System.out.println("Nhan vien nay chua co phong ban");
		} else {
			System.out.println("Phong ban cua nhan vien nay la: " + account2.department.name);
		}

//Question2:
		System.out.println("-----Question 2: kiem tra account 2-----");
		if (account2.groups == null) {
			System.out.println("Nhan vien nay chua co group");
		} else {
			int countGroup = account2.groups.length;
			if (countGroup == 1 || countGroup == 2) {
				System.out.println("Group cua nhan vien nay la Java Fresher, C# Fresher");
			}
			if (countGroup == 3) {
				System.out.println("Nhan vien nay la nguoi quan trong, tham gia nhieu group");
			}
			if (countGroup >= 4) {
				System.out.println("Nhan vien nay la nguoi hong chuyen, tham gia tat ca cac group");
			}
		}
//Question 3:
		System.out.println("-----Question 3: Su dung toan tu ternary-----");
		System.out.println(account2.department == null ? "Nhan vien nay chua co phong ban"
				: "Phong ban cua nhan vien nay la: " + account2.department.name);

//Question 4: Su dung toan tu ternary
		System.out.println("-----Question 4:-----");
		System.out.println(
				account1.position.name.toString() == "Dev" ? "Day la Developer" : "Nguoi nay khong phai Developer");
//SWITCH CASE
//Question 5:
		System.out.println("-----Question 5: So luong Account trong nhom 1-----");
		if (group1.accounts == null) {
			System.out.println("Group nay chua co thanh vien nao tham gia");
		} else {
			int countAccInGroup = group1.accounts.length;
			switch (countAccInGroup) {
			case 1: {
				System.out.println("Nhom co 1 thanh vien");
				break;
			}
			case 2: {
				System.out.println("Nhom co 2 thanh vien");
				break;
			}
			case 3: {
				System.out.println("Nhom co 3 thanh vien");
				break;
			}

			default:
				System.out.println("Nhom co nhieu thanh vien");
				break;
			}
		}
//Question 6:
		System.out.println("-----Question 6:-----");
		if (account2.groups == null) {
			System.out.println("Nhan vien nay chua co group");
		} else {
			switch (account2.groups.length) {
			case 1: {
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
				break;
			}
			case 2: {
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
				break;
			}
			case 3: {
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
				break;
			}

			default:
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
				break;
			}
		}
//Question 7: su dung switch case lam lai question 4
		System.out.println("-----Question 7:-----");
		String positionName = account1.position.name.toString();
		switch (positionName) {
		case "Dev": {
			System.out.println("day la developer");
			break;
		}
		default:
			System.out.println("Nguoi nay khong phai la Developer");
			break;
		}
//FOR EACH
//question 8
		System.out.println("-----Question 8: in ra thong tin account -----");
		Account[] accArray = { account1, account2, account3 };
		for (Account account : accArray) {
			System.out.println(
					"AccountID: " + account.id + ", Email: " + account.email + ", FullName: " + account.fullName);
		}
//question 9:
		System.out.println("-----Question 9: in ra thong tin ten pb-----");
		Department[] dpArray = { phongGiamDoc, phongTest, phongDev };
		for (Department department : dpArray) {
			System.out.println("DepartmentID: " + department.id + ", Name: " + department.name);
		}
//question 10:
		System.out.println("-----Question 10: in ra thong tin ten account: Email, FullName, Ten pb-----");
		Account[] accountArray1 = { account1, account2 };
		for (int i = 0; i < accountArray1.length; i++) {
			System.out.println("Thong tin account thu " + (i + 1) + " la:");
			System.out.println("Email: " + accountArray1[i].email);
			System.out.println("Full name: " + accountArray1[i].fullName);
			System.out.println("Phong ban: " + accountArray1[i].department.name);
		}
//question 11:
		System.out.println("-----Question 11: in ra thong tin cac phong ban-------");
		Department[] depArray1 = { phongDev, phongTest, phongGiamDoc, phongHanhChinh };
		for (int i = 0; i < depArray1.length; i++) {
			System.out.println("Thong tin department thu " + (i + 1) + " la:");
			System.out.println("id: " + depArray1[i].id);
			System.out.println("Name: " + depArray1[i].name);

		}
//question 12: chi in thong tin 2 dep dau tien theo dinh dang question 10
		System.out.println("------Question 12:--------");
		Department[] depArray2 = { phongDev, phongGiamDoc, phongHanhChinh, phongTest };
		for (int i = 0; i < 2; i++) {
			System.out.println("Thong tin department thu " + (i + 1) + " la:");
			System.out.println("id: " + depArray2[i].id);
			System.out.println("Name: " + depArray2[i].name);
		}
//question 13: In ra tat ca cac account ngoai tru account thu 2
		System.out.println("-----QUESTION 13:------");
		Account[] accountArray2 = { account1, account2, account3 };
		for (int i = 0; i < accountArray2.length; i++) {
			if (i != 1) {
				System.out.println("Thong tin account thu " + (i + 1) + " la:");
				System.out.println("id: " + accountArray2[i].id);
				System.out.println("UserName: " + accountArray2[i].userName);
				System.out.println("Full Name: " + accountArray2[i].fullName);
				System.out.println("Email: " + accountArray2[i].email);
				System.out.println("Department: " + accountArray2[i].department.name);
				System.out.println("Position: " + accountArray2[i].position.name);
			}
		}
//	question 14: In ra tat ca cac account co id<4
		System.out.println("-----QUESTION 14:------");
		Account[] accountArray3 = { account1, account2, account3 };
		for (int j = 0; j < accountArray3.length; j++) {
			if (accountArray3[j].id < 4) {
				System.out.println("Thong tin account thu " + (j + 1) + " la:");
				System.out.println("id: " + accountArray3[j].id);
				System.out.println("UserName: " + accountArray3[j].userName);
				System.out.println("Full Name: " + accountArray3[j].fullName);
				System.out.println("Email: " + accountArray3[j].email);
				System.out.println("Department: " + accountArray3[j].department.name);
				System.out.println("Position: " + accountArray3[j].position.name);
			}
		}

//question 15: In ra so chan nho hon hoac bang 20
		System.out.println("-----question 15: -----");
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
//question 16: WHILE
		System.out.printf("\n");
		System.out.println("-----FOR question 16-10-----");
		Account[] accArray1 = { account1, account2, account3 };
		int i = 0;
		while (i < accArray1.length) {
			System.out.println("Thong tin account thu " + (i + 1) + " la:");
			System.out.println("Email: " + accArray1[i].email);
			System.out.println("Full Name: " + accArray1[i].fullName);
			System.out.println("Phong ban: " + accArray1[i].department.name);
			i++;
		}
//question 16: For 13: in ra thong tin account ngoai tru account thu 2
		System.out.println("-----FOR question 16-13-----");
		Account[] accArray2 = { account1, account2, account3 };
		int j = 0;
		while (j < accArray2.length) {
			if (j != 1) {
				System.out.println("Thông tin department thứ " + (j + 1) + " là:");
				System.out.println("id: " + accArray2[j].id);
				System.out.println("UserName: " + accArray2[j].userName);
				System.out.println("Email: " + accArray2[j].email);
				System.out.println("Department: " + accArray2[j].department.name);
				System.out.println("Position: " + accArray2[j].position.name);
			}
			j++;
		}
//question 16-14: In ra tat ca cac account co id<4
		System.out.println("-----QUESTION 16-14:------");
		Account[] accArray3 = { account1, account2, account3 };
		int i1 = 0;
		while (i1 < accArray3.length) {
			if (accArray3[i1].id < 4) {
				System.out.println("Thong tin account thu " + (i1 + 1) + " la:");
				System.out.println("id: " + accArray3[i1].id);
				System.out.println("UserName: " + accArray3[i1].userName);
				System.out.println("Full Name: " + accArray3[i1].fullName);
				System.out.println("Email: " + accArray3[i1].email);
				System.out.println("Department: " + accArray3[i1].department.name);
				System.out.println("Position: " + accArray3[i1].position.name);
			}
			i1++;
		}

//DO-WHILE: question 17
		System.out.println("-----QUESTION 17-14:------");
		Account[] accArray4 = { account1, account2, account3 };
		int i2 = 0;
		do {
			if (accArray4[i2].id < 4) {
				System.out.println("Thong tin account thu " + (i2 + 1) + " la:");
				System.out.println("id: " + accArray4[i2].id);
				System.out.println("UserName: " + accArray4[i2].userName);
				System.out.println("Full Name: " + accArray4[i2].fullName);
				System.out.println("Email: " + accArray4[i2].email);
				System.out.println("Department: " + accArray4[i2].department.name);
				System.out.println("Position: " + accArray4[i2].position.name);
			}
			i2++;
		} while (i2 < accArray4.length);

	}
}
