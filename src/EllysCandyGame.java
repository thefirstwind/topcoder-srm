import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class EllysCandyGame
{
	int N, elly;
	int[] a;
	public String getWinner(int[] sweets)
	{
		this.N = sweets.length;
		elly = 0;
		a = sweets;

		int ret = solve(0, true);

		if (ret == 0) return "Draw";
		else if (ret > 0) return "Elly";
		else return "Kris";
	}

	private int solve(int step, boolean isElly) {
		if (step == N) return elly;

		boolean hasWinning = false, hasDraw = false, hasLosing = false;
		for (int i = 0; i < N; i++) {
			if (a[i] != 0) {
				int prev = a[i];
				if (isElly) elly += prev;
				else elly -= prev;
				if (i > 0) a[i - 1] *= 2;
				if (i < N - 1) a[i + 1] *= 2;
				a[i] = 0;

				int result = solve(step + 1, !isElly);
                if (result > 0) hasWinning = true;
				if (result == 0) hasDraw = true;
				if (result < 0) hasLosing = true;

				a[i] = prev;
				if (isElly) elly -= prev;
				else elly += prev;
				if (i > 0) a[i - 1] /= 2;
				if (i < N - 1) a[i + 1] /= 2;
			}
		}
		if (!hasWinning && !hasDraw && !hasLosing) return elly;
        if (isElly) {
            if (hasWinning) return 1;
            else if (hasDraw) return 0;
            else return -1;
        } else {
            if (hasLosing) return -1;
            else if (hasDraw) return 0;
            else return 1;
        }
}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		EllysCandyGame obj;
		String answer;
		obj = new EllysCandyGame();
		long startTime = System.currentTimeMillis();
		answer = obj.getWinner(p0);
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
		
		int[] p0;
		String p1;
		
		// ----- test 2 -----
		p0 = new int[]{10,20};
		p1 = "Draw";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 0 -----
		p0 = new int[]{20,50,70,0,30};
		p1 = "Kris";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{42,13,7};
		p1 = "Elly";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{3,1,7,11,1,1};
		p1 = "Kris";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{41,449,328,474,150,501,467,329,536,440};
		p1 = "Kris";
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new int[]{177,131,142,171,411,391,17,222,100,298};
		p1 = "Elly";
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
