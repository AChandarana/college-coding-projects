//Alex Chandarana

import java.util.Scanner;

public class ArithmeticComparisons {

	public static void main(String[] args) {
		
		int int1, int2, int3;
		String string1, string2, string3;
		double double1, double2, double3;
    	
		Scanner stdin = new Scanner(System.in);

    	int1 = stdin.nextInt();
    	string1 = stdin.next();
    	double1 = stdin.nextDouble();
    	string2 = stdin.next();
    	int2 = stdin.nextInt();
    	double2 = stdin.nextDouble();
    	double3 = stdin.nextDouble();
    	string3 = stdin.next();
    	int3 = stdin.nextInt();
    	
    	
    	//I compared the values ahead of time and stored them into boolean variables, and then recalled them starting line 32
    	boolean TwoDivThreeMore0 = ((int2/int3) > 0);
    	boolean ThreeDivTwoMore1 = ((int3/int2) > 1);
    	boolean ThreeDivOneEq4 = ((int3/int1) == 4);
    	boolean DOneMinDTwoEqDThree = (double1 - double2 == double3);
    	
    	System.out.println(int2 + " / " + int3 + " > " + 0 + " is " + TwoDivThreeMore0);
    	System.out.println(int3 + " / " + int2 + " > " + 1 + " is " + ThreeDivTwoMore1);
    	System.out.println(int3 + " / " + int1 + " = " + 4 + " is " + ThreeDivOneEq4);
    	System.out.println(double1 + " - " + double2 + " = " + double3 + " is " + DOneMinDTwoEqDThree);



	}

}
