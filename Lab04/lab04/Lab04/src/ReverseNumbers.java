//Alex Chandarana

import java.util.Scanner;
public class ReverseNumbers {

	public static void main(String[] args) {
		
		int Count;
		String Rev = "";
		Scanner stdin = new Scanner(System.in);
		Count = stdin.nextInt();
		
		int[] array = new int[Count];
		
		
		for(int i=0; i < Count; i++) {
			array[i] = stdin.nextInt();
			if (i == 0) {
			// tests if this is the first int being stored, if it is it doesn't need a comma.	
				Rev = array[i] + " " + Rev;
			} else {
				Rev = array[i] + ", " + Rev;
			}
		}
		
		System.out.print(Rev + " ");

	}

}
