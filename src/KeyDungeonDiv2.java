import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class KeyDungeonDiv2
{
	public int countDoors(int[] doorR, int[] doorG, int[] keys)
	{
        int n = doorR.length;
        int r = keys[0], g = keys[1], w = keys[2];
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (r >= doorR[i] && g >= doorG[i]) {
                ret++;
            } else {
                int wr = (r >= doorR[i]) ? 0 : doorR[i] - r;
                int wg = (g >= doorG[i]) ? 0 : doorG[i] - g;
                if (w >= wr + wg) {
                    ret++;
                }
            }
        }
        return ret;
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, boolean hasAnswer, int p3) {
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
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}");
		System.out.println("]");
		KeyDungeonDiv2 obj;
		int answer;
		obj = new KeyDungeonDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.countDoors(p0, p1, p2);
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
		int[] p2;
		int p3;
		
		// ----- test 0 -----
		p0 = new int[]{2,0,5,3};
		p1 = new int[]{1,4,0,2};
		p2 = new int[]{2,3,1};
		p3 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{0,1,2,0};
		p1 = new int[]{0,2,3,1};
		p2 = new int[]{0,0,0};
		p3 = 1;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{3,5,4,2,8};
		p1 = new int[]{4,2,3,8,1};
		p2 = new int[]{0,0,10};
		p3 = 5;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{4,5,4,6,8};
		p1 = new int[]{2,1,2,3,5};
		p2 = new int[]{1,2,1};
		p3 = 0;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{41,44,41,57,58,74,84,100,58,2,43,32,82,97,44,13,35,98,96,81,43,77,18,51,27,27,39,39,45,82,59,20,28,93,6,39,64,78,28,85,17,56,3,68,4,0,36,80,41,77};
		p1 = new int[]{67,15,53,36,88,29,26,57,68,99,97,27,51,70,3,49,65,75,35,92,66,0,23,96,38,86,98,31,26,75,30,2,92,78,100,99,38,26,85,74,77,15,16,48,100,88,55,93,99,54};
		p2 = new int[]{39,31,34};
		p3 = 17;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// You are exploring a dungeon.
	// In the dungeon you found some locked doors.
	// Each locked door has some red and some green keyholes (zero or more of each kind).
	// In order to open a door, you must insert fitting keys into all its keyholes simultaneously.
	// Once you open a door, you may take all the keys back and possibly reuse some of them later to open other doors. 
	// 
	// There are three kinds of keys: red, green, and white ones.
	// Each red key fits into any red keyhole.
	// Each green key fits into any green keyhole.
	// Each white key fits into any keyhole (both red and green ones). 
	// 
	// You are given int[]s doorR and doorG.
	// These two int[]s have the same length.
	// For each valid i, the values doorR[i] and doorG[i] describe one of the doors you found:
	// a door with doorR[i] red and doorG[i] green keyholes. 
	// 
	// You are also given the int[] keys with three elements:
	// keys[0] is the number of red keys, keys[1] the number of green keys, and keys[2] the number of white keys you have at the beginning. 
	// 
	// Return the number of doors you can open with keys you have.
	// 
	// DEFINITION
	// Class:KeyDungeonDiv2
	// Method:countDoors
	// Parameters:int[], int[], int[]
	// Returns:int
	// Method signature:int countDoors(int[] doorR, int[] doorG, int[] keys)
	// 
	// 
	// CONSTRAINTS
	// -doorR and doorG will each contain between 1 and 50 elements, inclusive.
	// -doorR and doorG will contain the same number of elements.
	// -Each element of doorR and doorG will be between 0 and 100, inclusive.
	// -keys will contain exactly 3 elements.
	// -Each element of keys will be between 0 and 100, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {2, 0, 5, 3}
	// {1, 4, 0, 2}
	// {2, 3, 1}
	// 
	// Returns: 3
	// 
	// There are 4 doors. You have 2 red keys, 3 green keys, 1 white key.
	// You can open 3 of the doors:
	// 
	// You can open door 0, using 2 red keys and 1 green key.
	// You can open door 1, using 3 green keys and 1 white key. Here you insert the white key into one of the green keyholes.
	// You can't open door 2, for you have only 3 keys that can be inserted into red key holes.
	// You can open door 3, using 2 red keys, 2 green keys, and 1 white key. Here you insert the white key into one of the red keyholes.
	// 
	// 
	// 1)
	// {0, 1, 2, 0}
	// {0, 2, 3, 1}
	// {0, 0, 0}
	// 
	// Returns: 1
	// 
	// You have no key at all, but door 0 also has no keyhole. Therefore, you can open door 0.
	// 
	// 
	// 2)
	// {3, 5, 4, 2, 8}
	// {4, 2, 3, 8, 1}
	// {0, 0, 10}
	// 
	// Returns: 5
	// 
	// 
	// 
	// 3)
	// {4, 5, 4, 6, 8}
	// {2, 1, 2, 3, 5}
	// {1, 2, 1}
	// 
	// Returns: 0
	// 
	// 
	// 
	// 4)
	// {41,44,41,57,58,74,84,100,58,2,43,32,82,97,44,13,35,98,96,81,43,77,18,51,27,
	//  27,39,39,45,82,59,20,28,93,6,39,64,78,28,85,17,56,3,68,4,0,36,80,41,77}
	// {67,15,53,36,88,29,26,57,68,99,97,27,51,70,3,49,65,75,35,92,66,0,23,96,38,86,
	//  98,31,26,75,30,2,92,78,100,99,38,26,85,74,77,15,16,48,100,88,55,93,99,54}
	// {39,31,34}
	// 
	// Returns: 17
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
