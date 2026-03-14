// Alex Chandarana

import java.util.Scanner;

public class CloseEnough {
	
	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		
		int int1, intL = 1, intC = 0;
		
		double double1, dif, targ, close = 0.001;
		
		
		// targ defined as the double
		targ = stdin.nextDouble();
		int1 = stdin.nextInt();
		
		
		// intL is the number of times the loop has happened
		// the loop defines dif as the difference between the target and the floating point it reads, and then compares the absolute value of that difference to the target to see if it's close enough
		// if it is close enough, it increases intC (int Counter) by one to do math later on
		while (intL <= int1) {
			double1 = stdin.nextDouble();
			dif = (Math.abs(targ - double1));
			if (dif < close) {
				intC += 1;
			}
			intL += 1;
		}
		double perc = (100.0*intC/int1);
		System.out.println(perc + "% are close enough to " + targ);

	}

}
