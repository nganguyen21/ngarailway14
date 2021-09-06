import java.time.LocalDate;
import java.util.Date;

public class Exercise2 {
public static void main(String[] args) {
/*Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi 
tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
 Email: "Email 1"
 Username: "User name 1"
 FullName: "Full name 1"
 CreateDate: now*/
	
		Account[] accountArray= new Account[5];
		for (int i = 1; i<=accountArray.length;i++) {
			Account account =new Account();
			account.email = "Email " +i;
			account.userName = "User name " +i;
			account.fullName = "Full name " +i;
			account.createDate = new Date();
			accountArray[i-1] = account;
			}
		for (Account account : accountArray) {
			System.out.println(account);
		}

}
}
