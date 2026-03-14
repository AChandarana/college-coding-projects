// Alex Chandarana

import java.util.Scanner;

public class PrintLetters {

	public static void main(String[] args) {
		
		String Char = "";
		
		Scanner stdin = new Scanner(System.in);
		
		// Checks if the character isn't something other than a letter, and if it's not it print the character (which will be a letter)
		while (!Char.equals(".")) {
			Char = stdin.next();
			if (!Char.equals("-")) {
				if (!Char.equals("+")) {
					if (!Char.equals(".")) {
						System.out.print(Char);
					}
				}
			}
		}
	}
}
