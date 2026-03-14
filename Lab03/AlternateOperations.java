// Alex Chandarana

import java.util.Scanner;

public class AlternateOperations {
	
	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		
		int int1, intL = 0, isAdd = 1;
		
		double doubleX, double1;
		
		double1 = stdin.nextDouble();
		int1 = stdin.nextInt();
		
		// This simply sees if the value "isAdd" is one or zero, and then performs the operation, and then changes the value of "isAdd"
		while (intL < int1) {
			doubleX = stdin.nextDouble();
			if (isAdd == 0) {
				double1 = double1 - doubleX;
				isAdd++;
			} else {
				double1 = double1 + doubleX;
				isAdd--;
			}
			intL++;
		}
		
		System.out.print(double1);

	}

}
