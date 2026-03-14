// Copyright 2024 Alex Chandarana

import java.util.Scanner;
public class VectorCreate { // This class is responsible for creating the vectors and the toString method
	public static Double[] vectors(int vecSize, String opp) {
		Double[] vector = new Double[vecSize*2];
		Scanner keyboard = new Scanner(System.in);
		if(opp.equals("MAG")) {
			System.out.print("Enter " + vecSize + " value(s) for the vector\n");
			for(int i = 0; i < vecSize; i++) {
				vector[i] = keyboard.nextDouble();
			}
			return vector;
		}
		System.out.print("Enter " + vecSize + " value(s) for the first vector\n");
		for(int i = 0; i < vecSize; i++) {
			vector[i] = keyboard.nextDouble();
		}
		System.out.print("Enter " + vecSize + " value(s) for the second vector\n");
		for(int i = vecSize; i < vecSize*2; i++) {
			vector[i] = keyboard.nextDouble();
		}
		return vector;
	}
	
	public static String oppToString(Double[] vecs, String opp, Double[] result, double magResult) {
		String oppStatement = "(";
		String resultString = "";
		String sign = "";
		if(opp.equals("ADD")) {
			sign = "PLUS";
		} 
		if(opp.equals("SUB")) {
			sign = "MINUS";
		}
		if(opp.equals("MAG")) {
			oppStatement = "(";
			for(int i = 0; i < vecs.length; i++) {
				oppStatement += " " + vecs[i] + " ";
			}
			oppStatement += ")";
			return "The magnitude of " + oppStatement + " is:\n" + magResult + "\n\n"; 
		}
		for(int i = 0; i < vecs.length/2; i++) {
			resultString += " " + result[i] + " ";
		}
		for(int i = 0; i < vecs.length; i++) {
			if(i == vecs.length/2) {
				oppStatement += ")\n" + sign + "\n(";
			}
			oppStatement += " " + vecs[i] + " ";
		}
		oppStatement += ")\nEQUALS\n(" + resultString + ")\n\n";
		return oppStatement;
	}
}