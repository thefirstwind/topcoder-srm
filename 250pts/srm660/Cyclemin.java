import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class Cyclemin {
	public String bestmod(String s, int k) {
		String s2 = s + s;
		int n = s.length();
		String result = s2.substring(0, n);
		for (int i = 0; i < n; i++) {
			char[] sa = s2.substring(i, n + i).toCharArray();
			for (int j = 0, kk = k; j < sa.length && kk > 0; j++) {
				if (sa[j] != 'a') {
					sa[j] = 'a';
					kk--;
				}
			}

			String curr = new String(sa);
			if (curr.compareTo(result) < 0) {
				result = curr;
			}
		}
		return result;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, int p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + p1);
		System.out.println("]");
		Cyclemin obj;
		String answer;
		obj = new Cyclemin();
		long startTime = System.currentTimeMillis();
		answer = obj.bestmod(p0, p1);
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
		int p1;
		String p2;

		// ----- test 0 -----
		p0 = "aba";
		p1 = 1;
		p2 = "aaa";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 1 -----
		p0 = "aba";
		p1 = 0;
		p2 = "aab";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 2 -----
		p0 = "bbb";
		p1 = 2;
		p2 = "aab";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 3 -----
		p0 = "sgsgaw";
		p1 = 1;
		p2 = "aasgsg";
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 4 -----
		p0 = "abacaba";
		p1 = 1;
		p2 = "aaaabac";
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------

		// ----- test 5 -----
		p0 = "isgbiao";
		p1 = 2;
		p2 = "aaaisgb";
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------

		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// A rotation of a string S is the operation of moving its first character to the end.
	// For example, if we rotate the string "abcde" we get the string "bcdea".
	//
	// A cyclic shift of a string S is any string that can be obtained from S by a sequence of zero or more rotations.
	// For example, the strings "abcde", "cdeab", and "eabcd" are some of the cyclic shifts of the string "abcde".
	//
	// Given two equally long strings, the smaller one is the one with a smaller character at the first index where they differ.
	// For example, "cable" < "cards" because 'b' < 'r'.
	//
	// You are given a String s of lowercase letters and an int k.
	// You are allowed to change at most k letters of s into some other lowercase letters.
	// Your goal is to create a string that will have the smallest possible cyclic shift.
	// Compute and return that cyclic shift.
	//
	// DEFINITION
	// Class:Cyclemin
	// Method:bestmod
	// Parameters:String, int
	// Returns:String
	// Method signature:String bestmod(String s, int k)
	//
	//
	// CONSTRAINTS
	// -s will contain between 1 and 50 characters, inclusive.
	// -Each character in s will be between 'a' and 'z', inclusive.
	// -k will be between 0 and the length of s, inclusive.
	//
	//
	// EXAMPLES
	//
	// 0)
	// "aba"
	// 1
	//
	// Returns: "aaa"
	//
	// We are allowed to change at most 1 character. Clearly, the optimal change is to change the 'b' into an 'a'.
	//
	// 1)
	// "aba"
	// 0
	//
	// Returns: "aab"
	//
	// We are not allowed to change anything. In this case, the answer is the smallest cyclic shift of the given string s.
	//
	// 2)
	// "bbb"
	// 2
	//
	// Returns: "aab"
	//
	//
	//
	// 3)
	// "sgsgaw"
	// 1
	//
	// Returns: "aasgsg"
	//
	// The optimal solution is to change the 'w' into an 'a', and then to take the cyclic shift that starts with the last two letters of s.
	//
	// 4)
	// "abacaba"
	// 1
	//
	// Returns: "aaaabac"
	//
	//
	//
	// 5)
	// "isgbiao"
	// 2
	//
	// Returns: "aaaisgb"
	//
	//
	//
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
