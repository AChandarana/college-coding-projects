// Alex Chandarana

import java.util.Scanner;
public class IsSequence {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		int Count = stdin.nextInt(), Next;
		int[] List = new int[Count];
		int[] List2 = new int[Count];
		

		for (int i = 0; i < Count; ++i) {
			Next = stdin.nextInt();
			List[i] = Next;

		}
		int Count2 = stdin.nextInt();

		for (int i = 0; i < Count2; ++i) {
			Next = stdin.nextInt();
			List2[i] = Next;
		}
		
		// Goes through larger list until it matches smaller list, when it does it goes to the next value of the smaller list and tests it against the next value of the larger list
		int ii = 0;
		for (int i = 0; i < Count; ++i) {
			if (List[i] == List2[ii]) {
				++ii;
			}
		}
		
		if (ii == Count2) {
			System.out.print("is subsequence");
		} else {
			System.out.print("is not subsequence");
		}
	}

}
