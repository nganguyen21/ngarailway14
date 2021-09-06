package entity;

import java.util.Date;

import org.ietf.jgss.Oid;

import constant.PositionName;

public class Program {
	public static void main(String[] args) {

		// tao 4 doi tuong Department
		Department phongDev = new Department();
		phongDev.id = 1;
		phongDev.name = "phong DEV";
		Department phongTest = new Department(3, "phong TEST");
		Department phongHanhChinh = new Department(4, "phong Hanh Chinh");
		Department phongGiamDoc = new Department(2, "phong Giam Doc");

		System.out.println(phongTest.toString());

		// tao 4 doi tuong Position
		Position dev = new Position(); // Instance
		dev.setId(1);
		dev.setName(PositionName.DEV);
		Position pm = new Position(2, PositionName.PM);
		Position test = new Position(3, PositionName.TEST);
		Position scrumMaster = new Position(4, PositionName.SCRUMMASTER);

		System.out.println(pm);
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

		System.out.println(group3.toString());

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

		System.out.println(account2.toString());

	}
}
