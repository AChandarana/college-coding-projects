// Copyright Alex Chandarana
class Tire extends PartGroup {
	
	enum Type {
		P, LT, ST
	}

	enum Construction {
		R, D
	}

	enum SpeedRating {
		M,
		N,
		P,
		Q,
		R,
		S,
		H
	}
	private Tire.Type type;
	private int width;
	private int aspectRatio;
	private int diameter;
	private int loadIndex;
	private Tire.Construction construction;
	private Tire.SpeedRating speed;

	Tire(int id, String partNo, double price, int count, Type type, int width,
		 int aspectRatio, Construction construction, int diameter, int loadIndex ,SpeedRating speed) {
		
		super(id, partNo, price, count);
		this.type = type;
		this.width = width;
		this.aspectRatio = aspectRatio;
		this.construction = construction;
		this.diameter = diameter;
		this.loadIndex = loadIndex;
		this.speed = speed;
	}

	public String toString() { // Copied most of this code from lab08
		String Tire = type + " " + width + "/" + aspectRatio + " " + 
					  construction + " " + diameter + " " + 
					  loadIndex + " " + speed;
		return super.toString() + ", " + Tire;
	}

}