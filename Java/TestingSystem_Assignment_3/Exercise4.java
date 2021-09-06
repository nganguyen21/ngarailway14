
import java.util.Arrays;
import java.util.Scanner;

public class Exercise4 {
	public static void main(String[] args) {
		question13();
	}

//question 1:
//Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có 
//thể cách nhau bằng nhiều khoảng trắng )
	private static void question1() {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String[] w = a.trim().split(" ");
		for (String string : w) {
			System.out.println(string);
		}
		System.out.println("so luong tu trong cau = " + w.length);
	}

//question 2:Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1
	private static void question2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap chuoi ki tu 1: ");
		String s1 = scanner.nextLine();
		System.out.println("Nhap chuoi ki tu 2: ");
		String s2 = scanner.nextLine();
		System.out.println("Ket qua sau khi noi chuoi la: " + s1 + " " + s2);
	}

//question 3:Viết chương trình để người dùng nhập vào tên và kiểm tra, 
//nếu tên chưa viết hoa chữ cái đầu thì viết hoa lên
	private static void question3() {
		Scanner scanner = new Scanner(System.in);
		String name;
		System.out.println("Nhap ten: ");
		name = scanner.nextLine();
		String firstCharacter = name.substring(0, 1).toUpperCase();
		String leftCharacter = name.substring(1);
		System.out.println("char at:" + name.charAt(1));
		name = firstCharacter + leftCharacter;
		System.out.println(name);
	}

//question 4:
	private static void question4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ten: ");
		String name;
		name = scanner.nextLine();
		name = name.toUpperCase();
		for (int i = 0; i < name.length(); i++) {
			System.out.println("Ky tu thu " + 1 + " la:" + name.charAt(i));
		}
	}

//Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
//dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
	private static void question5() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ho: ");
		String firstName = scanner.nextLine();
		System.out.println("Nhap ten: ");
		String lastName = scanner.nextLine();
		System.out.println("Ho Ten day du la: " + firstName.concat(" " + lastName));
	}

//question 6: Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//sau đó hệ thống sẽ tách ra họ, tên , tên đệm
	private static void question6() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ho ten day du: ");
		String fullName = scanner.nextLine();
		fullName = fullName.trim();
		String lastName = "", middleName = "", firstName = "";
		String[] t = fullName.split(" ");
		lastName = t[0];
		firstName = t[t.length - 1];
		for (int i = 1; i <= t.length - 2; i++) {
			middleName += t[i] + " ";
		}
		System.out.println("Họ là: " + lastName);
		System.out.println("Tên đệm là: " + middleName);
		System.out.println("Tên là: " + firstName);
	}

//question 7:
	// chuan hoa ten" ngUyễn văN nam" thành "Nguyễn Văn Nam"
	private static void question7() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hãy nhập vao ho tên của bạn: ");

		String hoTen = scanner.nextLine();
		scanner.close();
		// trim()
		hoTen = hoTen.trim();
		// split(" ")
		String[] t = hoTen.split(" "); // ["NGÔ", " MiNH", " Chính"]
		// chuẩn hóa từng từ 1
		for (int i = 0; i < t.length; i++) {
			t[i] = t[i].trim(); // t[0] = "NGÔ"
			if (!"".equals(t[i])) {
				String a1 = t[i].substring(0, 1); // a1 = "N"
				a1 = a1.toUpperCase(); // a1 = "N"
				String a2 = t[i].substring(1, t[i].length()).toLowerCase(); // a1 = "N"
				t[i] = a1 + a2;
			}
		}
		System.out.println(Arrays.toString(t));
		//ghep lai
		hoTen = "";
		for (String string : t) {
			if (!"".equals(string)) {
				hoTen = hoTen + string + " ";	
			}
		}
		System.out.println("Ten cua ban la: "+ hoTen);
	}
//question10: Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
//	Nếu có xuất ra “OK” ngược lại “KO”.
//	Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
public static void question10() {
	Scanner scanner = new Scanner(System.in);
	String s1, s2, reverseS1 = "";
	System.out.println("Nhap chuoi 1: ");
	s1 = scanner.nextLine();
	System.out.println("Nhap chuoi 2: ");
	s2 = scanner.nextLine();
	scanner.close();
	for (int i = s1.length() -1; i >= 0; i--) {
		reverseS1 += s1.substring(i,i+1);
	}
	if (s2.equals(reverseS1)) {
		System.out.println("Day la chuoi dao nguoc");
	}else {
		System.out.println("Day khong phai chuoi dao nguoc");
	}
}
//question 11:Tìm số lần xuất hiện ký tự "a" trong chuỗi

public static void question11() {
	Scanner scanner = new Scanner(System.in);
	String string;
	System.out.println("Moi ban nhap vao 1 chuoi");
	string = scanner.nextLine();
	scanner.close();
	int count = 0;
	for (int i = 0; i < string.length(); i++) {
		if ('a' == string.charAt(i)) {
			count++;
		}
	}
	System.out.println("So lan xuat hien ky tu a trong chuoi la: " + count);
}
//question 12: Đảo ngược chuỗi sử dụng vòng lặp
public static void question12() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Nhap vao 1 chuoi: ");
	String string, reverseString = "";
	string = scanner.nextLine();
	scanner.close();
	for (int i = string.length()- 1; i >= 0; i--) {
		reverseString += string.charAt(i);
		
	}
	System.out.println(reverseString);
	
}
//question 13:Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược
//lại true.
public static void question13() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Nhap vao 1 chuoi: ");
	String string;
	string = scanner.nextLine();
	scanner.close();
	for (int i = 0; i < string.length(); i++) {
		if (checkKeyNumber(string.charAt(i))) {
		System.out.println("False");
		return;
		}
		}
		System.out.println("True");
		}
		public static boolean checkKeyNumber(char ch) {
		if (ch >= '0' && ch <= '9') {
		return true;
		}
		return false;
}
}