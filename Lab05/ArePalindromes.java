//Alex Chandarana

import java.util.Scanner;
public class ArePalindromes {

	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		String Char = "", allWord = "";
		int Count = 0, palTest, palCount = stdin.nextInt();
		String[] str = new String[palCount + 1];
		
		for (int i = 0; i < palCount; ++i) {
			str[i] = stdin.next();
			allWord = allWord + str[i];
		}
		
		str[palCount] = allWord;
		
		for (int i = 0; i <= palCount; ++i) {
			palTest = 0;
			int length = str[i].length();
			char[] array = new char[length];
			
			// this is the same code I used for DetectPalindrome in the previous project,  simply done repeatedly for each word inside the array "str."
			for (int j = 0; j < length; ++j) {
				array[j] = str[i].charAt(j);
				if (array[j] == array[length - (1 + j)]) {
					palTest++;
					// only does this for the last half of the letters if it is a palindrome.
				} else {
					palTest--;
					// this will only happen for the first half if it's a palindrome, or all characters if it's not
				}
				
			}
			
			if (palTest >= 0) {
				System.out.println(str[i] + " is a palindrome.");
			} else {
				System.out.println(str[i] + " is not a palindrome.");
			}
		}

	}
}