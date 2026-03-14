// Copyright Alex Chandarana 2024
public class Clothing extends Product{

	enum Size {
		XXS, XS, S, M, L, XL, XXL
	}

	private int id;
	private String name;
	private double price;
	private Size size;
	private String material;

	public Clothing(int id, String name, double price, Size size, String material) {
		super (id, name, price);
		this.size = size;
		this.material = material;
	}
	
	public String toString() {
		return super.toString() + ", Size: " + size + ", Material: " + material;
	}
}
