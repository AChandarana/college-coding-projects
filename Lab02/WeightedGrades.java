//Alex Chandarana

import java.util.Scanner;

public class WeightedGrades {

    public static void main(String[] args) {
        
        String str1, str2, str3, str4, str5, str6;
        int int1, int2;
        double s1gpa1 = 0, s1gpa2 = 0, s1gpa3 = 0, s2gpa1 = 0, s2gpa2 = 0, s2gpa3 = 0, s2gpaf = 0, s1gpaf = 0;
        
        Scanner stdin = new Scanner(System.in);

        
        int1 = stdin.nextInt();
        str1 = stdin.next();
        str2 = stdin.next();
        str3 = stdin.next();
        int2 = stdin.nextInt();
        str4 = stdin.next();
        str5 = stdin.next();
        str6 = stdin.next();

        //These statements set variable s_gpa_ (student _, gpa or grade _) to whatever numerical value is associated with the letter grade
        if (str1.equals("A")) {
            s1gpa1 = 4.0;
        } 
        
        else if (str1.equals("B")) {
            s1gpa1 = 3.0;
        } 
        
        else if (str1.equals("C")) {
            s1gpa1 = 2.0;
        } 
        
        else if (str1.equals("D")) {
            s1gpa1 = 1.0;
        } 
        
        else if (str1.equals("F")) {
            s1gpa1 = 0.0;
        } 
        
/////////////////////
        
        if (str2.equals("A")) {
            s1gpa2 = 4.0;
        } 
        
        else if (str2.equals("B")) {
            s1gpa2 = 3.0;
        } 
        
        else if (str2.equals("C")) {
            s1gpa2 = 2.0;
        } 
        
        else if (str2.equals("D")) {
            s1gpa2 = 1.0;
        } 
        
        else if (str2.equals("F")) {
            s1gpa2 = 0.0;
        } 
            
/////////////////////
        
        if (str3.equals("A")) {
            s1gpa3 = 4.0;
        } 
        
        else if (str3.equals("B")) {
            s1gpa3 = 3.0;
        } 
        
        else if (str3.equals("C")) {
            s1gpa3 = 2.0;
        } 
        
        else if (str3.equals("D")) {
            s1gpa3 = 1.0;
        } 
        
        else if (str3.equals("F")) {
            s1gpa3 = 0.0;
        } 
        

        
/////////////////////
/////////////////////

        
        
        if (str4.equals("A")) {
            s2gpa1 = 4.0;
        } 
        
        else if (str4.equals("B")) {
            s2gpa1 = 3.0;
        } 
        
        else if (str4.equals("C")) {
            s2gpa1 = 2.0;
        } 
        
        else if (str4.equals("D")) {
            s2gpa1 = 1.0;
        } 
        
        else if (str4.equals("F")) {
            s2gpa1 = 0.0;
        } 
        
/////////////////////
        
        if (str5.equals("A")) {
            s2gpa2 = 4.0;
        } 
        
        else if (str5.equals("B")) {
            s2gpa2 = 3.0;
        } 
        
        else if (str5.equals("C")) {
            s2gpa2 = 2.0;
        } 
        
        else if (str5.equals("D")) {
            s2gpa2 = 1.0;
        } 
        
        else if (str5.equals("F")) {
            s2gpa2 = 0.0;
        } 
            
/////////////////////
        
        if (str6.equals("A")) {
            s2gpa3 = 4.0;
        } 
        
        else if (str6.equals("B")) {
            s2gpa3 = 3.0;
        } 
        
        else if (str6.equals("C")) {
            s2gpa3 = 2.0;
        } 
        
        else if (str6.equals("D")) {
            s2gpa3 = 1.0;
        } 
        
        else if (str6.equals("F")) {
            s2gpa3 = 0.0;
        } 
        
        
        //These formulas calculate the final gpa on a 4.0 scale by giving the exam grade 3x the weight as the other types (for a maxim score of 20/20) and divides by 5 to create an /4.0 gpa
        s1gpaf = ((s1gpa1*3) + s1gpa2 + s1gpa3)/5;
        s2gpaf = ((s2gpa1*3) + s2gpa2 + s2gpa3)/5;
        
        //This uses if statements to print the correct statement based on what letter grade the gpa is associated with
        if (s1gpaf >= 3.5) {
        	System.out.println("Student " + int1 + ": A");
        } else if (s1gpaf > 2.5) {
        	System.out.println("Student " + int1 + ": B");
        } else if (s1gpaf > 2) {
        	System.out.println("Student " + int1 + ": C");
        } else if (s1gpaf > 1.5) {
        	System.out.println("Student " + int1 + ": D");
        } else {
        	System.out.println("Student " + int1 + ": F");
        }
        	
        
        if (s2gpaf >= 3.5) {
        	System.out.println("Student " + int2 + ": A");
        } else if (s2gpaf > 2.5) {
        	System.out.println("Student " + int2 + ": B");
        } else if (s2gpaf > 2) {
        	System.out.println("Student " + int2 + ": C");
        } else if (s2gpaf > 1.5) {
        	System.out.println("Student " + int2 + ": D");
        } else {
        	System.out.println("Student " + int2 + ": F");
        }
        

    }

}
