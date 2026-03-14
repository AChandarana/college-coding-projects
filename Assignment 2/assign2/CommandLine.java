// Alex Chandarana Copyright 2024

import java.util.Scanner;


class CommandLine {
	static boolean addUse = false;
	static boolean gRoot = false;
	static boolean excl = false;
	static boolean filt = false;
	

	public static boolean DoAddUsername(String[] tokens) {
		
		for (int i = 0; i < tokens.length; ++i) {
			
			if (tokens[i].equals(USERNAME)) {
				addUse = true;
				return true;
			}
			
		}
		
		return false;
	}
	public static final String USERNAME = "-u";
	
	
	public static String GetRoot(String[] tokens) {
		
		for (int i = 0; i < tokens.length; ++i) {
			
			if (tokens[i].equals(ROOT)) {
				gRoot = true;
				return tokens[i+1];
			}
		}
		
		return null;
	}
	public static final String ROOT = "-r";
	
	
	public static String GetExcludeFiles(String[] tokens) {
	    String Exc = "";
	    
	    for (int i = 0; i < tokens.length; ++i) {
	        
	        if (tokens[i].equals(EXCLUDE)) {
	        	excl = true;
	            if (i + 1 < tokens.length && tokens[i+1].charAt(0) != '-') {
	                ++i;
	                Exc = tokens[i];
	                
	                while (i + 1 < tokens.length-2 && tokens[i+1].charAt(0) != '-') {
	                    Exc = Exc + ", " + tokens[i+1];
	                    ++i;
	                }
	            }
	        }
	    }
	    return Exc;
	}

	public static final String EXCLUDE = "-e";
	
	
	public static String GetFileFilters(String[] tokens) {
		String Fil = "";
		for (int i = 0; i < tokens.length-2; ++i) {
			if (tokens[i].equals(FILTER)) {
				filt = true;
				if (tokens[i+1].charAt(0) != '-') {
					++i;
					Fil = tokens[i];
					while (i + 1 < tokens.length - 2 && tokens[i+1].charAt(0) != '-') {
						Fil = Fil + ", " + tokens[i+1];
						++i;
					}
				}
			}
		}
		return Fil;
	}
	public static final String FILTER = "-f";
	
	
	public static String Parse(String[] tokens) {
		int count = 1;
		String com = "";
		
		if (addUse) {
			com += count + ". Create directory named author's (u)sername at target.\n";
			++count;
		}
		
		if (gRoot) {
			com += count + ". Include directory [" + GetRoot(tokens) + "] if the archive does not contain a (r)oot directory.\n";
			++count;
		}
		
		if (excl) {
			com += count + ". (e)xclude files {" + GetExcludeFiles(tokens) + "}\n";
			++count;
		}
		
		if (filt) {
			com += count + ". (f)ilter files not in {" + GetFileFilters(tokens) + "}\n";
			++count;
		}
		
		com += count + ". Extract (from) archive [" + tokens[tokens.length-2] + "] (to) directory [" + tokens[tokens.length-1] + "].";
		
		return com;
	}
	

	/**
	 * This functions as the tester for your code. Do not alter it or the following static class.
	 * 
	 * @param args Is unused
	 */
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		String[] tokens = CommandLineTest.TokenizeInput(stdin);
		
		int passed = CommandLineTest.Run(tokens, stdin);
		
		if (passed == CommandLineTest.TEST_COUNT)
			System.out.println("Excellent! All tests passed!");
		else
			System.out.println("\nPassed:" + passed + " of " + CommandLineTest.TEST_COUNT + " tests.");
		
		stdin.close();
	}
}


/**
 * Used to test the CommandLine class.
 */
class CommandLineTest {
	public static final int TEST_COUNT = 5;
	
	static String[] TokenizeInput(Scanner stdin) {
		String[] tokens = new String[stdin.nextInt()];
		
		for (int i = 0; i < tokens.length; ++i)
			tokens[i] = stdin.next();
		
		return tokens;
	}
	
	static int Run(String[] tokens, Scanner stdin) {
		// test DoAddUsername
		int passed = CommandLineTest.DoAddUsername(tokens, stdin) ? 1 : 0;
		
		// test GetRoot
		passed += CommandLineTest.GetRoot(tokens, stdin) ? 1 : 0;
		
		// test GetExcludeFiless
		passed += CommandLineTest.GetExcludeFiles(tokens, stdin) ? 1 : 0;
		
		// test GetFileFilters
		passed += CommandLineTest.GetFileFilters(tokens, stdin) ? 1 : 0;
		
		passed += CommandLineTest.Parse(tokens, stdin) ? 1 : 0;
		
		return passed;
	}

	static boolean DoAddUsername(String[] tokens, Scanner stdin) {	
		if (stdin.nextBoolean()) {
			if (CommandLine.DoAddUsername(tokens) != stdin.nextBoolean()) {
				System.out.println("DoAddUsername Expected: true, Actual: false.");
				return false;
			}
		} else {
			if (CommandLine.DoAddUsername(tokens)) {
				System.out.println("DoAddUsername Expected: false, Actual: true.");
				return false;
			}
		}
		
		return true;
	}
	

	static boolean GetRoot(String[] tokens, Scanner stdin) {
		String actualRoot = CommandLine.GetRoot(tokens);
		if (stdin.nextBoolean()) {
			String expectedRoot = stdin.next();
			if (!expectedRoot.equals(actualRoot)) {
				System.out.println("GetRoot Expected: " + expectedRoot + ", Actual: " + actualRoot);
				return false;
			}
		} else {
			if (actualRoot.length() > 0) {
				System.out.println("GetRoot Expected: empty string, Actual: \"" + actualRoot + "\"");
				return false;
			}
		}

		return true;
	}
	
	
	static boolean GetExcludeFiles(String[] tokens, Scanner stdin) {
		String actualExcludes = CommandLine.GetExcludeFiles(tokens);
		String expectedExcludes = "";
		
		if (stdin.nextBoolean()) {
			int size = stdin.nextInt();
			for (int i = 0; i < size; ++i) {
				expectedExcludes += stdin.next();
				if (i < size - 1)
					expectedExcludes += ", ";
			}
		}
		
		if (!expectedExcludes.equals(actualExcludes)) {
			System.out.println("GetFileFilters Expected: \"" + expectedExcludes + "\", Actual: "
					+ actualExcludes);
			return false;
		}
		return true;
	}
	
	
	static boolean GetFileFilters(String[] tokens, Scanner stdin) {
		String actualFilters = CommandLine.GetFileFilters(tokens);
		String expectedFilters = "";
		
		if (stdin.nextBoolean()) {
			int size = stdin.nextInt();
			for (int i = 0; i < size; ++i) {
				expectedFilters += stdin.next();
				if (i < size - 1)
					expectedFilters += ", ";
			}
		}
		
		if (!expectedFilters.equals(actualFilters)) {
			System.out.println("GetFileFilters Expected: \"" + expectedFilters + "\", Actual: "
					+ actualFilters);
			return false;
		}
		return true;
	}
	
	
	static boolean Parse(String[] tokens, Scanner stdin) {
		String expectedCommand = "";
		int size = stdin.nextInt();
		stdin.nextLine();  // read past newline char after integer
		
		for (int i = 0; i < size; ++i) {
			expectedCommand += stdin.nextLine();
			if (i < size - 1)
				expectedCommand += '\n';
		}
		
		String actualCommand = CommandLine.Parse(tokens);
		if (!expectedCommand.equals(actualCommand)) {
			System.out.println("Parse\nExpected:\n\t"
					+ expectedCommand.replace("\n", "\n\t") + "\nActual:\n\t"
					+ actualCommand.replace("\n", "\n\t"));
			return false;
		}
		return true;
	}

}
