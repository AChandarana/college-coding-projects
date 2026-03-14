// Copyright 2025 Alex Chandarana

import java.util.Arrays;

public class WordHelper {
	
	
	// Takes in any letter and returns a t/f as to whether it is a vowel; also checks for upper case
	public static boolean isVowel(char letter) {
		if(letter == 'a' || letter == 'A') {
			return true;
		} else if(letter == 'e' || letter == 'E') {
			return true;
		} else if(letter == 'i' || letter == 'I') {
			return true;
		} else if(letter == 'o' || letter == 'O') {
			return true;
		} else if(letter == 'u' || letter == 'U') {
			return true;
		} else if(letter == 'y' || letter == 'Y') { // according to expected result given, y is a vowel
			return true;
		} else {
			return false;
		}
	}
	
	
// Sorting by vowels
	
	// Uses isVowel method to return the amount of vowels in a word
	public static int vowelCount(String word) {
		int count = 0;
		for(int i = 0; i < word.length(); i++) {
			if(isVowel(word.charAt(i))) {
				count++;
			}
		}
		return count;
	}

	// Sorts by vowels
	public static String[] sortByVowels(String[] words) {
		boolean swap;
		String[] vowelSort = Arrays.copyOf(words, words.length); // Creates a copy of the words array
		
		for(int i = 0; i < vowelSort.length; i++) {
			swap = false;
			for(int ii = 0; ii < vowelSort.length - 1; ii++) {
				if(vowelCount(vowelSort[ii]) > vowelCount(vowelSort[ii + 1])) {
					String temp = vowelSort[ii];
					vowelSort[ii] = vowelSort[ii + 1];
					vowelSort[ii + 1] = temp;
					swap = true;
				}
			}
			if(!swap) {break;}
		}
		return vowelSort;
	}

	
	
	// Sorting by consonants
	
	// Uses isVowel to find the number of consonants in a word
	public static int consCount(String word) {
		int count = 0;
		for(int i = 0; i < word.length(); i++) {
			if(!isVowel(word.charAt(i))) {
				count++;
			}
		}
		return count;
	}
		
	public static String[] sortByConsonants(String[] words) {
		boolean swap;
		String[] consSort = Arrays.copyOf(words, words.length);
		
		for(int i = 0; i < consSort.length; i++) {
			swap = false;
			for(int ii = 0; ii < consSort.length - 1; ii++) {
				if(consCount(consSort[ii]) > consCount(consSort[ii + 1])) {
					String temp = consSort[ii];
					consSort[ii] = consSort[ii + 1];
					consSort[ii + 1] = temp;
					swap = true;
				}
			}
			if(!swap) {break;}
		}
		return consSort;
	}

	
	
	// Sorting by length
	public static String[] sortByLength(String[] words) {
		boolean swap;
		String[] lenSort = Arrays.copyOf(words, words.length);
		
		for(int i = 0; i < lenSort.length; i++) {
			swap = false;
			for(int ii = 0; ii < lenSort.length - 1; ii++) {
				if(lenSort[ii].length() > lenSort[ii + 1].length()) { // simply uses the length of a word to sort
					String temp = lenSort[ii];
					lenSort[ii] = lenSort[ii + 1];
					lenSort[ii + 1] = temp;
					swap = true;
				}
			}
			if(!swap) {break;}
		}
		return lenSort;
	}
}
