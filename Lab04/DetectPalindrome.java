//Alex Chandarana

import java.util.Scanner;
public class DetectPalindrome {

	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);

		String Word = stdin.next();
		String Char = "";
		int Count = 0, palTest = 0;
		
		while (!Char.equals(".")) {
			Word = Word + Char;
			Char = stdin.next();
			Count++;
		}

		char[] array = new char[Count];
		
		for (int i = 0; i < Count; ++i) {
			array[i] = Word.charAt(i);
			if (array[i] == array[Count - (1 + i)]) {
				palTest++;
				// only does this for the last half of the letters if it is a palindrome.
			} else {
				palTest--;
				// this will only happen for the first half if it's a palindrome, or all characters if it's not
			}
		}
		
		if (palTest >= 0) {
		/*
		 * I realized that for any words that aren't a palindrome, palTest will always return a 
		 * negative number. If it's zero, that means exactly half the letters in the last half of the
		 * word matches up perfectly with the first half, meaning it is a palindrome with an even number of 
		 * letters. If it is one, that means it has a center letter equal to itself in addition the the entire
		 * last half. If it's negative, that means at least one of the letters in the last half did not have
		 * a letter in the first half that matches it.
		 */
			System.out.print(Word + " is a palindrome.");
		} else {
			System.out.print(Word + " is not a palindrome.");
		}


	}
}
