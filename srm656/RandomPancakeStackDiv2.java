import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class RandomPancakeStackDiv2
{
	public double expectedDeliciousness(int[] d)
	{
		int n = d.length;
		int[] curr = new int[n];
		for (int i = 0; i < n; i++) {
			curr[i] = i;
		}
		int count = 0;
		double total = 0.0;
		do {
			int prev = n;
			int currD = 0;
			for (int p : curr) {
				if (p > prev) {
					break;
				} else {
					prev = p;
					currD += d[p];
				}
			}
			count++;
			total += currD;
		} while (nextPermutation(curr) != 0);
		return total / count;
	}
	/**
	 * get the next permutation in place
	 * @param  num  array of integer
	 * @return int  zero if reached end of perm, one if in middle
	 */
	public static int nextPermutation(int[] num) {
		int size = num.length;
		if (size <= 1) return 0;

		// 1.find the first ascending order pair from the bottom
		int low = size - 2;
		int high = size - 1;
		while (num[low] >= num[high]) {
			if (low == high - 1) {
				low -= 1;
				high = size - 1;
				if (low < 0) break;
			} else {
				high -= 1;
			}
		}

		// reached end of permutation
		if (low < 0) {
			Arrays.sort(num);
			return 0;
		}

		// 2.swap num[lo] with num[hi] if lo >= 0
		int temp = 0;
		temp = num[low];
		num[low] = num[high];
		num[high] = temp;

		// 3.reverse lo+1 .. end
		low = low + 1;
		high = size - 1;
		while (low < high) {
			temp = num[low];
			num[low] = num[high];
			num[high] = temp;
			low++;
			high--;
		}

		return 1;
	}
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, double p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		RandomPancakeStackDiv2 obj;
		double answer;
		obj = new RandomPancakeStackDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.expectedDeliciousness(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == answer && Math.abs(p1 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p1));
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
		double p1;
		
		// ----- test 0 -----
		p0 = new int[]{1,1,1};
		p1 = 1.6666666666666667D;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{10,20};
		p1 = 20.0D;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{3,6,10,9,2};
		p1 = 9.891666666666667D;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{10,9,8,7,6,5,4,3,2,1};
		p1 = 10.999999724426809D;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{1,2,3,4,5,6,7,8,9,10};
		p1 = 7.901100088183421D;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new int[]{1,1,1,1,1,1,1,1,1,1};
		p1 = 1.7182818011463845D;
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// 
	// Charlie has N pancakes.
	// He wants to serve some of them for breakfast.
	// We will number the pancakes 0 through N-1.
	// For each i, pancake i has width i+1 and deliciousness d[i].
	// 
	// 
	// 
	// Charlie chooses the pancakes he is going to serve using the following randomized process:
	// He starts by choosing the first pancake uniformly at random from all the pancakes he has.
	// He places the chosen pancake onto a plate.
	// This pancake now forms the bottom of a future stack of pancakes.
	// Then, Charlie repeats the following procedure:
	// 
	// If there are no more pancakes remaining, terminate.
	// Choose a pancake uniformly at random from the pancakes that have not been chosen yet.
	// If the width of this pancake is greater than the width of the pancake on top of the stack, terminate without taking it.
	// Place the chosen pancake on top of the stack and go back to step 1.
	// 
	// 
	// 
	// 
	// You are given the int[] d with N elements.
	// The total deliciousness of a serving of pancakes is the sum of the deliciousness of all pancakes used in the serving.
	// Compute and return the expected value of the total deliciousness of the pancakes chosen by Charlie.
	// 
	// 
	// DEFINITION
	// Class:RandomPancakeStackDiv2
	// Method:expectedDeliciousness
	// Parameters:int[]
	// Returns:double
	// Method signature:double expectedDeliciousness(int[] d)
	// 
	// 
	// NOTES
	// -Your return value must have an absolute or relative error smaller than or equal to 1e-6
	// 
	// 
	// CONSTRAINTS
	// -The number of elements in d will be between 1 and 10, inclusive.
	// -Each element of d will be between 1 and 100, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {1,1,1}
	// 
	// Returns: 1.6666666666666667
	// 
	// The following scenarios may occur:
	// 
	// With probability 1/3, Charlie chooses pancake 0 first. In this case he won't be able to add any more pancakes and the total deliciousness of his serving of pancakes will be 1.
	// With probability 1/3, Charlie chooses pancake 1 first. What happens in the second round? With probability 1/2 he will choose pancake 0 and with probability 1/2 it will be pancake 2. In the first case the total deliciousness of Charlie's pancakes will be 2, in the second case it will be 1.
	// With probability 1/3, Charlie chooses pancake 2 first. If he chooses pancake 0 next, the total deliciousness of his pancakes will be 2. If he happens to choose pancake 1 next (followed by pancake 0 in the third round), the total deliciousness will be 3.
	// 
	// Summing this up, we get the expected deliciousness to be 1/3 * (1) + 1/3 * (1/2 * 1 + 1/2 * 2) + 1/3 * (1/2 * 2 + 1/2 * 3) = 5/3 = 1.666...
	// 
	// 1)
	// {10,20}
	// 
	// Returns: 20.0
	// 
	// 
	// 
	// 2)
	// {3,6,10,9,2}
	// 
	// Returns: 9.891666666666667
	// 
	// 
	// 
	// 3)
	// {10,9,8,7,6,5,4,3,2,1}
	// 
	// Returns: 10.999999724426809
	// 
	// 
	// 
	// 4)
	// {1,2,3,4,5,6,7,8,9,10}
	// 
	// Returns: 7.901100088183421
	// 
	// 
	// 
	// 5)
	// {1,1,1,1,1,1,1,1,1,1}
	// 
	// Returns: 1.7182818011463845
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
