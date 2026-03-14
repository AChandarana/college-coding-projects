// Copyright Alex Chandarana
enum EngineLayout {
	 Inline, Flat, V;
}

enum ConfigurationType {
	Twin, Four, Six, Eight;
}

enum FuelType {
	Petrol, Diesel, Alternative;
}

class Engine {
	
	private double displacement;
	private EngineLayout layout;
	private ConfigurationType configuration;
	private FuelType fuel;

	public Engine(double displacement, 
			EngineLayout layout, ConfigurationType configuration, FuelType fuel) {
		this.displacement = displacement;
		this.layout = layout;
		this.configuration = configuration;
		this.fuel = fuel;
	}

	public String toString() {
		String Dis = displacement + "L ";
		String Config = layout + " " + configuration;
		if (this.layout == EngineLayout.V) {
			if (configuration == ConfigurationType.Four) {
				Config = "Four cylinder";
			}
			else if (configuration == ConfigurationType.Six) {
				Config = "Six cylinder";
			}
			else if (configuration == ConfigurationType.Eight) {
				Config = "V8";
			}
			else if (configuration == ConfigurationType.Twin) {
				Config = "V Twin";
			}
		}
		String ful = "";
		
		// this is for formatting the fuel correctly. Fuel types are originally capitalized, but need to be all lowercase.
		if (fuel != FuelType.Petrol) {
			ful = " (" + fuel + ")";
		}
		if (ful.equals(" (Diesel)")) {
			ful = " (diesel)";
		}
		if (ful.equals("(Alternative)")) {
			ful = "alternative";
		}
		
		return Dis + Config + ful;
	}
}