import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TaroCards {
    public long getNumber(int[] first, int[] second, int K) {
        // dp[leftCard][rightCard][1..10bitmap]
        //
        // use bitmask for 1..10 only
        //
        // determine how each deck interacts with other cards
        // differentiate 1..10 from 11..n
        // cnt only does the ones in 11..n

        int n = first.length;
        long dp[][][] = new long[n + 1][1 << 10][n + 1];
        dp[0][0][0] = 1;
        for (int pos = 0; pos < n; ++pos) {
            int a = first[pos] - 1;
            int b = second[pos] - 1;
            for (int mask = 0; mask < (1 << 10); ++mask) {
                for (int cnt = 0; cnt <= n; ++cnt) {
                    if (dp[pos][mask][cnt] == 0) continue;
                    if (a < 10) {
                        dp[pos + 1][mask | (1 << a) | (1 << b)][cnt] += dp[pos][mask][cnt];
                    } else {
                        dp[pos + 1][mask | (1 << b)][cnt + 1] += dp[pos][mask][cnt];
                    }
                    dp[pos + 1][mask][cnt] += dp[pos][mask][cnt];
                }
            }
        }
        long res = 0;
        for (int mask = 0; mask < (1 << 10); ++mask) {
            int bits = 0;
            for (int i = 0; i < 10; ++i) {
                if ((mask & (1 << i)) != 0) ++bits;
            }
            for (int cnt = 0; cnt <= n; ++cnt) {
                if (cnt + bits <= K) res += dp[n][mask][cnt];
            }
        }

        return res;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int p2, boolean hasAnswer, long p3) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p0[i]);
        }
        System.out.print("}" + "," + "{");
        for (int i = 0; p1.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p1[i]);
        }
        System.out.print("}" + "," + p2);
        System.out.println("]");
        TaroCards obj;
        long answer;
        obj = new TaroCards();
        long startTime = System.currentTimeMillis();
        answer = obj.getNumber(p0, p1, p2);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p3);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p3;
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
        int[] p1;
        int p2;
        long p3;

        // ----- test 0 -----
        p0 = new int[] {1, 2};
        p1 = new int[] {2, 3};
        p2 = 2;
        p3 = 3L;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {3, 1, 2};
        p1 = new int[] {1, 1, 1};
        p2 = 3;
        p3 = 8L;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {4, 2, 1, 3};
        p1 = new int[] {1, 2, 3, 4};
        p2 = 5;
        p3 = 16L;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {1, 2, 3, 4, 5, 6, 7};
        p1 = new int[] {2, 1, 10, 9, 3, 2, 2};
        p2 = 3;
        p3 = 17L;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = new int[] {1};
        p1 = new int[] {2};
        p2 = 1;
        p3 = 1L;
        all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = new int[] {6, 20, 1, 11, 19, 14, 2, 8, 15, 21, 9, 10, 4, 16, 12, 17, 13, 22, 7, 18, 3, 5};
        p1 = new int[] {4, 5, 10, 7, 6, 2, 1, 10, 10, 7, 9, 4, 5, 9, 5, 10, 10, 3, 6, 6, 4, 4};
        p2 = 14;
        p3 = 2239000L;
        all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
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
