// Alex Chandarana Copyright 2024

import java.util.Scanner;

public class Extrema {
	public static int Max(double[] numbers) { // finds max value
		int Max = 0;
		for (int i = 0; i < numbers.length; ++i) {
			if (numbers[i] > numbers[Max]) {
				Max = i;
			}
		}
		
		return Max;
		
	 }

	public static int Min(double[] numbers) { // finds min value
		int Min = 0;
		for (int i = 0; i < numbers.length; ++i) {
			if (numbers[i] < numbers[Min]) {
				Min = i;
			}
		}
		
		return Min;
	}

    public static void main(String[] args) {
    	
        Scanner stdin = new Scanner(System.in);

        // get floating point values
        double[] numbers = new double[stdin.nextInt()];
        for (int i = 0; i < numbers.length; ++i)
            numbers[i] = stdin.nextDouble();

        // get expected outcomes
        int expected_max = stdin.nextInt();
        int expected_min = stdin.nextInt();

        // get actual values
        int actual_max = Max(numbers);
        int actual_min = Min(numbers);

        // compare expected and actual
        int testsPassed = 2;
        if (actual_max != expected_max) {
            --testsPassed;
            System.out.print("Max(double[]) Expected: " + numbers[expected_max]);
            System.out.println(", Actual: " + numbers[actual_max]);
        }
        if (actual_min != expected_min) {
            --testsPassed;
            System.out.print("Min(double[]) Expected: " + numbers[expected_min]);
            System.out.println(", Actual: " + numbers[actual_min]);
        }

        if (testsPassed == 2)
            System.out.println("All tests passed!");
        else
            System.out.println(testsPassed + " of 2 passed.");

        stdin.close();
    }
}
