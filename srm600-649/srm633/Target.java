import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class Target {
    public String[] draw(int n) {
        char[][] ret = new char[n][n];
        int center = (n - 1) / 2;
        for (char[] a : ret) {
            Arrays.fill(a, ' ');
        }
        for (int size = n - 1; size >= 0; size -= 4) {
            // top and bottom
            for (int i = center - size / 2; i <= center + size / 2; i++) {
                ret[center - size / 2][i] = ret[center + size / 2][i] = '#';
            }
            // left and right
            for (int i = center - size / 2 + 1; i <= center + size / 2; i++) {
                ret[i][center - size / 2] = ret[i][center + size / 2] = '#';
            }
        }

        String[] r = new String[n];
        for (int i = 0; i < n; ++i) {
            r[i] = new String(ret[i]);
        }
        return r;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int p0, boolean hasAnswer, String[] p1) {
        System.out.print("Test " + testNum + ": [" + p0);
        System.out.println("]");
        Target obj;
        String[] answer;
        obj = new Target();
        long startTime = System.currentTimeMillis();
        answer = obj.draw(p0);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.print("\t" + "{");
            for (int i = 0; p1.length > i; ++i) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.print("\"" + p1[i] + "\"");
            }
            System.out.println("}");
        }
        System.out.println("Your answer:");
        System.out.print("\t" + "{");
        for (int i = 0; answer.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + answer[i] + "\"");
        }
        System.out.println("}");
        if (hasAnswer) {
            if (answer.length != p1.length) {
                res = false;
            } else {
                for (int i = 0; answer.length > i; ++i) {
                    if (!answer[i].equals(p1[i])) {
                        res = false;
                    }
                }
            }
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
        String[] p1;

        // ----- test 0 -----
        p0 = 5;
        p1 = new String[] {"#####", "#   #", "# # #", "#   #", "#####"};
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = 9;
        p1 = new String[] {"#########", "#       #", "# ##### #", "# #   # #", "# # # # #", "# #   # #", "# ##### #", "#       #", "#########"};
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = 13;
        p1 = new String[] {"#############", "#           #", "# ######### #", "# #       # #", "# # ##### # #", "# # #   # # #", "# # # # # # #", "# # #   # # #", "# # ##### # #", "# #       # #", "# ######### #", "#           #", "#############"};
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 17;
        p1 = new String[] {"#################", "#               #", "# ############# #", "# #           # #", "# # ######### # #", "# # #       # # #", "# # # ##### # # #", "# # # #   # # # #", "# # # # # # # # #", "# # # #   # # # #", "# # # ##### # # #", "# # #       # # #", "# # ######### # #", "# #           # #", "# ############# #", "#               #", "#################"};
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
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