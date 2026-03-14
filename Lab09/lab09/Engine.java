// Copyright Alex Chandarana
class Engine extends UniquePart {
	
	enum Layout{
		Inline, Flat, V
	}

	enum Configuration {
		Twin, Four, Six, Eight
	}

	enum Fuel {
		Petrol, Diesel, Alternative
	}
	private double displacement;
	private Engine.Layout layout;
	private Engine.Configuration configuration;
	private Engine.Fuel fuel;

	public Engine(int id, String partNo, double price, String uuid,
				  double displacement, Layout layout, Configuration configuration, Fuel fuel) {
		
		super(id, partNo, price, uuid);
		this.displacement = displacement;
		this.layout = layout;
		this.configuration = configuration;
		this.fuel = fuel;
	}

	public String toString() { // Copied a lot of this code from lab08
		String Dis = displacement + "L ";
		String Config = layout + " " + configuration;
		if (this.layout == Layout.V) {
			if (configuration == Configuration.Four) {
				Config = "Four cylinder";
			}
			else if (configuration == Configuration.Six) {
				Config = "Six cylinder";
			}
			else if (configuration == Configuration.Eight) {
				Config = "V8";
			}
			else if (configuration == Configuration.Twin) {
				Config = "V Twin";
			}
		}
		String ful = "";
		
		if (fuel != Fuel.Petrol) {
			ful = " (" + fuel + ")";
		}
		if (ful.equals(" (Diesel)")) {
			ful = " (diesel)";
		}
		if (ful.equals(" (Alternative)")) {
			ful = " (alternative)";
		}
		
		return super.toString() + ", " + Dis + Config + ful;
	}
}