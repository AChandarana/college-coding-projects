// Copyright 2025 Alex Chandarana
import java.util.Scanner;
public class SortSort {
	static GenLL<String> list = new GenLL();
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		GenLL<String> list = new GenLL();
		System.out.println("Welcome to SORT SORT!"
				+ "\nTo begin, enter some strings! When you're done, type \"DONE.\"\n");
		String done = "";
		while(true) {
			done = keyboard.nextLine();
			if(done.equals("DONE.")) {
				break;
			} 
			list.add(done);
		}
		list.reset();
		String[] stringList = new String[list.getSize()];
		for(int i=0; i < list.getSize(); i++) {
			stringList[i] = list.getData();
			list.gotoNext();
		}
		
		int[] countedList = new int[list.getSize()];
		for(int i=0; i < list.getSize(); i++) {
			countedList[i] = Counter.countSorts(stringList[i]);
		}
		
		Counter.mergeSort(countedList, stringList);
		System.out.println("\nSORTED:");
		for(int i=0; i<list.getSize(); i++) {
			System.out.println(stringList[i]);
		}
		again(args);
	}
	
	private static void again(String[] args) {
		System.out.println("\nSort some more strings? (\"Y\" for yes, \"N\" for no)");
		String again = keyboard.nextLine();
		if(again.equalsIgnoreCase("y")) {
			main(args); // run main method if user wants to do it again.
		} else if(again.equalsIgnoreCase("n")) {
			System.out.print("Goodbye!");
		} else {
			again(args);
		}
	}

}
