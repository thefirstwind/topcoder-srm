import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class EllysXors {
    public long getXor(long L, long R) {
        if (L == 0) {
            return f(R);
        } else {
            return f(R) ^ f(L - 1); // xor with self cancels out
        }
    }

    /**
     * xor sum of [0, a]
     * @param a
     * @return
     */
    private long f(long a) {
        //  0000 <- 0  [a]
        //  0001 <- 1  [1]
        //  0010 <- 3  [a+1]
        //  0011 <- 0  [0]
        //  0100 <- 4  [a]
        //  0101 <- 1  [1]
        //  0110 <- 7  [a+1]
        //  0111 <- 0  [0]
        //  1000 <- 8  [a]
        //  1001 <- 1  [1]
        //  1010 <- 11 [a+1]
        //  1011 <- 0  [0]
        //  1100 <- 12 [a]
        //  1101 <- 1  [1]
        //  1110 <- 15 [a+1]
        //  1111 <- 0  [0]
        long ret = 0L;
        switch ((int) (a % 4)) {
        case 0: ret = a;
            break;
        case 1: ret = 1L;
            break;
        case 2: ret = a + 1;
            break;
        case 3: ret = 0L;
            break;
        }
        return ret;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, long p0, long p1, boolean hasAnswer, long p2) {
        System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
        System.out.println("]");
        EllysXors obj;
        long answer;
        obj = new EllysXors();
        long startTime = System.currentTimeMillis();
        answer = obj.getXor(p0, p1);
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

        long p0;
        long p1;
        long p2;

        // ----- test 0 -----
        p0 = 3L;
        p1 = 10L;
        p2 = 8L;
        all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = 5L;
        p1 = 5L;
        p2 = 5L;
        all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = 13L;
        p1 = 42L;
        p2 = 39L;
        all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = 666L;
        p1 = 1337L;
        p2 = 0L;
        all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = 1234567L;
        p1 = 89101112L;
        p2 = 89998783L;
        all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // XOR problems became very popular in TopCoder recently. (If you do not know the bitwise operation XOR, see the Notes section for an explanation.) That's why Elly decided to invent one of her own. Fortunately for you, the one she came up with is quite simple. You are given two longs L and R. She wants you to find the XOR of all numbers between L and R, inclusive.
    //
    // DEFINITION
    // Class:EllysXors
    // Method:getXor
    // Parameters:long, long
    // Returns:long
    // Method signature:long getXor(long L, long R)
    //
    //
    // NOTES
    // -XOR (exclusive or) is a binary operation, performed on two numbers in binary notation. First, the shorter number is prepended with leading zeroes until both numbers have the same number of digits (in binary). Then, the result is calculated as follows: for each bit where the numbers differ the result has 1 in its binary representation. It has 0 in all other positions.
    // -For example 42 XOR 7 is performed as follows. First, the numbers are converted to binary: 42 is 101010 and 7 is 111. Then the shorter number is prepended with leading zeros until both numbers have the same number of digits. This means 7 becomes 000111. Then 101010 XOR 000111 = 101101 (the result has ones only in the positions where the two numbers differ). Then the result can be converted back to decimal notation. In this case 101101 = 45, so 42 XOR 7 = 45.
    // -One of the ways to calculate the XOR of more than two numbers A1, A2, ..., An is "A1 XOR (A2 XOR (... XOR An))..))". Since the function is commutative and associative, you can also express it as "A1 XOR A2 XOR ... XOR An" and group the operands in any way you like.
    // -It can be proved that the answer is always less than 2*R for the given constraints.
    //
    //
    // CONSTRAINTS
    // -L and R will be between 1 and 4,000,000,000, inclusive.
    // -L will be less than or equal to R.
    //
    //
    // EXAMPLES
    //
    // 0)
    // 3
    // 10
    //
    // Returns: 8
    //
    //
    // ((((((3 XOR 4) XOR 5) XOR 6) XOR 7) XOR 8) XOR 9) XOR 10 =
    //   (((((7 XOR 5) XOR 6) XOR 7) XOR 8) XOR 9) XOR 10 =
    //           ((((2 XOR 6) XOR 7) XOR 8) XOR 9) XOR 10 =
    //                   (((4 XOR 7) XOR 8) XOR 9) XOR 10 =
    //                           ((3 XOR 8) XOR 9) XOR 10 =
    //                                  (11 XOR 9) XOR 10 =
    //                                           2 XOR 10 = 8.
    //
    //
    // 1)
    // 5
    // 5
    //
    // Returns: 5
    //
    // The XOR of a single number is the number itself.
    //
    // 2)
    // 13
    // 42
    //
    // Returns: 39
    //
    // A bit larger example.
    //
    // 3)
    // 666
    // 1337
    //
    // Returns: 0
    //
    // The answer can be zero.
    //
    // 4)
    // 1234567
    // 89101112
    //
    // Returns: 89998783
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
