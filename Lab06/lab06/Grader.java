// Alex Chandarana Copyright 2024

import java.util.Scanner;

public class Grader {

    public static String ToGrade(double score) {
        score = score + 0.0555; // For rounding
    	if ((score >= 4) && (score <= 4.5)) {
        	return "A+";
        }
        
        if ((score >= 3.5) && (score < 4)) {
        	return "A";
        }
        
        if ((score >= 3) && (score < 3.5)) {
        	return "B+";
        }
        
        if ((score >= 2.5) && (score < 3)) {
        	return "B";
        }
        
        if ((score >= 2) && (score < 2.5)) {
        	return "C+";
        }
        
        if ((score >= 1.5) && (score < 2)) {
        	return "C";
        }
        
        if ((score >= 1) && (score < 1.5)) {
        	return "D+";
        }
        
        if ((score >= 0.5) && (score < 1)) {
        	return "D";
        } else {
        	return "F";
        }

    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // read test scores from standard input stream, starting w/ size
        double[] scores = new double[stdin.nextInt()];
        for (int i = 0; i < scores.length; ++i) {
            scores[i] = stdin.nextDouble();
        }

        // read test grades from standard input stream, using scores' size
        String[] grades = new String[scores.length];
        for (int i = 0; i < grades.length; ++i) {
            grades[i] = stdin.next();
        }

        // test method ToGrade
        int testsPassed = scores.length;
        for (int i = 0; i < scores.length; ++i) {
            String actual = ToGrade(scores[i]);
            if (!actual.equals(grades[i])) {
                --testsPassed;
                System.out.print("ToGrade(" + scores[i] + ") ");
                System.out.print("Expected: " + grades[i]);
                System.out.println(", Actual: " + actual);
            }
        }

        // print result
        if (testsPassed == scores.length) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(testsPassed + " of " + scores.length + " passed.");
        }

        stdin.close();
    }
}
