import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class LittleElephantAndString {
    /**
     * SRM 597
     * Greedy method,
     *     find the largest ordered segment in two strings
     *     the rest of the striing needs to be rearranged
     *
     * DP, looks like the longest common subsequence problem
     *
     * @param  A [description]
     * @param  B [description]
     * @return   [description]
     */
    public int getNumber(String A, String B) {
        int size = A.length();
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        for (int i = 0; i < size; i++) {
            if (arrA[i] != arrB[i]) return -1;
        }
        arrA = A.toCharArray();
        arrB = B.toCharArray();

        for (int i = 0; i < size; ++i) {
            int curr = 0;
            for (int j = i; j < size; ++j) {
                while (curr < size && arrB[j] != arrA[curr]) {
                    curr++;
                }
                curr++;
            }
            if (curr <= size) {
                return i;
            }
        }
        return 1;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String p0, String p1, boolean hasAnswer, int p2) {
        System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
        System.out.println("]");
        LittleElephantAndString obj;
        int answer;
        obj = new LittleElephantAndString();
        long startTime = System.currentTimeMillis();
        answer = obj.getNumber(p0, p1);
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
        p0 = "ABC";
        p1 = "CBA";
        p2 = 2;
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = "A";
        p1 = "B";
        p2 = -1;
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = "AAABBB";
        p1 = "BBBAAA";
        p2 = 3;
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        p1 = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        p2 = 25;
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = "A";
        p1 = "A";
        p2 = 0;
        all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = "DCABA";
        p1 = "DACBA";
        p2 = 2;
        all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
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
