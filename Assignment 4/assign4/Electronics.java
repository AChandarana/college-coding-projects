// Copyright Alex Chandarana 2024
public class Electronics extends Product{

	private int warrantyPeriod;
	private boolean isBattery;

	public Electronics(int id, String name, double price, int warrantyPeriod, boolean isBattery) {
		super (id, name, price);
		this.warrantyPeriod = warrantyPeriod;
		this.isBattery = isBattery;
	}
	
	public String toString() {
		String bat = "No";
		if (isBattery) {
			bat = "Yes";
		}

		return super.toString() + ", Warranty: " + warrantyPeriod + " months, Battery: " + bat;
	}
}
