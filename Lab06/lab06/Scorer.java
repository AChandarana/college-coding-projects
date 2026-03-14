// Alex Chandarana Copyright 2024

import java.util.Scanner;

public class Scorer {
    /**
     * Maps a letter grade from [F, A+] to a score in [0.0, 4.0]
     *
     * @param grade a letter grade from the range [F, A+]
     * @return a score from the range [0.0, 4.0]
     */
    public static double ToScore(String grade) {
        
    	// Checks what the grade is and returns the appropriate GPA
    	if (grade.equals("A+")) {
        	return 4.0;
        }
        
        if (grade.equals("A")) {
        	return 3.5;
        }
        
        if (grade.equals("B+")) {
        	return 3.0;
        }
        
        if (grade.equals("B")) {
        	return 2.5;
        }
        
        if (grade.equals("C+")) {
        	return 2.0;
        }
        
        if (grade.equals("C")) {
        	return 1.5;
        }
        
        if (grade.equals("D+")) {
        	return 1.0;
        }
        
        if (grade.equals("D")) {
        	return 0.5;
        } else {
        	return 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // read grades from standard input stream, same size as scores
        String[] grades = new String[stdin.nextInt()];
        for (int i = 0; i < grades.length; ++i) {
            grades[i] = stdin.next();
        }

        // read test scores from standard input stream, starting w/ size
        double[] scores = new double[grades.length];
        for (int i = 0; i < scores.length; ++i) {
            scores[i] = stdin.nextDouble();
        }

        // use arrays to test ToScore method
        int testsPassed = grades.length;
        for (int i = 0; i < grades.length; ++i) {
            Double actual = ToScore(grades[i]);
            if (actual != scores[i]) {
                --testsPassed;
                System.out.print("ToScore(" + grades[i] + ") ");
                System.out.print("Expected: " + scores[i]);
                System.out.println(", Actual: " + actual);
            }
        }

        if (testsPassed == grades.length) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(testsPassed + " of " + scores.length + " passed.");
        }

        stdin.close();
    }
}
