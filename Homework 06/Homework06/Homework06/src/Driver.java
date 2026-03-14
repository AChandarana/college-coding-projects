// Copyright 2025 Alex Chandarana

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		LinkedBST<Shape> tree = new LinkedBST<Shape>();
		System.out.println("Welcome to Geometree! (Get it?)\nWhat would you like to do?\n");
		options(args, tree);
	}
	
	private static void read(LinkedBST<Shape> tree) {
		System.out.print("\nEnter a file name: ");
		File file = new File(keyboard.nextLine());
		Scanner reader = null;
		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.print("File not found, try again.");
			read(tree);
		}
		if (reader == null)
			return;
		while (reader.hasNextLine()) {
			String[] splitLine = reader.nextLine().split("\t");
			if (splitLine.length < 2 || splitLine.length > 3)
				continue;
			try {
				Shape shape = null;
				if (splitLine.length == 2) {
					shape = new Shape(Double.parseDouble(splitLine[1]));
				} else if (splitLine[0].equalsIgnoreCase("rectangle")) {
					shape = new Shape(Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]), false);
				} else if (splitLine[0].equalsIgnoreCase("Right Triangle")) {
					shape = new Shape(Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]), true);
				}
				tree.add(shape);
			} catch (IllegalArgumentException e) {
			}
		}
	}
	
	// For prevention of input mismatch errors
	private static double getDouble() {
		while (!keyboard.hasNextDouble()) {
			System.out.print("Invalid input, please enter a number: ");
			keyboard.next();
		}
		double value = keyboard.nextDouble();
		keyboard.nextLine();
		return value;
	}
	
	private static void options(String[] args, LinkedBST<Shape> tree) {
		System.out.println("To read shapes from a file, type \"READ\"\n"
				+ "To add a shape through the console, type \"ADD\"\n"
				+ "To remove a shape, type \"REMOVE\"\n"
				+ "To search for a shape, type \"SEARCH\"\n"
				+ "To find the shape with the greatest area, type \"BIG\"\n"
				+ "To find all shapes with a larger area than you specify, type \"BIGGER\"\n"
				+ "To remove all shapes with a larger area than you specify, type \"NOBIG\"\n"
				+ "To print the data in the Geometree, type \"PRINT\"\n"
				+ "To write the tree to a file, type \"WRITE\"\n"
				+ "To start from scratch, type \"RESTART\"\n"
				+ "To quit the program, type \"QUIT\"\n");
		String response = keyboard.nextLine();
		
		// Method for every function
		if (response.equalsIgnoreCase("read"))
			read(tree);
		if (response.equalsIgnoreCase("add"))
			addShape(tree);
		if (response.equalsIgnoreCase("remove"))
			removeShape(tree);
		if (response.equalsIgnoreCase("search"))
			searchShape(tree);
		if (response.equalsIgnoreCase("big"))
			findGreatestArea(tree);
		if (response.equalsIgnoreCase("bigger"))
			findGreaterAreas(tree);
		if (response.equalsIgnoreCase("nobig"))
			removeGreatestAreas(tree);
		if (response.equalsIgnoreCase("print"))
			printShapes(tree);
		if (response.equalsIgnoreCase("write"))
			writeTree(tree);
		if (response.equalsIgnoreCase("restart"))
			main(args);
		if (response.equalsIgnoreCase("quit")) {
			System.out.println("Goodbye!");
			return;
		}
		System.out.print("\n");
		options(args, tree);
	}
	
	private static void printShapes(LinkedBST<Shape> tree) {
		System.out.println("How would you like the shapes to be printed?\n"
				+ "For pre-order, type \"PRE\"\n"
				+ "For in-order, type \"IN\"\n"
				+ "for post-order, type \"POST\"");
		String response = keyboard.nextLine();
		System.out.print("\n");
		if (response.equalsIgnoreCase("pre"))
			tree.printPreorder();
		else if (response.equalsIgnoreCase("in"))
			tree.printInorder();
		else if (response.equalsIgnoreCase("post"))
			tree.printPostorder();
		else {
			System.out.println("Please enter valid option, try again");
			printShapes(tree);
		}
	}
	
	private static void removeGreatestAreas(LinkedBST<Shape> tree) {
		System.out.print("\nEnter your target area: ");
		double target = getDouble();
		
		// Creates new shape with the target area as the shape's area
		tree.removeAllGreaterThan(new Shape(1, target, false));
	}

	
	private static void findGreaterAreas(LinkedBST<Shape> tree) {
		System.out.print("\nEnter your target area: ");
		double target = keyboard.nextDouble();
		keyboard.nextLine();
		tree.printAllGreaterThan(new Shape(1, target, false));
	}
	
	private static void findGreatestArea(LinkedBST<Shape> tree) {
		tree.findMaxInTree();
	}
	
	private static void searchShape(LinkedBST<Shape> tree) {
		Shape newShape = null;
		System.out.println("\nWhat type of shape would you like to find?\n"
				+ "For right triange, type \"TRI\"\n"
				+ "For circle, type \"CIR\"\n"
				+ "For rectangle, type \"REC\"");
		String response = keyboard.nextLine();
		if (response.equalsIgnoreCase("TRI")) {
			System.out.println("What would you like the base of the triangle to be?");
			double base = getDouble();
			System.out.println("What would you like the height of the triangle to be?");
			double height = getDouble();
			newShape = new Shape(base, height, true);
		}
		if (response.equalsIgnoreCase("REC")) {
			System.out.println("What would you like the length of the rectangle to be?");
			double length = getDouble();
			System.out.println("What would you like the width of the rectangle to be?");
			double width = getDouble();
			newShape = new Shape(length, width, false);
		}
		if (response.equalsIgnoreCase("CIR")) {
			System.out.println("What would you like the radius of the circle to be?");
			double radius = getDouble();
			newShape = new Shape(radius);
		}
		if (tree.search(newShape))
			System.out.println("\nYour shape does exist.\n");
		else
			System.out.print("\nYour shape does not exist.\n");
	}
	
	private static void removeShape(LinkedBST<Shape> tree) {
		Shape newShape = null;
		System.out.println("\nWhat type of shape would you like to remove?\n"
				+ "For right triange, type \"TRI\"\n"
				+ "For circle, type \"CIR\"\n"
				+ "For rectangle, type \"REC\"");
		String response = keyboard.nextLine();
		if (response.equalsIgnoreCase("TRI")) {
			System.out.println("What would you like the base of the triangle to be?");
			double base = getDouble();
			System.out.println("What would you like the height of the triangle to be?");
			double height = getDouble();
			newShape = new Shape(base, height, true);
		}
		if (response.equalsIgnoreCase("REC")) {
			System.out.println("What would you like the length of the rectangle to be?");
			double length = getDouble();
			System.out.println("What would you like the width of the rectangle to be?");
			double width = getDouble();
			newShape = new Shape(length, width, false);
		}
		if (response.equalsIgnoreCase("CIR")) {
			System.out.println("What would you like the radius of the circle to be?");
			double radius = getDouble();
			newShape = new Shape(radius);
		}
		tree.remove(newShape);
		System.out.println("Removed.");
	}

	private static void addShape(LinkedBST<Shape> tree) {
		Shape newShape = null;
		System.out.println("\nWhat type of shape would you like to add?\n"
				+ "For right triange, type \"TRI\"\n"
				+ "For circle, type \"CIR\"\n"
				+ "For rectangle, type \"REC\"");
		String response = keyboard.nextLine();
		if (response.equalsIgnoreCase("TRI")) {
			System.out.println("What would you like the base of the triangle to be?");
			double base = getDouble();
			System.out.println("What would you like the height of the triangle to be?");
			double height = getDouble();
			newShape = new Shape(base, height, true);
		}
		if (response.equalsIgnoreCase("REC")) {
			System.out.println("What would you like the length of the rectangle to be?");
			double length = getDouble();
			System.out.println("What would you like the width of the rectangle to be?");
			double width = getDouble();
			newShape = new Shape(length, width, false);
		}
		if (response.equalsIgnoreCase("CIR")) {
			System.out.println("What would you like the radius of the circle to be?");
			double radius = getDouble();
			newShape = new Shape(radius);
		}
		tree.add(newShape);
		System.out.println("Added.");
	}

	private static void writeTree(LinkedBST<Shape> tree) {
		System.out.print("\nEnter the file name to write the tree: ");
		String filename = keyboard.nextLine();
		tree.writePreorder(filename);
		System.out.println("Tree written to " + filename + ".");
	}
}
