// Alex Chandarana Copyright 2024

import java.util.Scanner;

public class Difference {
	
	public static double[] Calculate(double[] lhs_set, double[] rhs_set, double EPSILON) {
		int diffAmt = 0;
		double [] Temp = new double[lhs_set.length + rhs_set.length]; // Guarantees that the array is long enough
		for (int i = 0; i < lhs_set.length; ++i) {
			for (int ii = 0; ii < rhs_set.length; ++ii) {
				if (FPEquals(lhs_set[i], rhs_set[ii], EPSILON)) {
					Temp[diffAmt] = lhs_set[i];
					++diffAmt;
				}
			}
		}
		
		double [] Diff = new double[diffAmt];
		for (int i = 0; i < diffAmt; ++i) {
			Diff[i] = Temp[i];
		}
			
		return Diff;
		
	}
	

	public static boolean FPEquals(double LHS, double RHS, double EPSILON ) {
		return (Math.abs((LHS - RHS) / ((LHS + RHS) / 2))) <= EPSILON; // Percent difference formula
	}
	
	public static boolean FPEquals(double LHS, double RHS) {
		return FPEquals(LHS, RHS, 0.00001); // Gives 0.00001 as the margin of error
	}
	
	public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // get left side set of a\b or a - b
        double[] lhs_set = new double[stdin.nextInt()];
        for (int i = 0; i < lhs_set.length; ++i)
            lhs_set[i] = stdin.nextDouble();

        // get right side set of a\b or a - b
        double[] rhs_set = new double[stdin.nextInt()];
        for (int i = 0; i < rhs_set.length; ++i)
            rhs_set[i] = stdin.nextDouble();

        // get expected result of a\b or a - b
        double[] expected_diff = new double[stdin.nextInt()];
        for (int i = 0; i < expected_diff.length; ++i)
            expected_diff[i] = stdin.nextDouble();

        // get actual result
        double[] actual_diff = Calculate(lhs_set, rhs_set, EPSILON);

        // check size
        if (actual_diff.length != expected_diff.length) {
            System.out.println("Difference size -- Expected: " + expected_diff.length
                    + ", Actual: " + actual_diff.length);
        } else {
            // size is correct, check values in any order
            int numberFound = 0;
            for (double expected : expected_diff) {
                boolean found = false;
                for (double actual : actual_diff) {
                    if (expected == actual) {
                        found = true;
                        break;
                    }
                }
                if (!found)
                    System.out.println(expected + " was not found in set difference");
                else
                    ++numberFound;
            }

            if (numberFound == expected_diff.length)
                System.out.println("All values found in set difference!");
        }
        
        
        stdin.close();
    }

    public static final double EPSILON = 0.00001;
}
