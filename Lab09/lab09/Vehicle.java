// Copyright Alex Chandarana
import java.util.ArrayList;
class Vehicle {
	private ArrayList<Part> parts;
	private String make;
	private String model;
	private int doors;

	Vehicle(String make, String model, int doors) {
		this.parts = new ArrayList<>();
		this.make = make;
		this.model = model;
		this.doors = doors;
	}

	void addPart(Part addMe) {
		parts.add(addMe);
	}

	public String toString() {
		String fDoors = doors + "-door " + make + " " + model + "\nPart List:";
		String partList = ""; // Broke string up into pieces to make it more readable
		for (int i = 0; i < parts.size(); ++i) {
			partList = partList + "\n " + parts.get(i);
		}
		return fDoors + partList;
	}
}