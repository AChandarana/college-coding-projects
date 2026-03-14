// Copyright Alex Chandarana 2024
public class Furniture extends Product {

	enum Material {
		Metal, Plastic, Wood, Fabric, Leather, Other
	}
	
	enum Location {
		LivingRoom, DiningRoom, Bathroom, Bedroom, OtherRoom // added some other rooms just in case
	}

	private String dim;
	private double weight;
	private Material material;
	private Location location;
	
	public Furniture(int id, String name, double price, String dim, double weight, Material material, Location location) {
		super(id, name, price);
		this.dim = dim;
		this.weight = weight;
		this.material = material;
		this.location = location;
	}

	public String toString() {
		return super.toString() + ", Dimensions: " + dim + ", Weight: " + String.format("%.2f", weight) + " kg, Material: " + material
		 + ", Location: " + location;
	}
}
