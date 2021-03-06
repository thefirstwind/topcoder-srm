import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

/**
 * SRM 648
 */
public class ABC {
    Stack<Character> s = new Stack<Character>();
    int N, K;
    boolean found = false;
    String ret = "";
    boolean[][][] failed;
    public String createString(int N, int K) {
        this.N = N;
        failed = new boolean[K + 1][N + 1][N + 1];
        backtrack(K, 0, 0);
        return found ? ret : "";
    }
    private void backtrack(int k, int na, int nb) {
        if (found || failed[k][na][nb]) {
            return;
        }
        if (k == 0 && s.size() == N) {
            found = true;
            StringBuilder sb = new StringBuilder();
            for (char c : s) {
                sb.append(c);
            }
            ret = sb.toString();
            return;
        } else if (s.size() < N) {
            s.push('A');
            backtrack(k, na + 1, nb);
            s.pop();
            if (k >= na) {
                s.push('B');
                backtrack(k - na, na, nb + 1);
                s.pop();
            }
            if (k >= na + nb) {
                s.push('C');
                backtrack(k - na - nb, na, nb);
                s.pop();
            }
            failed[k][na][nb] = true;
        }
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, String p2) {
        System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
        System.out.println("]");
        ABC obj;
        String answer;
        obj = new ABC();
        long startTime = System.currentTimeMillis();
        answer = obj.createString(p0, p1);
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

        int p0;
        int p1;
        String p2;

        // ----- test 0 -----
        p0 = 3;
        p1 = 3;
        p2 = "ABC";
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = 3;
        p1 = 0;
        p2 = "CBA";
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = 5;
        p1 = 10;
        p2 = "";
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 15;
        p1 = 36;
        p2 = "CABBACCBAABCBBB";
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 23;
        p1 = 213;
        p2 = "";
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // You are given two ints: N and K. Lun the dog is interested in strings that satisfy the following conditions:
    //
    // The string has exactly N characters, each of which is either 'A', 'B' or 'C'.
    // The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] < s[j].
    //
    // If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
    //
    // DEFINITION
    // Class:ABC
    // Method:createString
    // Parameters:int, int
    // Returns:String
    // Method signature:String createString(int N, int K)
    //
    //
    // CONSTRAINTS
    // -N will be between 3 and 30, inclusive.
    // -K will be between 0 and N(N-1)/2, inclusive.
    //
    //
    // EXAMPLES
    //
    // 0)
    // 3
    // 3
    //
    // Returns: "ABC"
    //
    // This string has exactly three pairs (i, j) mentioned in the statement: (0, 1), (0, 2) and (1, 2).
    //
    // 1)
    // 3
    // 0
    //
    // Returns: "CBA"
    //
    // Please note that there are valid test cases with K = 0.
    //
    // 2)
    // 5
    // 10
    //
    // Returns: ""
    //
    // Five characters is too short for this value of K.
    //
    // 3)
    // 15
    // 36
    //
    // Returns: "CABBACCBAABCBBB"
    //
    // Please note that this is an example of a solution; other valid solutions will also be accepted.
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
