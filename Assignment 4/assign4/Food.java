// Copyright Alex Chandarana 2024
public class Food extends Product {

	private double volume;

	public Food(int id, String name, double price, double volume) {
		super (id, name, price);
		this.volume = volume;
	}

	public String toString() {
		return super.toString() + ", Total: $" + String.format("%.2f", (volume*price()));
	}
}
