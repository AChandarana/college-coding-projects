// Copyright Alex Chandarana 2024
public class Fruit extends Food{

	private int unit;

	public Fruit(int id, String name, double price, double volume, int unit) {
		super(id, name, price, (volume));
		this.unit = unit;
	}
	
	public String toString() {
		return "Fruit: " + super.toString() + " count: " + unit;
	}
}
