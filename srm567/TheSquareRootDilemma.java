import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TheSquareRootDilemma
{
	public int countPairs(int N, int M)
	{
        int size = Math.max(N, M);
        int[] mc = new int[size + 1];
        int[] nc = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            int curr = primeSingles(i);
            if (i <= M) mc[curr]++;
            if (i <= N) nc[curr]++;
        }
        int ret = 0;
        for (int i = 0; i <= size; i++) {
            ret += mc[i] * nc[i];
        }
        return ret;
    }

    public static int primeSingles(int number) {
        int n = number;
        BitSet factors = new BitSet();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                if (factors.get(i)) {
                    factors.set(i, false);
                } else {
                    factors.set(i, true);
                }
                n /= i;
            }
        }
        if (n > 1) {
            if (factors.get(n)) {
                factors.set(n, false);
            } else {
                factors.set(n, true);
            }
        }
        if (factors.cardinality() == 0) {
            return 0;
        } else {
            int ret = 1;
            for (int i = factors.nextSetBit(0); i >= 0; i = factors.nextSetBit(i+1)) {
                // operate on index i here
                ret *= i;
            }
            return ret;
        }
    }
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		TheSquareRootDilemma obj;
		int answer;
		obj = new TheSquareRootDilemma();
		long startTime = System.currentTimeMillis();
		answer = obj.countPairs(p0, p1);
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
		
		int p0;
		int p1;
		int p2;

        // ----- test 0 -----
//        p0 = 49945;
//        p1 = 74935;
//        p2 = 410071;
//        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------


        // ----- test 0 -----
		p0 = 2;
		p1 = 2;
		p2 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 10;
		p1 = 1;
		p2 = 3;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 3;
		p1 = 8;
		p2 = 5;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 100;
		p1 = 100;
		p2 = 310;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Consider the function SSR (Squared Sum of square Roots) defined on two positive integer parameters: SSR(A, B) = (sqrt(A)+sqrt(B))^2. We are interested in the cases when the value of the function is also an integer.
	// 
	// Given ints N and M, return the number of ordered pairs (A, B) such that 1 <= A <= N, 1 <= B <= M and SSR(A, B) is an integer.
	// 
	// DEFINITION
	// Class:TheSquareRootDilemma
	// Method:countPairs
	// Parameters:int, int
	// Returns:int
	// Method signature:int countPairs(int N, int M)
	// 
	// 
	// NOTES
	// -The answer to the problem is guaranteed to fit into signed 32-bit integer type under the given constraints.
	// 
	// 
	// CONSTRAINTS
	// -N will be between 1 and 77,777, inclusive.
	// -M will be between 1 and 77,777, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 2
	// 2
	// 
	// Returns: 2
	// 
	// Out of the four possible pairs (A, B), only two yield an integer result: SSR(1, 1) = 4 and SSR(2, 2) = 8.
	// On the other hand, SSR(1, 2) = SSR(2, 1) = 3+2*sqrt(2), which is not an integer.
	// 
	// 1)
	// 10
	// 1
	// 
	// Returns: 3
	// 
	// SSR(1, 1), SSR(4, 1) and SSR(9, 1) are integers.
	// 
	// 2)
	// 3
	// 8
	// 
	// Returns: 5
	// 
	// The valid pairs are (1, 1), (1, 4), (2, 2), (2, 8) and (3, 3).
	// 
	// 3)
	// 100
	// 100
	// 
	// Returns: 310
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!