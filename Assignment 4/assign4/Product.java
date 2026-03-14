// Alex Chandarana Copyright 2024
public class Product { // Class taken from Assignment 3
	
	private String id;
	private String name;
	private double price;
	
	Product(int id, String name, double price) {
		
		this.id = String.format("%010d", id);
		this.name = name;
		this.price = price;
	}

	int id() {
		return Integer.parseInt(id);
	}

	String name() {
		return name;
	}

	double price() {
		return price;
	}
	
	public String toString() {
		if (name.contains(" ")) {
			return id + ", " + "\"" + name + "\"" + ", $" + String.format("%.2f", price);
		}
		return id + ", " + name + ", $" + String.format("%.2f", price);
	}

	boolean equals(Product rhs) {
		if (this.id() == rhs.id()) {
			return true;
		}
		return false;
	}
}