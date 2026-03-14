// Alex Chandarana Copyright 2024

import java.util.Scanner;

public class CloseEnough {
    
	public static boolean FPEquals(double LHS, double RHS, double EPSILON ) {
		return (Math.abs((LHS - RHS) / ((LHS + RHS) / 2))) <= EPSILON; // Percent difference formula
	}
	

	public static boolean FPEquals(double LHS, double RHS) {
		return FPEquals(LHS, RHS, 0.00001); // Gives 0.00001 as the margin of error
	}

    public static final int LHS = 0;
    public static final int RHS = 1;

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // get all pairs
        double[][] comparison_pairs = new double[stdin.nextInt()][2];
        for (int i = 0; i < comparison_pairs.length; ++i) {
            for (int ii = 0; ii < comparison_pairs[i].length; ++ii) {
                comparison_pairs[i][ii] = stdin.nextDouble();
            }
        }

        // get expected outcomes
        boolean[] outcomes = new boolean[comparison_pairs.length];
        for (int i = 0; i < outcomes.length; ++i) {
            outcomes[i] = stdin.nextBoolean();
        }

        int testsPassed = 2 * comparison_pairs.length;

        for (int i = 0; i < comparison_pairs.length; ++i) {
            // test method with two arguments
            boolean actual = FPEquals(comparison_pairs[i][LHS], comparison_pairs[i][RHS]);
            if (actual != outcomes[i]) {
                --testsPassed;
                System.out.print("FPEquals(" + comparison_pairs[i][LHS] + ", ");
                System.out.print(comparison_pairs[i][RHS] + ") ");
                System.out.println("Expected: " + outcomes[i] + ", Actual: " + actual);
            }

            // test method with three arguments
            actual = FPEquals(comparison_pairs[i][LHS], comparison_pairs[i][RHS], EPSILON);
            if (actual != outcomes[i]) {
                --testsPassed;
                System.out.print("FPEquals(" + comparison_pairs[i][LHS] + ", ");
                System.out.print(comparison_pairs[i][RHS] + ") ");
                System.out.println("Expected: " + outcomes[i] + ", Actual: " + actual);
            }
        }

        if (testsPassed == comparison_pairs.length) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(testsPassed + " of " + 2 * comparison_pairs.length + " tests passed.");
        }

        stdin.close();
    }


	public static final double EPSILON = 0.00001;
}
