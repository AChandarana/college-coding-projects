import java.util.Arrays;
import java.util.Scanner;

public class Dialogue {
	
	public static void main(String[] args) { // This class is the driver, and is responsible for errors and a lot of the UI, but mostly just calls other methods
		while(true) { // While loop makes sure the program doesn't end unless the user wants it to
			Double[] result = null, Vectors = null;
			double magResult = 0.0;
			int size = 0;
			Scanner keyboard = new Scanner(System.in);
			String opp = "";
			while(!opp.equals("ADD") && !opp.equals("SUB") && !opp.equals("MAG") && !opp.equals("QUIT")) {
				System.out.print("If you would like to add two vectors, enter ADD\n"
						+ "If you would like to subtract two vectors, enter SUB \n"
						+ "If you would like to find the magnitude of a vector, enter MAG\n"
						+ "If you would ike to quit, enter QUIT\n");
				opp = keyboard.next();
				if(opp.equals("QUIT")) {
					System.out.print("Goodbye!");
					System.exit(0);
				} else if(!opp.equals("ADD") && !opp.equals("SUB") && !opp.equals("MAG")) { // Error for not entering a valid operation
					System.out.println("Error; You must enter: ADD, SUB, MAG, or QUIT. Try again.");
				}
				System.out.print("What would you like the size of the vector(s) to be?\n");
			}
			while(size < 1) {
				if(keyboard.hasNextInt()) {
					size = keyboard.nextInt();
					} else {
						System.out.println("Error; Size of the vector must be an integer."); // Error for if vector size isn't an integer
						keyboard.next();
						}
				if(size < 1) {
					System.out.println("Error; the size of the vector(s) must be at least 1. Try again."); // Error for if vector size is less than 1
				}
			}
			if(opp.equals("ADD") || opp.equals("SUB")) {
				Vectors = Arrays.copyOf(VectorCreate.vectors(size, opp), size*2);
			} else if(opp.equals("MAG")) {
				Vectors = Arrays.copyOf(VectorCreate.vectors(size, opp), size);
			}
			if(opp.equals("ADD")) {
				result = Operations.addition(Vectors);
			}
			if(opp.equals("SUB")) {
				result = Operations.subtraction(Vectors);
			} 
			if(opp.equals("MAG")) {
				magResult = Operations.magnitude(Vectors);
			}
			System.out.print(VectorCreate.oppToString(Vectors, opp, result, magResult));
		}
	}
}
