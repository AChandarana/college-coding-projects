//Alex Chandarana

import java.util.Scanner;

public class PrintScoresPassed {

	public static void main(String[] args) {
		
		double double1, double2, double3;
		int int1, int2, int3, int4, int5, int6;
    	
		Scanner stdin = new Scanner(System.in);

    	double1 = stdin.nextDouble();
    	int1 = stdin.nextInt();
    	int2 = stdin.nextInt();
    	double2 = stdin.nextDouble();
    	int3 = stdin.nextInt();
    	int4 = stdin.nextInt();
    	double3 = stdin.nextDouble();
    	int5 = stdin.nextInt();
    	int6 = stdin.nextInt();
    	
    	//This is a simple comparison to see if the double meets a value that will determine if the student passes
    	System.out.print("Student 1 results: ");
    	if (double1 >= 69.445) {
    		System.out.print("passed, ");
    	} else {
    		System.out.print("not passed, ");
    	}
    	
    	if (int1 >= 7) {
    		System.out.print("passed, ");
    	} else {
    		System.out.print("not passed, ");
    	}
    	
    	if (int2 > 10) {
    		System.out.print("passed");
    	} else {
    		System.out.print("not passed");
    	}	
    	
    	
    	
    	System.out.print("\nStudent 2 results: ");
    	if (double2 >= 69.445) {
    		System.out.print("passed, ");
    	} else {
    		System.out.print("not passed, ");
    	}
    	
    	if (int3 >= 7) {
    		System.out.print("passed, ");
    	} else {
    		System.out.print("not passed, ");
    	}
    	
    	if (int4 > 10) {
    		System.out.print("passed");
    	} else {
    		System.out.print("not passed");
    	}	
    	
    	
    	
    	System.out.print("\nStudent 3 results: ");
    	if (double3 >= 69.445) {
    		System.out.print("passed, ");
    	} else {
    		System.out.print("not passed, ");
    	}
    	
    	if (int5 >= 7) {
    		System.out.print("passed, ");
    	} else {
    		System.out.print("not passed, ");
    	}
    	
    	if (int6 > 10) {
    		System.out.print("passed");
    	} else {
    		System.out.print("not passed");
    	}	

	}

}
