// Copyright 2024 Alex Chandarana

import java.util.Arrays;

public class Operations { // This class is responsible for the main operations
	
	public static Double[] addition(Double[] vectors) {
		int size = vectors.length;
		Double[] added = Arrays.copyOf(vectors, size);
		for(int i = 0; i < size/2; i++) {
			added[i] = vectors[i] + vectors[i + (size/2)];
		}
		return added;
	}

	public static Double[] subtraction(Double[] vectors) {
		int size = vectors.length;
		Double[] subtracted = Arrays.copyOf(vectors, size);
		for(int i = 0; i < size/2; i++) {
			subtracted[i] = vectors[i] - vectors[i + (size/2)];
		}
		return subtracted;
	}
	
	public static double magnitude(Double[] vector) {
		int size = vector.length;
		double mag = 0.0;
		for(int i = 0; i < size; i++) {
			mag += (vector[i])*(vector[i]);
		}
		return Math.sqrt(mag);
	}

}
