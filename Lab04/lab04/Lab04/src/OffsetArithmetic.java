//Alex Chandarana

import java.util.Scanner;
public class OffsetArithmetic {

	public static void main(String[] args) {
		
		int Count, isAdd = 1;
		Scanner stdin = new Scanner(System.in);
		Count = stdin.nextInt();
		
		int[] array = new int[Count];
		
		for(int i=0; i < Count; i++) {
			array[i] = stdin.nextInt();
			}
		
		// Sets up two strings "od" and "Cnt". If they are the same, then the number of integers in even, and if not it is odd.
		double isOdd = Count;
		isOdd = isOdd/2;
		String Cnt, od;
		Cnt = (Count/2) + ".0";
		od = isOdd + "";
		
		
		if (Cnt.equals(od)) {
			for(int i=0; i < Count/2; i++) {
				if (i == Count/2) {
					if (isAdd == 0) {
						System.out.print(array[i] + " - " + 0 + " = " + array[i]);
						isAdd--;
					}
					if (isAdd == 1) {
						System.out.print(array[i] + " + " + 0 + " = " + array[i]);
						isAdd++;
					}
					
				} else if (isAdd == 1) {
					System.out.println(array[i] + " + " + array[Count - (1 + i)] + " = " + (array[i] + array[Count - (1 + i)]));
					isAdd--;
				} else {
					System.out.println(array[i] + " - " + array[Count - (1 + i)] + " = " + (array[i] - array[Count - (1 + i)]));
					isAdd++;
				}
				
				
			}
		} else {
			for(int i=0; i < Count/2 + 1; i++) {
				if (i == Count/2) {
					if (isAdd == 0) {
						System.out.print(array[i] + " - " + 0 + " = " + array[i]);
						isAdd--;
					}
					if (isAdd == 1) {
						System.out.print(array[i] + " + " + 0 + " = " + array[i]);
						isAdd++;
					}
					
				} else if (isAdd == 1) {
					System.out.println(array[i] + " + " + array[Count - (1 + i)] + " = " + (array[i] + array[Count - (1 + i)]));
					isAdd--;
				} else {
					System.out.println(array[i] + " - " + array[Count - (1 + i)] + " = " + (array[i] - array[Count - (1 + i)]));
					isAdd++;
				}
				
				
			}
		}
		
		
		


	}

}
