// Copyright Alex Chandarana
enum TireType {
	P,
	LT,
	ST;
}
	
enum ConstructionType {
	R,
	D;
}

enum SpeedRating {
	M, N, P, Q, R, S, H;
}
// enums define what inputs are expected


class Tire {

	// these are the identifiers
private TireType type;
private int width;
private int aspectRatio;
private ConstructionType construction;
private int diameter;
private int loadIndex;
private SpeedRating speed;

public Tire(TireType tire, 
			int width, int aspectRatio, 
			ConstructionType construction, 
			int diameter, int loadIndex, SpeedRating speed) {
	
	this.type = tire;
	this.width = width;
	this.aspectRatio = aspectRatio;
	this.construction = construction;
	this.diameter = diameter;
	this.loadIndex = loadIndex;
	this.speed = speed;
		
	}

// this method puts everything together seperated by a space.
	public String toString() {
		String Tire = this.type + " " + this.width + "/" + this.aspectRatio + " " + this.construction + " " + this.diameter + " " + this.loadIndex + " " + this.speed;
		return Tire;
	}

}
