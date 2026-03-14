// Alex Chandarana

import java.util.Scanner;

public class PrintInts {

	public static void main(String[] args) {
		
		int int1 = 0, intL = 1;
		
		Scanner stdin = new Scanner(System.in);
		
		
		// This prints integers followed by a comma and space, or a period depending on if it's the last in the loop or not
		while (intL <= 10) {
			int1 = stdin.nextInt();
			System.out.print(int1);
			if (intL == 10) {
				System.out.print(".");
			} else {
				System.out.print(", ");
			}
			
			intL += 1;
		}

	}

}
