// Copyright 2025 Alex Chandarana

public class Fruit implements Comparable<Fruit> {
	
	// Used ENUM for fruit types
	public enum fruitType {
		Apple,
		Orange,
		Banana,
		Kiwi,
		Tomato;
	}
	
	private fruitType kind;
	private double weight;
	
	public Fruit(fruitType kind, double weight) {
		this.kind = kind;
		if (weight <= 0) weight = 1;
		this.weight = weight;
	}
	
	public Fruit(fruitType kind) {
		this.kind = kind;
		this.weight = 1;
	}
	
	public Fruit(double weight) {
		if (weight <= 0) weight = 1;
		this.weight = weight;
		this.kind = Fruit.fruitType.Apple;
	}
	
	public void setKind(fruitType kind) {
		this.kind = kind;
	}
	
	public void setWeight(double weight) {
		if (weight <= 0) return;
		this.weight = weight;
	}
	
	public fruitType getKind() {
		return this.kind;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public String toString() {
		return "Type: " + this.kind + "\tWeight: " + this.weight;
	}
	
	public int compareTo(Fruit aFruit) {
		if (aFruit == null) {
			return -1;
		}
		if (aFruit.weight > this.weight) return -2;
		if (aFruit.weight < this.weight) return 2;
		
		// Compares the strings
		return this.kind.toString().compareTo(aFruit.kind.toString());
	}

}
