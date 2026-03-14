// Alex Chandarana

import java.util.Scanner;

public class PrintOrder {

	public static void main(String[] args) {
		
		String Char = "", Word = "";
		
		Scanner stdin = new Scanner(System.in);
		
		Char = stdin.next();
		while (!Char.equals(".")) {
			
			// Checks for a hyphen; if it's a hyphen it will continue to add characters to the beginning of the word until it hits a plus or period
			if (Char.equals("-")) {
				Char = stdin.next();
				while (!Char.equals("+") && !Char.equals(".")) {
					if (!Char.equals(".")) {
						if (!Char.equals("-")) {
							Word = Char + Word;
							Char = stdin.next();
						} else {
							Char = stdin.next();
							
						}
						
					} 
					
				}
				
			}
			
			// Checks for a plus; if it's a plus it will continue to add characters to the end of the word until it hits a hyphen or period
			if (Char.equals("+")) {
				Char = stdin.next();
				while (!Char.equals("-") && !Char.equals(".")) {
					if (!Char.equals(".")) {
						if (!Char.equals("+")) {
							Word = Word + Char;
							Char = stdin.next();
						} else {
							Char = stdin.next();
						}
						
					}
					
				}
				
			}
			
		
		}
		System.out.print("The word is " + Word);
		
		
	}
}