// Copyright 2025 Alex Chandarana

public class Counter {
	
	public static int countSorts(String l) {
		int count = 0;
		String line = l.toLowerCase();
		for (int i=0; i < line.length()-3; i++) {
			if(line.charAt(i) == 's' && line.charAt(i+1) == 'o' && line.charAt(i+2) == 'r' && line.charAt(i+3) == 't') { // Checks if s, o, r, t are next to each other in that order.
				count++;
			}
		}
		return count;
	}
	
	public static void mergeSort(int[] counts, String[] strings) {
		int size = counts.length;
		if (size<2) return;
		int mid = size/2;
		int leftS = mid;
		int rightS = size-mid;
		int[] left = new int[leftS];
		String[] left2 = new String [leftS]; // left2 and right2 are for the array of strings. Merge sort sorts by the count, but does everything it does to count to the string array as well; effectively sorting the array of strings.
		int[] right = new int[rightS];
		String[] right2 = new String[rightS];
		
		// splits the arrays into smaller ones
		for(int i=0; i<mid; i++) {
			left[i] = counts[i];
			left2[i] = strings[i];
		}
		for(int i=mid; i<size; i++) {
			right[i-mid] = counts[i];
			right2[i-mid] = strings[i];
		}
		// Splits everything up again
		mergeSort(left, left2);
		mergeSort(right, right2);
		merge(left, right, counts, left2, right2, strings);
	}

	public static void merge(int[] left, int[] right, int[] counts, String[] left2, String[] right2, String[] strings) {
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<leftSize && j<rightSize) {
			if(left[i] <= right [j]) {
				counts[k] = left[i];
				strings[k] = left2[i];
				i++;
				k++;
			} else {
				counts[k] = right[j];
				strings[k] = right2[j];
				j++;
				k++;
			}
		}
		while(i<leftSize) {
			counts[k] = left[i];
			strings[k] = left2[i];
			i++;
			k++;
		}
		while(j<rightSize) {
			counts[k] = right[j];
			strings[k] = right2[j];
			j++;
			k++;
		}
	}
}
