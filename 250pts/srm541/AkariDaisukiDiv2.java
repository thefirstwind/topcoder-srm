import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class AkariDaisukiDiv2
{
	public int countTuples(String S)
	{
		int n = S.length();
        int ret = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int start = j + 1;
                while (start < n) {
                    int pos = S.indexOf(S.substring(i, j), start);
                    if (pos > 0 && pos + (j - i) < n) {
                        ret++;
                        start = pos + 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return ret;
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		AkariDaisukiDiv2 obj;
		int answer;
		obj = new AkariDaisukiDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.countTuples(p0);
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

        // ----- test 4 -----
        p0 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        p1 = 8924;
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
        // ------------------

		// ----- test 0 -----
		p0 = "topcoderdivtwo";
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "foxciel";
		p1 = 0;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "magicalgirl";
		p1 = 4;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "waaiusushioakariusushiodaisuki";
		p1 = 75;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		

		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// 
	// Consider the following function:
	// f(X) = Waai + X + Akari + X + Daisuki
	// Here, X is a string and + denotes string concatenation.
	// Waai, Akari and Daisuki are constant non-empty strings.
	// 
	// 
	// 
	// You are given a String S.
	// Compute and return the number of different tuples (Waai,Akari,Daisuki,X) such that f(X) equals S.
	// 
	// 
	// DEFINITION
	// Class:AkariDaisukiDiv2
	// Method:countTuples
	// Parameters:String
	// Returns:int
	// Method signature:int countTuples(String S)
	// 
	// 
	// NOTES
	// -Two tuples (A,B,C,D) and (E,F,G,H) are considered equal if and only if A=E, B=F, C=G, and D=H.
	// 
	// 
	// CONSTRAINTS
	// -S will contain between 1 and 50 characters, inclusive.
	// -Each character of S will be a lowercase letter ('a'-'z').
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "topcoderdivtwo"
	// 
	// Returns: 2
	// 
	// The possible tuples of (Waai, Akari, Daisuki, X) are the following ones:
	// 
	// ("t", "pc", "derdivtwo", "o")
	// ("topco", "er", "ivtwo", "d")
	// 
	// ("topc", "derdivtw", "", "o") is not allowed since Daisuki is empty.
	// 
	// 1)
	// "foxciel"
	// 
	// Returns: 0
	// 
	// The answer can be zero.
	// 
	// 
	// 2)
	// "magicalgirl"
	// 
	// Returns: 4
	// 
	// 
	// 
	// 3)
	// "waaiusushioakariusushiodaisuki"
	// 
	// Returns: 75
	// 
	// 
	// 
	// 4)
	// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	// 
	// Returns: 8924
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
