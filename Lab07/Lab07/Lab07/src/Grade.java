// Alex Chandarana Copyright 2024

class Grade {
	private double score;
	private double total;
	
	public Grade(double score) {
		this.total = 100; 
		this.score = score;
	} // Builds Grade assuming 100 points possible

	public Grade(double score, double possible) {
		this.total = possible;
		this.score = score;
	}

	
	public String percent() {
		double Scored = score/total;
		Scored = Math.round(Scored * 100.0);
		return Scored + "%"; // returns rounded value with %
	}

	public char letter() {
		if (score/total * 100 >= 89.455) { // hard coded in rounding
			return 'A';
		}
		
		if (score/total * 100 >= 79.455) {
			return 'B';
		}
		
		if (score/total * 100 >= 69.455) {
			return 'C';
		}
		
		if (score/total * 100 >= 59.455) {
			return 'D';
		}
		
		return 'F';
	}

	public double score() {
		return this.score;
	}

	public double total() {
		return this.total;
	}

}