import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

/**
 * 584
 */
public class TopFox
{
	public int possibleHandles(String familyName, String givenName)
	{
		HashSet<String> s = new HashSet<String>();
        for (int i = 1; i <= familyName.length(); i++) {
            for (int j = 1; j <= givenName.length(); j++) {
                s.add(familyName.substring(0, i) + givenName.substring(0, j));
            }
        }
        return s.size();
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
		System.out.println("]");
		TopFox obj;
		int answer;
		obj = new TopFox();
		long startTime = System.currentTimeMillis();
		answer = obj.possibleHandles(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
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
		int p2;
		
		// ----- test 0 -----
		p0 = "ab";
		p1 = "cd";
		p2 = 4;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "abb";
		p1 = "bbc";
		p2 = 7;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "fox";
		p1 = "ciel";
		p2 = 12;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "abbbb";
		p1 = "bbbbbbbc";
		p2 = 16;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "abxy";
		p1 = "xyxyxc";
		p2 = 21;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "ababababab";
		p1 = "bababababa";
		p2 = 68;
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Fox Ciel is planning to register on TopFox. Her family name is familyName and her given name is givenName.
	// 
	// She will choose a TopFox handle according to the following rule. Let s be a non-empty prefix of her family name and let t be a non-empty prefix of her given name. Now Fox Ciel may choose the concatenation of s and t as her handle.
	// 
	// For example, suppose Fox Ciel's family name is "fox" and her given name is "ciel". She may choose the handle "foxciel", "fc", or "foxc". She may not choose "ox", "ciel", or "jiro".
	// 
	// You are told Fox Ciel's family name and given name. Return the number of possible handles Fox Ciel may choose.
	// 
	// DEFINITION
	// Class:TopFox
	// Method:possibleHandles
	// Parameters:String, String
	// Returns:int
	// Method signature:int possibleHandles(String familyName, String givenName)
	// 
	// 
	// CONSTRAINTS
	// -familyName will contain between 2 and 10 characters, inclusive.
	// -Each character in familyName will be a lowercase English letter, i.e., 'a'-'z'.
	// -givenName will contain between 2 and 10 characters, inclusive.
	// -Each character in givenName will be a lowercase English letter, i.e., 'a'-'z'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "ab"
	// "cd"
	// 
	// Returns: 4
	// 
	// There are 4 possible handles: "a" + "c" = "ac", "a" + "cd" = "acd", "ab" + "c" = "abc" and "ab" + "cd" = "abcd".
	// 
	// 1)
	// "abb"
	// "bbc"
	// 
	// Returns: 7
	// 
	// There are 7 possible handles: "ab", "abb", "abbc", "abbb", "abbbc", "abbbb", "abbbbc".
	// 
	// 2)
	// "fox"
	// "ciel"
	// 
	// Returns: 12
	// 
	// 
	// 
	// 3)
	// "abbbb"
	// "bbbbbbbc"
	// 
	// Returns: 16
	// 
	// 
	// 
	// 4)
	// "abxy"
	// "xyxyxc"
	// 
	// Returns: 21
	// 
	// 
	// 
	// 5)
	// "ababababab"
	// "bababababa"
	// 
	// Returns: 68
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
