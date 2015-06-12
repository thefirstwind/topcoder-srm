import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class BridgeBuildingDiv2 {
    static int INF = (int) 1e9;
    public int minDiameter(int[] a, int[] b, int K) {
        int n = a.length + 1;
        int[][] d = new int[2 * n][2 * n];

        int minD = INF;

        for (int bitmask = 0; bitmask < (1 << n); bitmask++) {
            if (Integer.bitCount(bitmask) == K) {
                init(d, a, b);
                for (int bit = 0; bit < n; bit++) {
                    if ((bitmask & (1 << bit)) > 0) {
                        d[bit][bit + n] = d[bit + n][bit] = 0;
                    }
                }
                minD = Math.min(minD, getDiameter(d, n * 2));
            }
        }
        return minD;
    }
    public void init(int[][] d, int[] a, int[] b) {
        for (int[] da : d) {
            Arrays.fill(da, INF);
        }
        int n = a.length + 1;
        for (int i = 0; i < n * 2; i++) {
            d[i][i] = 0;
        }
        for (int i = 0; i < n - 1; i++) {
            d[i][i + 1] = d[i + 1][i] = a[i];
        }
        for (int i = 0; i < n - 1; i++) {
            d[i + n][i + n + 1] = d[i + n + 1][i + n] = b[i];
        }
    }

    public int getDiameter(int[][] d, int n) {

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    d[i][j] = d[j][i] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        int maxD = 0;
        for (int[] da : d) {
            for (int dav : da) {
                maxD = Math.max(maxD, dav);
            }
        }
        return maxD;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int p2, boolean hasAnswer, int p3) {
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
        BridgeBuildingDiv2 obj;
        int answer;
        obj = new BridgeBuildingDiv2();
        long startTime = System.currentTimeMillis();
        answer = obj.minDiameter(p0, p1, p2);
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
        int p3;

        // ----- test 0 -----
        p0 = new int[] {2, 1, 1, 1, 2};
        p1 = new int[] {1, 9, 1, 9, 1};
        p2 = 4;
        p3 = 6;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[] {1, 50, 1, 50, 1, 50, 1, 50};
        p1 = new int[] {50, 1, 50, 1, 50, 1, 50, 1};
        p2 = 9;
        p3 = 8;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[] {50, 10, 15, 31, 20, 23, 7, 48, 5, 50};
        p1 = new int[] {2, 5, 1, 8, 3, 2, 16, 11, 9, 1};
        p2 = 3;
        p3 = 124;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[] {2, 4, 10, 2, 2, 22, 30, 7, 28};
        p1 = new int[] {5, 26, 1, 2, 6, 2, 16, 3, 15};
        p2 = 5;
        p3 = 54;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    //
    // You have two rows of nodes.
    // Each row contains N nodes, numbered 0 through N-1 from the left to the right.
    //
    //
    //
    // Within each row, adjacent nodes are already connected by edges.
    // You are given the lengths of these edges as int[]s a and b, each containing N-1 elements.
    // For each valid i, a[i] is the length of the edge between nodes i and (i+1) in the top row, and b[i] is the length of the edge between nodes i and (i+1) in the bottom row.
    //
    //
    //
    // You want to add exactly K new edges to this graph.
    // Each of the new edges must be vertical -- i.e., it must connect some vertex i in the top row to the vertex i in the bottom row.
    // All new edges will have length 0.
    //
    //
    //
    // By adding the K new edges we will produce a connected graph.
    // The diameter of this graph is the maximum of all shortest distances among pairs of its nodes.
    // In other words, the diameter is the smallest number D such that it is possible to travel from any node to any other node using a path of length D or less.
    //
    //
    //
    // Given a, b, and the int K, compute and return the smallest possible diameter of the resulting graph.
    //
    //
    // DEFINITION
    // Class:BridgeBuildingDiv2
    // Method:minDiameter
    // Parameters:int[], int[], int
    // Returns:int
    // Method signature:int minDiameter(int[] a, int[] b, int K)
    //
    //
    // CONSTRAINTS
    // -N will be between 2 and 11, inclusive.
    // -a,b will contain exactly N-1 elements each.
    // -K will be between 1 and N, inclusive.
    // -Each element of a,b will be between 1 and 50, inclusive.
    //
    //
    // EXAMPLES
    //
    // 0)
    // {2,1,1,1,2}
    // {1,9,1,9,1}
    // 4
    //
    // Returns: 6
    //
    //
    // One example of an optimal solution is to draw the bridges as follows:
    //
    //
    //
    //
    // 1)
    // {1,50,1,50,1,50,1,50}
    // {50,1,50,1,50,1,50,1}
    // 9
    //
    // Returns: 8
    //
    //
    //
    // 2)
    // {50,10,15,31,20,23,7,48,5,50}
    // {2,5,1,8,3,2,16,11,9,1}
    // 3
    //
    // Returns: 124
    //
    //
    //
    // 3)
    // {2,4,10,2,2,22,30,7,28}
    // {5,26,1,2,6,2,16,3,15}
    // 5
    //
    // Returns: 54
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
