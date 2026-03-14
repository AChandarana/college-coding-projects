// Alex Chandarana

import java.util.Scanner;
public class CalculateMedian {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		int Count = stdin.nextInt();
		double[] Values = new double[Count];
		
		for (int i = 0; i < Count; ++i) {
			Values[i] = stdin.nextDouble();
		}
		
		for (int i = 0; i < Count; ++i) {
			int smallest = i;
			for (int j = i + 1; j < Count; ++j) {
				if (Values[j] < Values[smallest]) {
					smallest = j;
				}
			}
			
			double temp = Values[i];
			Values [i] = Values[smallest];
			Values[smallest] = temp;
		}
		
		// Searched online to find an easier way to find if a number is even or not
		double median;
		if (Count % 2 == 0) {
			// Finds average of middle two values
			median = (Values[(Count/2)-1] + Values[Count/2])/2;
		} else {
			median = Values[Count/2];
		}
		
		System.out.print("Median: " + median);
		
	}

}
