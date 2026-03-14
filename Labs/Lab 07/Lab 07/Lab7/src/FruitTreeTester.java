// Copyright 2025 Alex Chandarana
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FruitTreeTester {
	static LinkedBST<Fruit> tree = new LinkedBST<Fruit>();
	
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter Fruit File: ");
		String filename = keyboard.nextLine();
		File fruits = new File(filename);
		System.out.println("Populating tree");
		try {
			Scanner reader = new Scanner(fruits);
			readFile(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			main(args); // Tries again for different filename
		}
		System.out.println("\nIn Order Traversal:");
		tree.printInorder();
		
		System.out.println("\nPre Order Traversal:");
		tree.printPreorder();
		
		Fruit testFruit = new Fruit (Fruit.fruitType.Kiwi, 4.969338821021524); // Fruit to be removed
		tree.add(testFruit);
		
		System.out.println("\nPost Order Traversal:");
		tree.printPostorder();

		if(tree.search(testFruit)) {
			System.out.println("\"KIWI\" does exist.");
		} else System.out.println("\"KIWI\" does not exist.");
		
		System.out.println("Removing \"KIWI\"\n");
		tree.remove(testFruit);
		
		System.out.println("Printing In Order Again to Demonstrate Removal:");
		tree.printInorder();
		
		if(tree.search(testFruit)) {
			System.out.println("\"KIWI\" does exist.");
		} else System.out.println("\n\"KIWI\" does not exist.");
	}

	private static void readFile(Scanner reader) {
		while (reader.hasNextLine()) {
			String[] splitLine = reader.nextLine().split("\t");
			if (splitLine.length != 2) continue;
			// Immediate check for common invalid line
			try {
				Fruit.fruitType type = Fruit.fruitType.valueOf(splitLine[0]);
				double weight = Double.parseDouble(splitLine[1]);
				Fruit fruit = new Fruit(type, weight);
				tree.add(fruit);
			} catch (IllegalArgumentException e) {
				
				// Invalid line
				System.out.println(splitLine[0] + "\t" + splitLine[1] + "was not added.");
			}
		}
	}
	
}
 // fruitFile.txt