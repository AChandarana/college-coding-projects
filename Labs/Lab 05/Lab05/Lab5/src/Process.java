// Copyright 2025 Alex Chandarana
public class Process {

	private String name;
	private double compTime;

	// Constucters for Proccess
	public Process(String name, double time) {
		this.name = name;
		this.compTime = time;
	}
	public Process() {
		this.name = "none";
		this.compTime = 0;
	}
	public Process(String name) {
		this.name = name;
		this.compTime = 0;
	}
	public Process(double time) {
		this.compTime = time;
		this.name = "none";
	}
	
	public String getName() {
		if (this.name == null) return "none"; // Checks for valid outputs
		return this.name;
	}
	
	public void setName(String n) {
		if (n == null) return;
		this.name = n;
	}
	
	public void setCompletionTime(Double t) {
		if (this.compTime < 0) this.compTime = 0; // Prevents negative time
		this.compTime = t;
	}
	
	public double getCompletionTime() {
		if (this.compTime < 0) return 0;
		return this.compTime;
	}
	
	public String toString() {
		return "Process Name: " + getName() + " Completion Time: " + getCompletionTime();
	}
}
