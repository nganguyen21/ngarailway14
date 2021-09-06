import java.util.Arrays;


public class Exercise5 {
public static void main(String[] args) {
	String[] arr1 = {"Anh", "Ngoc", "Bau", "Chau"};
	int l = arr1.length;
	System.out.println(Arrays.toString(arr1));
	System.out.println("---------------------");
	for (int i2 = 0; i2 < arr1.length; i2++) {
		for (int i1 = 0; i1 < l-1- i2; i1++) {
			char ai = arr1[i1].charAt(0);
			char ai1 = arr1[i1+1].charAt(0);
			System.out.printf("so sanh chu cai: %s  <-> %s\n", ai, ai1);
			if (Character.compare(ai, ai1)>0) {
				String temp = arr1[i1];
				arr1[i1] = arr1[i1+1];
				arr1[i1+1]= temp;
				}
		
			}
		System.out.println("---------------------");
		}
	System.out.println(Arrays.toString(arr1));
	}
}
