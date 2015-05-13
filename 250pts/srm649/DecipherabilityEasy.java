import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class DecipherabilityEasy
{
	public String check(String s, String t)
	{
		StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            if (sb.toString().equals(t)) {
                return "Possible";
            }
            sb.insert(i, c);
        }
        return "Impossible";
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
		System.out.println("]");
		DecipherabilityEasy obj;
		String answer;
		obj = new DecipherabilityEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.check(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p2 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p2);
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
		String p2;
		
		// ----- test 0 -----
		p0 = "sunuke";
		p1 = "snuke";
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "snuke";
		p1 = "skue";
		p2 = "Impossible";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "snuke";
		p1 = "snuke";
		p2 = "Impossible";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "snukent";
		p1 = "snuke";
		p2 = "Impossible";
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "aaaaa";
		p1 = "aaaa";
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "aaaaa";
		p1 = "aaa";
		p2 = "Impossible";
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = "topcoder";
		p1 = "tpcoder";
		p2 = "Possible";
		all_right = KawigiEdit_RunTest(6, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 7 -----
		p0 = "singleroundmatch";
		p1 = "singeroundmatc";
		p2 = "Impossible";
		all_right = KawigiEdit_RunTest(7, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// You had a non-empty string s but you lost it.
	// Cat Snuke found the string and removed one character from the string.
	// Later, Snuke gave you the string t.
	// Can this be the string created from your string s?
	// 
	// You are given the Strings s and t.
	// Return "Possible" (quotes for clarity) if t can be obtained from s by erasing exactly one character.
	// Otherwise, return "Impossible".
	// Note that the return value is case-sensitive.
	// 
	// DEFINITION
	// Class:DecipherabilityEasy
	// Method:check
	// Parameters:String, String
	// Returns:String
	// Method signature:String check(String s, String t)
	// 
	// 
	// CONSTRAINTS
	// -The number of characters in s will be between 1 and 50, inclusive.
	// -Every character in s will be a lowercase letter ('a'-'z').
	// -The number of characters in t will be between 1 and 50, inclusive.
	// -Every character in t will be a lowercase letter ('a'-'z').
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "sunuke"
	// "snuke"
	// 
	// Returns: "Possible"
	// 
	// If Cat Snuke erase the first 'u' from s, it will equal to t.
	// 
	// 1)
	// "snuke"
	// "skue"
	// 
	// Returns: "Impossible"
	// 
	// Swapping characters is not allowed.
	// 
	// 2)
	// "snuke"
	// "snuke"
	// 
	// Returns: "Impossible"
	// 
	// Erasing nothing is not allowed.
	// 
	// 3)
	// "snukent"
	// "snuke"
	// 
	// Returns: "Impossible"
	// 
	// Cat Snuke can erase exactly one character.
	// 
	// 4)
	// "aaaaa"
	// "aaaa"
	// 
	// Returns: "Possible"
	// 
	// 
	// 
	// 5)
	// "aaaaa"
	// "aaa"
	// 
	// Returns: "Impossible"
	// 
	// 
	// 
	// 6)
	// "topcoder"
	// "tpcoder"
	// 
	// Returns: "Possible"
	// 
	// 
	// 
	// 7)
	// "singleroundmatch"
	// "singeroundmatc"
	// 
	// Returns: "Impossible"
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!