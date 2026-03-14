//Alex Chandarana

import java.util.Scanner;

public class PrintPassed {

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
    	
    	//This adds the scores together and compares it to a passing grade to see if the student passes
    	if ((double1 + int1 + int2) >= 87.5) {
    		System.out.println("Student 1 is passing");
    	} else {
    		System.out.println("Student 1 is not passing");
    	}
    	if ((double2 + int3 + int4) >= 87.5) {
    		System.out.println("Student 2 is passing");
    	} else {
    		System.out.println("Student 2 is not passing");
    	}
    	if ((double3 + int5 + int6) >= 87.5) {
    		System.out.println("Student 3 is passing");
    	} else {
    		System.out.println("Student 3 is not passing");
    	}
    		
    	

	}

}
