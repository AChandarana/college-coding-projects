// Copyright 2025 Alex Chandarana

public class Sheep implements Comparable<Sheep> {
	
	String name;
	int shearTime;
	int arrivalTime;
	
	public Sheep(String name, int shearTime, int arrivalTime) {
		this.name = name;
		this.shearTime = shearTime;
		this.arrivalTime = arrivalTime;
	}
	
	public String toString() {
		return "Name: " + this.name + ", Shear Time: " + this.shearTime + ", Arrival Time: " + this.arrivalTime;
	}

	public int compareTo(Sheep o) {
		if (this.shearTime != o.shearTime) return this.shearTime - o.shearTime; // Easier to understand int comparison
			return this.name.compareTo(o.name); // Compares Strings
	}
	
	// Accessors
	public String getName() {
		return this.name;
	}
	public int getShearTime() {
		return this.shearTime;
	}
	public int getArrivalTime() {
		return this.arrivalTime;
	}
}
