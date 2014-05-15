import java.util.*;

public class Main { 
	public static void first(Scanner console) {
		System.out.print("Input n (n<128): ");
		byte n = console.nextByte();
		ArrayList<String> arrayStr = new ArrayList<String>();
		int sum = 0;
		for (byte i=0; i<n; i++) {
			System.out.println("Input new string: ");
			arrayStr.add(console.next());
			sum += arrayStr.get(i).length();
		}
		float average = sum/(float)n;
		byte i = 0;
		while (i<n) {
			int strLength = arrayStr.get(i).length();
			if (strLength < average) {
				System.out.println(arrayStr.get(i) + " " + strLength);
				i++;
			} else {
			i++;
			}
		}
	}
	
	public static void second(Scanner console) {
		System.out.println("Input from s1 to s5 strings:");
		String s1 = console.next();
		String s2 = console.next();
		String s3 = console.next();
		String s4 = console.next();
		String s5 = console.next();
		String ans = s4.equals(s5) ? s1+s2 : s1+s3;
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		Scanner c = new Scanner(System.in);
		first(c);
		second(c);
		c.close();
	}
}

/*
1. Ввести n строк с консоли. Вывести на консоль строки, длина которых меньше средней, также их длины.
2. Дано 5 строк s1, s2, s3, s4 и s5, на основе условия: если строка s4 равна строке s5, 
нужно составить строки s1 и s2, иначе нужно составить строки s1 и s3
*/
