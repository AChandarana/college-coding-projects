// Copyright Alex Chandarana
class Vehicle {
	private String make;
	private String model;
	private int doors;
	private Tire tire;
	private int tireCount;
	private Engine engine;
	
	public Vehicle(String make, String model, int doors, Tire tire, int tireCount, Engine engine) {
		this.make = make;
		this.model = model;
		this.doors = doors;
		this.tire = tire;
		this.tireCount = tireCount;
		this.engine = engine;

	}
	
	// to make it more readable, I broke the parts into larger car parts, and then simply added the three parts together.
	public String toString() {
		String makeModel = make + " " + model + ", ";
		String door = doors + "-door ";
		String tires = "Tires: " + tire + " x " + tireCount + ", ";
		String Engine = "Engine: " + engine;
		return door + makeModel + tires + Engine;
	}
}
