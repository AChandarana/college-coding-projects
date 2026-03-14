// Alex Chandarana

import java.util.Scanner;
public class SortStudents {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		int Count = stdin.nextInt();
		String[] Names = new String[Count];
		double[] Grades = new double[Count];
		
		for (int i = 0; i < Count; ++i) {
			Names[i] = stdin.next();
		}
		
		for (int i = 0; i < Count; ++i) {
			Grades[i] = stdin.nextDouble();
		}
		
		for (int i = 0; i < Count; ++i) {
			int largest = i;
			for (int j = i + 1; j < Count; ++j) {
				if (Grades[j] > Grades[largest]) {
					largest = j;
				}
			}
			
			// Re-orders names along with the grades
			double temp = Grades[i];
			String temp1 = Names[i];
			Grades[i] = Grades[largest];
			Names[i] = Names[largest];
			Grades[largest] = temp;
			Names[largest] = temp1;
			
			// For proper commas
			if (i == Count - 1) {
				System.out.print(Names[i]);
			} else {
				System.out.print(Names[i] + ", ");
			}
			
		}
		
		
	}

}
