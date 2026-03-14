// Alex Chandarana

import java.util.Scanner;

public class GreaterThanFirst {

	public static void main(String[] args) {
		
		int int1, intC, intP = 0, intL = 1;
		double Perc = 0;
		
		Scanner stdin = new Scanner(System.in);
		int1 = stdin.nextInt();
		
		while (intL <= 9) {
			intC = stdin.nextInt();
			if (intC > int1) {
				intP += 1;
			}
			intL += 1;
		}
		
		// Since there will only ever be 10 values, I can just display intP followed by "0.0%" to display an accurate percentage
		System.out.println(intP + "0.0% are greater than " + int1);

	}

}
