// Copyright Alex Chandarana
class Part {
	
	private int id;
	private String partNo;
	private double price;

	Part(int id, String partNo, double price) {
		this.id = id;
		this.partNo = partNo;
		this.price = price;
	}

	int id() {
		return id;
	}

	String partNo() {
		return partNo;
	}

	double price() {
		return price;
	}

	boolean equals(Part rhs) { // I don't think this is ever tested?
		if(id == rhs.id) {
			return true;
		}
		return false;
	}

	public String toString() {
		String fId;
		String fPrice; // Breaks string up into smaller pieces that are more readable
		fId = String.format("%010d", id);
		fPrice = "$" + String.format("%.2f", price);
		return fId + ", " + partNo + ", " + fPrice;
	}
}