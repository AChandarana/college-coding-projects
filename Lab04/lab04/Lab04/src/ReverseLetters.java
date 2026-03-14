//Alex Chandarana

import java.util.Scanner;
public class ReverseLetters {

	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);

		String Word = stdin.next();
		String Char = "", RevWord = "";
		int Count = 0;
		
		while (!Char.equals(".")) {
		// tests if the character is a period before running
			Word = Word + Char;
			Char = stdin.next();
			Count++;
		}

		char[] array = new char[Count];
		
		for (int i = 0; i < Count; ++i) {
			array[i] = Word.charAt(i);
			RevWord = array[i] + RevWord;
			// takes the next letter and puts it at the beginning of the word
		}
		System.out.println(RevWord);
		
	}
}
