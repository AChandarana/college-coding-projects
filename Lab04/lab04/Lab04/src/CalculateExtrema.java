//Alex Chandarana

import java.util.Scanner;
public class CalculateExtrema {

	public static void main(String[] args) {
		
		int Count, Max = 0, Min = 0;
		String Symb;
		double Avr = 0;
		Scanner stdin = new Scanner(System.in);
		Count = stdin.nextInt();
		
		int[] array = new int[Count];
		
		for(int i=0; i < Count; i++) {
			array[i] = stdin.nextInt();
			if (i == 0) {
				Max = array[i];
				Min = array[i];
			}
			if (array[i] >= Max) {
				Max = array[i];
			}
			if (array[i] <= Min) {
				Min = array[i];
			}
			Avr = Avr + array[i];
		}
		
		// Already tested for the correct number of integers, so the next character is the symbol to determine operation
		Symb = stdin.next();
		
		if (Symb.equals("+")) {
			System.out.print("Max value: " + Max);
		}
		if (Symb.equals("-")) {
			System.out.print("Min value: " + Min);
		}
		if (Symb.equals("/")) {
			System.out.print("Average value: " + Avr/Count);
		}
	
	
	}

}
