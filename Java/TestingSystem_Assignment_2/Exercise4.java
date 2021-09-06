import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {

	public static void main(String[] args) {
//question 1: In ngau nhien 1 so nguyen
		System.out.println("=====Question 1=====");
		Random random = new Random();
		int x = random.nextInt();
		// System.out.println("so ngau nhien: " + x);

// question 2: in ngau nhien ra 1 so thuc
		System.out.println("=====Question 2=====");
		float f = random.nextFloat();
		// System.out.println(c f);

//question 3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên
//ra tên của 1 bạn
		System.out.println("=====Question 3=====");
		String[] nameArr = { "Nga", "An", "Linh", "Phong" };
		int i = random.nextInt(nameArr.length);
		// System.out.println("Ten ngau nhien 1 ban trong lop: " + nameArr[i]);
//question 4: Lay ngau nhien 1 ngay trong khoang thoi gian 24-07-1995 toi ngay 20-12-1995
		System.out.println("=====Question 4=====");
		int minDay = (int) LocalDate.of(1995, 07, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		System.out.println("minDay: " + minDay);
		System.out.println("maxDay: " + maxDay);
		long randomInt = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);
//question 5: lay ngau nhien 1 ngay trong khoang thoi gian 1 nam tro lai day
		System.out.println("======Question 5======");
		int now = (int) LocalDate.now().toEpochDay();
		int randomDate = now - random.nextInt(365);
		LocalDate resultDate = LocalDate.ofEpochDay(randomDate);
		System.out.println("Ngay ngau nhien la: " + resultDate);
//question 6: Lay ngau nhien 1 ngay trong qua khu
		System.out.println("=====question 6=====");
		int maxDay1 = (int) LocalDate.now().toEpochDay();
		long randomDay1 = random.nextInt(maxDay1);
		LocalDate resultDate1 = LocalDate.ofEpochDay(randomDay1);
		System.out.println("Ngay ngau nhien trong qua khu la: " + resultDate1);
//question 7: lay ngau nhien mot so co 3 chu so
		System.out.println("======Question 7======");
		int z = random.nextInt(999 - 100 + 1) + 100;
		System.out.println(z);
	}

}
