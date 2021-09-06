import java.time.LocalDate;
import java.util.Scanner;

import constant.PositionName;
import entity.Account;
import entity.Department;
import entity.Position;


public class Exercise5 {
	public static void main(String[] args) {
		question8();
	}
	
//question 1: viet lenh cho phep nguoi dung nhap 3 so nguyen vao chuong trinh
	private static void question1() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Moi ban nhap vao 3 so nguyen");
	System.out.println("nhap vao so 1: ");
	int a = scanner.nextInt();
	System.out.println("nhap vao so 2: ");
	int b = scanner.nextInt();
	System.out.println("nhap vao so 3: ");
	int c = scanner.nextInt();
	System.out.println("Ban vua nhap cac so: " + a +" "+ b +" "+c);
	}
//question 2: nhap 2 so thuc vao chuong trinh
	private static void question2(){
	Scanner scanner1 = new Scanner(System.in);
	System.out.println("Moi ban nhap vao 3 so nguyen");
	System.out.println("nhap vao so 1: ");
	float a1 = scanner1.nextFloat();
	System.out.println("nhap vao so 2: ");
	float b1 = scanner1.nextFloat();
	System.out.println("nhap vao so 3: ");
	float c1 = scanner1.nextFloat();
}
//	System.out.println("Ba so vua nhap la: " + a1 + " " + b1 +" " +c1);
//question 3: viet lenh cho phep nguoi dung nhap vao ho ten
	private static void question3(){
	Scanner scanner2 = new Scanner(System.in);
	System.out.println("Moi ban nhap vao ho: ");
	String s1 = scanner2.nextLine();
	System.out.println("Moi ban nhap vao ten: ");
	String s2 = scanner2.nextLine(); 
	System.out.println("Ho va ten cua ban la: " + s1 +" " + s2);
}
//question 4: nhap vao ngay sinh nhat cua ho
		private static void question4() {
		Scanner scanner3 = new Scanner(System.in);
		System.out.println("Moi ban nhap vao nam sinh: ");
		int s1 = scanner3.nextInt();
		System.out.println("Moi ban nhap vao thang sinh: ");
		int s2 = scanner3.nextInt();
		System.out.println("Moi ban nhap vao ngay sinh: ");
		int s3 = scanner3.nextInt();

		LocalDate dateBirth = LocalDate.of(s1, s2, s3);
		System.out.println("Ngay sinh nhat cua ban la: " + dateBirth);
		}
//question 5: Viết lệnh cho phép người dùng tạo account (viết thành method)
//Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào 
//chương trình sẽ chuyển thành Position.Dev, Position.Test, 
//Position.ScrumMaster, Position.PM
	private static void question5() {
		Scanner scanner4 = new Scanner(System.in);
		System.out.println("Moi ban nhap vao thong tin Account can tao: ");
		Account acc = new Account();
		System.out.println("Nhap ID: ");
		acc.id = scanner4.nextInt();
		
		System.out.println("Nhap email: ");
		acc.email = scanner4.next();
		
		System.out.println("Nhap Username: ");
		acc.userName = scanner4.next();
		
		System.out.println("Nhap Fullname: ");
		acc.fullName = scanner4.next();
		
		System.out.println("Nhap Position (Nhap ca so tu 1 den 5 tuong ung voi: 1.Dev, 2.Test, 3.Scrum_Master, 4.PM): ");
		int posNum = scanner4.nextInt();
		switch (posNum) {
		case 1:
			Position pos1 = new Position();
			pos1.name = PositionName.DEV;
			acc.position = pos1;
			break;
		case 2:
			Position pos2 = new Position();
			pos2.name = PositionName.TEST;
			acc.position = pos2;
			break;
		case 3:
			Position pos3 = new Position();
			pos3.name = PositionName.SCRUMMASTER;
			acc.position = pos3;
			break;
		case 4:
			Position pos4 = new Position();
			pos4.name = PositionName.PM;
			acc.position = pos4;
			break;
		}
		System.out.println("Thong tin Account vua nhap: ID: " + acc.id +", "+"Email: "+ acc.email
				+", " + "UserName: "+ acc.userName +", "+ "FullName:"+ acc.fullName+ ", "
				+"Position: "+ acc.position.name);
	}	
//question6: viet lenh cho phep nguoi dung tao department
	private static void question6() {
		Scanner scanner5 = new Scanner(System.in);
		System.out.println("Moi ban nhap vao thong tin department can tao: ");
		Department dep = new Department();
		System.out.println("Nhap ID: ");
		dep.id = scanner5.nextInt();
		System.out.println("Nhap Ten: ");
		dep.name = scanner5.next();
		System.out.println("Thong tin department vua nhap: ID: "+ dep.id +","+ "Name:" + dep.name);
	}
//quetion 7: nhap so chan tu console
	private static void question7() {
		Scanner scanner6 = new Scanner(System.in);
		while(true) {
			System.out.println("hay nhap vao 1 so chan: ");
			int a = scanner6.nextInt();
			if(a%2==0) {
				System.out.println("Ban vua nhap vao :" +a);
				return;
			}else {
				System.out.println("Nhap sai, day khong phai so chan");
			}
		}	
	}
//question8:
	private static void question8() {
		Scanner scanner7 = new Scanner(System.in);
		
		int choose;
		
		while(true) {
			System.out.println("Moi ban chon chuc nang: 1.Tao Account, 2. Tao Department");
			choose = scanner7.nextInt();
		if (choose == 1||choose == 2) {
			switch (choose) {
			case 1:
				System.out.println("Moi ban nhap vao thong tin Account can tao");
				Account acc1 = new Account();
				System.out.println("Nhap ID:");
				acc1.id = scanner7.nextInt();
				System.out.println("Nhap Email: ");
				acc1.email = scanner7.next();
				System.out.println("Nhap username: ");
				acc1.userName = scanner7.next();
				System.out.println("Nhap fullName: ");
				acc1.fullName = scanner7.next();
				System.out.println("Account vua tao la: ID" + acc1.id +", " + "Email: "+ acc1.email +", "+ "UserName: "+ acc1.userName+ "FullName:"+ acc1.fullName);
				break;
			case 2:
				System.out.println("Moi ban nhap vao thong tin Department can tao");
				Department dep1 = new Department();
				System.out.println("Nhap ID:");
				dep1.id = scanner7.nextInt();
				System.out.println("Nhap ten: ");
				dep1.name = scanner7.next();
				System.out.println("Department vua tao la: ID: " + dep1.id +", " + "Name: " + dep1.name);	
			}
			return;
		}else
			System.out.println("Moi ban nhap lai");
		}
		
	}
}