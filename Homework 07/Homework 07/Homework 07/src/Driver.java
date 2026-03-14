// Copyright 2025 Alex Chandarana

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		MinHeap<Sheep> heap = new MinHeap<Sheep>();
		System.out.print("Enter a file name: ");
		String filename = keyboard.nextLine();
		Sheep[] sheepList = new Sheep[heap.SIZE];
		int totalSheep = 0;
		
		// interpreting file
		try {
			Scanner reader = new Scanner(new File(filename));
			while (reader.hasNextLine()) {
				String[] splitLine = reader.nextLine().split("\t");
				if (splitLine.length != 3) continue;
				try {
					String name = splitLine[0];
					int shearTime = Integer.parseInt(splitLine[1]);
					int arrivalTime = Integer.parseInt(splitLine[2]);
					sheepList[totalSheep] = new Sheep(name, shearTime, arrivalTime);
					totalSheep++;
				} catch (NumberFormatException e) {
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found, try again.");
			main(args);
		}
		
		
		// Initializing simulation variables
		int time = 0, finish = 0;
		Sheep current = null;
		
		while (true) {
			
			for (int i = 0; i < totalSheep; i++) {
				// if the arrival time matches the current time
				if (sheepList[i] != null && sheepList[i].arrivalTime <= time) {
					heap.add(sheepList[i]);
					sheepList[i] = null;
				}
			}
			
			// checks if there are null elements in the array
			if (heap.isEmpty() && current == null) {
				boolean done = true;
				for (int i = 0; i < totalSheep; i++) {
					if (sheepList[i] != null) {
						done = false;
						break;
					}
				}
				if (done) break;
				time++;
				continue;
			}
			
			current = heap.remove();
			System.out.println(current);
			time += current.getShearTime();
			current = null; // prevent from printing more than once
			
		}
		
		System.out.println("\nRun a new shedule? (Y/N)");
		String answer = keyboard.nextLine();
		if (answer.equalsIgnoreCase("Y")) {
			main(args);
		} else {
			System.out.println("Goodbye!");
		}
		
	}
}