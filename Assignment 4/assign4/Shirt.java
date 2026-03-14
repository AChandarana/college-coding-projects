// Copyright Alex Chandarana 2024
public class Shirt extends Clothing {

	enum Sleeves {
		Short, Half, Long
	}

	private Sleeves sleeve;
	
	public Shirt(int id, String name, double price, Size size, String material, Shirt.Sleeves sleeve) {
		super(id, name, price, size, material);
		this.sleeve = sleeve;
	}

	public String toString() {
		return sleeve + "-Sleeved Shirt: " + super.toString();
	}	
}
