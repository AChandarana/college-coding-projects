// Alex Chandarana Copyright 2024

public class Util {
	
	public static double EPSILON = 0.00001;
	
	public static String percentDifference(double lhs, double rhs) {
		if (Math.abs(rhs) == Math.abs(lhs)) {return "200.00%";}
		double diff = ((Math.abs(rhs-lhs)/((lhs+rhs)/2))) * 100;
		diff = Math.round(diff * 100.0) / 100.0;
		String diffS = diff + "%";
		return diffS;
	}

	public static boolean fpEquals(double lhs, double rhs) {
		if (Math.abs(rhs) == Math.abs(lhs)) {return false;}
		double diff = ((Math.abs(rhs-lhs)/((lhs+rhs)/2))) * 100;
		if (diff <= EPSILON) {
			return true;
		}
		return false;
	}

	public static boolean fpLessThanEqual(double lhs, double rhs) {
		if (lhs < rhs){
			return true;
		}
		if (Math.abs(rhs) == Math.abs(lhs)) {return false;} // protects against /0 errors
		double diff = ((Math.abs(rhs-lhs)/((lhs+rhs)/2))) * 100; // percent difference formula
		if (diff <= EPSILON) {
			return true;
		}
		return false;
	}

	public static boolean fpGreaterThanEqual(double lhs, double rhs) {
		if (lhs > rhs){
			return true;
		}
		if (Math.abs(rhs) == Math.abs(lhs)) {return false;}
		double diff = ((Math.abs(rhs-lhs)/((lhs+rhs)/2))) * 100;
		if (diff <= EPSILON) {
			return true;
		}
		return false;
	}
}