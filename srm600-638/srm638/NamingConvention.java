import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class NamingConvention
{
	public String toCamelCase(String variableName)
	{
		boolean prev = false;
        StringBuilder sb = new StringBuilder();
        for (char c : variableName.toCharArray()) {
            if (prev) {
                if (c >= 'a' && c <= 'z') {
                    sb.append((char) (c - 32));
                    prev = false;
                }
            } else if ( c == '_') {
                prev = true;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		NamingConvention obj;
		String answer;
		obj = new NamingConvention();
		long startTime = System.currentTimeMillis();
		answer = obj.toCamelCase(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p1 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p1);
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		all_right = true;
		
		String p0;
		String p1;
		
		// ----- test 0 -----
		p0 = "sum_of_two_numbers";
		p1 = "sumOfTwoNumbers";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "variable";
		p1 = "variable";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "t_o_p_c_o_d_e_r";
		p1 = "tOPCODER";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "the_variable_name_can_be_very_long_like_this";
		p1 = "theVariableNameCanBeVeryLongLikeThis";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// In most programming languages variable names cannot contain spaces.
	// If we want a variable name that consists of two or more words, we have to encode the spaces somehow.
	// In this problem, we will look at two ways of doing so: Snake Case and Camel Case.
	// When using Snake Case, we just replace each space by an underscore ('_').
	// When using Camel Case, we capitalize the first letter of each word except for the first one, and then we remove all spaces.
	// 
	// 
	// For example, suppose that we want to declare a variable called "good morning world" (quotes for clarity).
	// In Snake Case, we would write this variable as "good_morning_world", while in Camel Case it would be "goodMorningWorld".
	// 
	// 
	// You are given a String variableName.
	// This String contains a valid variable name written in Snake Case.
	// Return the same variable name in Camel Case.
	// 
	// DEFINITION
	// Class:NamingConvention
	// Method:toCamelCase
	// Parameters:String
	// Returns:String
	// Method signature:String toCamelCase(String variableName)
	// 
	// 
	// CONSTRAINTS
	// -variableName will contain between 1 and 50 characters.
	// -Each character of variableName will be 'a'-'z' or '_'.
	// -The first and last character of variableName will not be '_'.
	// -variableName will not contain two consecutive underscores ('_').
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "sum_of_two_numbers"
	// 
	// Returns: "sumOfTwoNumbers"
	// 
	// We have 4 words: "sum", "of", "two", "numbers". So the answer is "sum" + "Of" + "Two" + "Numbers".
	// 
	// 1)
	// "variable"
	// 
	// Returns: "variable"
	// 
	// Note that if we have only 1 word, then the varaible name will remain same.
	// 
	// 2)
	// "t_o_p_c_o_d_e_r"
	// 
	// Returns: "tOPCODER"
	// 
	// 
	// 
	// 3)
	// "the_variable_name_can_be_very_long_like_this"
	// 
	// Returns: "theVariableNameCanBeVeryLongLikeThis"
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!