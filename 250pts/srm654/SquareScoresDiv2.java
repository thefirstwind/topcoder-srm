import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class SquareScoresDiv2
{
	public int getscore(String s)
	{
		char curr = 0;
        int counter = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == curr) {
                counter++;
            } else {
                result += (1 + counter) * counter / 2;
                curr = c;
                counter = 1;
            }
        }
        result += (1 + counter) * counter / 2;
        return result;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		SquareScoresDiv2 obj;
		int answer;
		obj = new SquareScoresDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.getscore(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
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
		int p1;
		
		// ----- test 0 -----
		p0 = "aaaba";
		p1 = 8;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "zzzxxzz";
		p1 = 12;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "abcdefghijklmnopqrstuvwxyz";
		p1 = 26;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "p";
		p1 = 1;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		p1 = 5050;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// 
	// A substring of a string is a contiguous sequence of characters from the string.
	// For example, each of the strings "ab", "bcd", and "e" is a substring of "abcde". 
	// On the other hand, "cba", "ace", and "f" are not substrings of "abcde".
	// 
	// 
	// The score of a string S is the number of ways in which we can select a non-empty substring of S such that all characters in the substring are the same.
	// If two substrings consist of the same letters but occur at different places in S, they are still considered different.
	// For example, the score of "aaaba" is 8: there are four occurrences of the substring "a", two occurrences of "aa", one occurrence of "aaa", and one of "b".
	// 
	// 
	// On her birthday, Maki got a String s from her friend Niko as a present.
	// Calculate and return its score.
	// 
	// 
	// 
	// DEFINITION
	// Class:SquareScoresDiv2
	// Method:getscore
	// Parameters:String
	// Returns:int
	// Method signature:int getscore(String s)
	// 
	// 
	// CONSTRAINTS
	// -The length of s will be between 1 and 100, inclusive.
	// -Each character in s will be a lowercase letter ('a'-'z').
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "aaaba"
	// 
	// Returns: 8
	// 
	// The example explained above.
	// 
	// 1)
	// "zzzxxzz"
	// 
	// Returns: 12
	// 
	// 
	// 
	// 2)
	// "abcdefghijklmnopqrstuvwxyz"
	// 
	// Returns: 26
	// 
	// 
	// 
	// 3)
	// "p"
	// 
	// Returns: 1
	// 
	// 
	// 
	// 4)
	// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	// 
	// Returns: 5050
	// 
	// All substrings satisfy the condition.
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
