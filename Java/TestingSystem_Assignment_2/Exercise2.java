import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import constant.PositionName;
import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;

public class Exercise2 {
	public static void main(String[] args) {
	
		Department phongDev = new Department();
		phongDev.id = 1;
		phongDev.name = "phong DEV";
		Department phongTest = new Department(3, "phong TEST");
		Department phongHanhChinh = new Department(4, "phong Hanh Chinh");
		Department phongGiamDoc = new Department(2, "phong Giam Doc");

		Position dev = new Position(); // Instance
		dev.setId(1);
		dev.setName(PositionName.DEV);
		Position pm = new Position(2, PositionName.PM);
		Position test = new Position(3, PositionName.TEST);
		Position scrumMaster = new Position(4, PositionName.SCRUMMASTER);

		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Development";
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Test";
		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Sale";

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
		
		question1();
	}
// QUestion 1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
	
		private static void question1() {
			int i = 5;
			System.out.printf("%d\n", i);
		}
		

//question 2: Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in 
//ra số nguyên đó thành định dạng như sau: 100,000,000
		private static void question2() {
			int i1 = 100000000;
			System.out.printf(Locale.US, "%,d %n", i1);
		}
		

//Question 3: Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số 
//thực đó chỉ bao gồm 4 số đằng sau
		private static void question3() {
			float x = 5.567098f;
			System.out.printf("%.4f%n", x);

		}
		
//Question 4: 
//Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định 
//dạng như sau:
//Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau: 
//Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		private static void question4() {
			String s = "Nguyễn Văn A";
			System.out.printf("%s", s + " và tôi đang độc thân.\n");

		}
		
//Question 5:
//Lấy thời gian bây giờ và in ra theo định dạng sau: 24/04/2020 11h:16p:20s 
		private static void question5() {
			String parten = "dd/MM/yyyy HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(parten);
			String date = simpleDateFormat.format(new Date());
			System.out.println(date);

		}
		
//Question 6:In ra thông tin account (như Question 8 phần FOREACH)
//theo định dạng table (giống trong Database)
		private static void question6() {
			
		System.out.println("Bang Account");
		System.out.printf("%5s  |%15s  |%15s |%20s  |\n", "ID", "UserName", "Email", "FullName");
		System.out.println("-------------------------------------------------------------------");

//		for (int j = 0; j < groupAccount1.length; j++) {
//			Group a = groupAccount1[j];
//			System.out.printf("%5s  |%15s  |%15s |%20s  |\n", "" + a.id, a.userName, a.email, a.fullName);
//			System.out.println("-------------------------------------------------------------------");
//		}
		}
	}

