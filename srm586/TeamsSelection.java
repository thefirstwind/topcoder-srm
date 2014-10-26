import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class TeamsSelection
{
	public String simulate(int[] preference1, int[] preference2)
	{
		int n = preference1.length;
        char[] ret = new char[n];
        Arrays.fill(ret, '0');
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // 1
                int m1 = 0;
                for (int j = 0; j < n; j++) {
                    if (ret[preference1[j] - 1] == '0') {
                        m1 = preference1[j] - 1;
                        break;
                    }
                }
                ret[m1] = '1';
            } else {
                // 2
                int m2 = 0;
                for (int j = 0; j < n; j++) {
                    if (ret[preference2[j] - 1] == '0') {
                        m2 = preference2[j] - 1;
                        break;
                    }
                }
                ret[m2] = '2';
            }
        }
        return new String(ret);
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, String p2) {
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
		System.out.print("}");
		System.out.println("]");
		TeamsSelection obj;
		String answer;
		obj = new TeamsSelection();
		long startTime = System.currentTimeMillis();
		answer = obj.simulate(p0, p1);
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
		
		int[] p0;
		int[] p1;
		String p2;
		
		// ----- test 0 -----
		p0 = new int[]{1,2,3,4};
		p1 = new int[]{1,2,3,4};
		p2 = "1212";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{3,2,1};
		p1 = new int[]{1,3,2};
		p2 = "211";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{6,1,5,2,3,4};
		p1 = new int[]{1,6,3,4,5,2};
		p2 = "212211";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{8,7,1,2,4,5,6,3,9};
		p1 = new int[]{7,2,4,8,1,5,9,6,3};
		p2 = "121121212";
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// The boys in the yard are going to play soccer. There are N+2 boys, two of which have been chosen as captains. Now they want to divide the other N children into two teams. For convenience, we number the boys who are not captains from 1 to N.
	// 
	// The division into teams works as follows. Initially, the first captain chooses one person for his team. Then, the second captain chooses one boy from those who are left. Then the first captain chooses again, and so on. The process continues until there are no more boys left.
	// 
	// You are given int[]s preference1 and preference2, each containing N elements. preference1[0] is the number of the boy whom the first captain regards to be the best player, preference1[1] is the next best player according to the first captain, and so on. preference2 describes the second captain's assessment in the same fashion. The captains pick the players greedily, i.e., each of them always chooses the boy whom he considers to be the strongest between the children not yet chosen.
	// 
	// Return a String consisting of N characters. Character i in the returned string must be '1' if the boy i+1 will be assigned to the first captain's team and '2' otherwise.
	// 
	// DEFINITION
	// Class:TeamsSelection
	// Method:simulate
	// Parameters:int[], int[]
	// Returns:String
	// Method signature:String simulate(int[] preference1, int[] preference2)
	// 
	// 
	// CONSTRAINTS
	// -preference1 will contain N elements, where N is between 2 and 50, inclusive.
	// -Elements of preference1 will contain each of the numbers from 1 to N exactly once.
	// -preference2 will contain N elements.
	// -Elements of preference2 will contain each of the numbers from 1 to N exactly once.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {1, 2, 3, 4}
	// {1, 2, 3, 4}
	// 
	// Returns: "1212"
	// 
	// There are 4 boys to be divided between the two captains. Both captains believe that boy 1 plays best, then come boy 2 and boy 3, and boy 4 plays worst. Thus, the first captain will choose boy 1, the second captain will choose boy 2, since boy 1 is already assigned to a team, then the first captain will choose boy 3 and in the end the second captain will take boy 4.
	// 
	// 1)
	// {3, 2, 1}
	// {1, 3, 2}
	// 
	// Returns: "211"
	// 
	// The first captain will choose boy 3, the second captain will choose boy 1 and then the first captain will choose boy 2. Note that when there is an odd number of children, the first team ends up one man larger.
	// 
	// 2)
	// {6, 1, 5, 2, 3, 4}
	// {1, 6, 3, 4, 5, 2}
	// 
	// Returns: "212211"
	// 
	// 
	// 
	// 3)
	// {8, 7, 1, 2, 4, 5, 6, 3, 9}
	// {7, 2, 4, 8, 1, 5, 9, 6, 3}
	// 
	// Returns: "121121212"
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
