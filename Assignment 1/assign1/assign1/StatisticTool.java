// Copyright 2024 Alex Chandarana

import java.util.Scanner;

public class StatisticTool {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // Loop Preamble
        // Put the variables which must exist outside of the main application loop
        // here, e.g., the loop control variable, the data variable, and, at least,
        // one more.

        int input; // loop control variable
        double[] values = new double[2];
        int index = 0;
        
        // Main Application Loop
        do {
            // Print a menu for user interaction
            System.out.println("Statistic Tool");
            System.out.println("1. Add Data");
            System.out.println("2. Calculate Max");
            System.out.println("3. Calculate min");
            System.out.println("4. Print Data");
            System.out.println("5. Quit");
            System.out.print("$> ");
            input = stdin.nextInt();

            // depending on the user's input, do one of four things or quit.
            // when input is 1, add datum
            
            if (input == 1) { 
            	if (index == values.length) {
            		double [] copy = new double[2 * values.length];
            		for (int i = 0; i < values.length; ++i) {
            			copy[i] = values [i];
            		}
            		values = copy;
            	}
            	
            	System.out.print("Enter Datum: ");
            	values[index] = stdin.nextDouble();
            	++index;
            	
            }

            
            // when input is 2, determine max of data
            
            if (input == 2) {
            	int max = 0;
            	for (int i = 0; i < index; ++i) {
            		if (values[i] > values[max]) {
            			max = i;
            		}
            	}
            	System.out.println("Max datum: " + values[max] + "\n");
            }
            
            // when input is 3, determine min of data
            
            if (input == 3) {
            	int min = 0;
            	for (int i = 0; i < index; ++i) {
            		if (values[i] < values[min]) {
            			min = i;
            		}
            	}
            	System.out.println("Min datum: " +values[min] + "\n");
            }
            
            // when input is 4, print all data
            
            if (input == 4) {
            	for (int i = 0; i < index; ++i) {
            		System.out.print(values[i] + " ");
            	}
            	System.out.print("\n");
            }
            
            // when input is 5, quit
        } while (0 < input && input < 5);

        System.out.println("\nGoodbye!");

        stdin.close();
    }
}
