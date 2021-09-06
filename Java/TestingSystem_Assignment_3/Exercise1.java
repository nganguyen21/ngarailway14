import java.util.Scanner;

public class Exercise1 {
public static void main(String[] args) {
//	question 1: Khai báo 2 số lương có kiểu dữ liệu là float.
//	Khởi tạo Lương của Account 1 là 5240.5 $
//	Khởi tạo Lương của Account 2 là 10970.055$
//	Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//	Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
	System.out.println("=====Question1=====");
	float salary1;
	float salary2;
	salary1 = 5250.5f;
	salary2 = 10970.055f;
	//System.out.println("Salary1: " +salary1 + "||" + "Salary2: "+ salary2);
	
	System.out.println("roundSalary1: " + (int) salary1 + "||" + "roundSalary2:"+ (int) salary2);
//question2:Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
//có số 0 ở đầu cho đủ 5 chữ số)
	System.out.println("=====Question2=====");
	int min = 0;
	int max = 99999;
	int a = (int) (Math.random()*max)+min;
	while(a<10000) {
		a = a*10;
	}
	System.out.println(a);
//question 3: Lay 2 so cuoi cua question 2 va in ra
	System.out.println("=====Question 3======");
	String b = String.valueOf(a);
	System.out.println(b.substring(3));
//question 4: Nhap va hai so nguyen a va b va tra ve thuong cua chung
	System.out.println("======question4======");
	int a1, b1; 
	Scanner scanner = new Scanner(System.in);
	System.out.println("Nhap a1: ");
	a1 = scanner.nextInt();
	do {
		System.out.println("Nhap b1: ");
		b1 = scanner.nextInt();
		if (b1 == 0) {
			System.out.println("Nhap b1 khac 0");
		}
	}while(b1 == 0);

	System.out.println("Thuong cua 2 so a va b = "+ (float)a1/b1);
}
}
