
public class Exercise3 {
public static void main(String[] args) {
	System.out.println("=====question1======");
	Integer luong = 5000;
	float a = luong;
	System.out.printf("%.2f\n",a);
//	question 2: Khai báo 1 String có value = "1234567"
//Hãy convert String đó ra số int	
	System.out.println("=====question2======");
	String s = "1234567";
	int i = Integer.parseInt(s);
	System.out.println(i);
	
//q3
	System.out.println("=====question3======");
	Integer i1 = Integer.valueOf("1234567");
	System.out.println((int) i1);
	

}
}
