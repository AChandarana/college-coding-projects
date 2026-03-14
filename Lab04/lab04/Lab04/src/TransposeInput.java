// Alex Chandarana

import java.util.Scanner;
public class TransposeInput {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		int Count = stdin.nextInt(), strCount = 0;
		int[] arrayInt = new int[Count];
		String str = "";

		
		for (int i = 0; i < Count; i++) {
			arrayInt[i] = stdin.nextInt();
		}
		
		String next = stdin.next();
		while (!next.equals(".")) {
			str = str + next;
			strCount++;
			next = stdin.next();
		}
		
		// this array is initialized here to set the size after we know how many characters there are
		char[] arrayChar = new char[strCount];
		for (int i = 0; i < strCount; i++) {
			arrayChar[i] = str.charAt(i);
		}
		
		if (Count >= strCount) {
			for (int i = 0; i < Count; i++) {
				if (i >= strCount) {
				// tests if either the integers or characters has more values, and runs code that handles either situation accordingly	
					System.out.println(arrayInt[i] + "\t_");
				} else {
					System.out.println(arrayInt[i] + "\t" + arrayChar[i]);
				}
			}
			
		} else {
			for (int i = 0; i < strCount; i++) {
				if (i >= Count) {
					System.out.println("_\t" + arrayChar[i]);
				} else {
					System.out.println(arrayInt[i] + "\t" + arrayChar[i]);
				}
			}
		}

	}

}
