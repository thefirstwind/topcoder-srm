import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class ConnectingGameDiv2
{
    Hashtable<Character, HashSet<Character>> adjList = new Hashtable<Character, HashSet<Character>>();
    Hashtable<Character, Integer> weight = new Hashtable<Character, Integer>();
    int minCost = (int) 1e9;
    int[][] direct = {{0, 1} ,{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1},{-1, 0}, {-1, 1} };
    int n, m;
    int MAX_INT = (int) 1e9;
    boolean[][] seen;

    /**
     * SSSP from left of board to right of board
     * all 8 directions of the 3 * 3 square are treated as connected
     * steps:
     *      color board
     *      define nodes and edge weights
     *      run dijkstra
     * @param board
     * @return
     */
	public int getmin(String[] board)
	{
        n = board.length;
        m = board[0].length();
        seen = new boolean[n][m];
        floodfill(board, 0, 0);
        char start = '^', end = '$';
        adjList.put(start, new HashSet<Character>());
        adjList.put(end, new HashSet<Character>());
        weight.put(start, 0);
        weight.put(end, 0);
        for (int i = 0; i < n; i++) {
            adjList.get(start).add(board[i].charAt(0));
            adjList.get(board[i].charAt(m - 1)).add(end);
        }
        dijkstra(start, end);
        return minCost;
	}
    class Node implements Comparable<Node> {
        char c;
        int w;
        public Node(char cc, int ww) {
            this.c = cc;
            this.w = ww;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    private void dijkstra(char start, char end) {
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        Hashtable<Character, Integer> dist = new Hashtable<Character, Integer>();
        q.add(new Node(start, 0));
        dist.put(start, 0);
        for (char c : weight.keySet()) {
            if (c != start) {
                q.add(new Node(c, MAX_INT));
                dist.put(c, MAX_INT);
            }
        }
        while (!q.isEmpty()) {
            Node e = q.poll();
            if (dist.get(e.c) < e.w) continue;
            dist.put(e.c, e.w);
            for (char child : adjList.get(e.c)) {
                int newDist = e.w + weight.get(e.c);
                int oldDist = dist.get(child);
                if (oldDist > newDist) {
                    dist.put(child, newDist);
                    q.add(new Node(child, newDist));
                }
            }
        }
        minCost = dist.get(end);
    }

    private void floodfill(String[] board, int r, int c) {
        seen[r][c] = true;
        char curr = board[r].charAt(c);
        if (weight.containsKey(curr)) {
            weight.put(curr, weight.get(curr) + 1);
        } else {
            weight.put(curr, 1);
            adjList.put(curr, new HashSet<Character>());
        }
        for (int[] d : direct) {
            int rr = r + d[0];
            int cc = c + d[1];
            if (rr >= 0 && rr < n && cc >= 0 && cc < m) {
                char adjCurr = board[rr].charAt(cc);
                if (adjCurr != curr) {
                    adjList.get(curr).add(adjCurr);
                }
                if (!seen[rr][cc]) floodfill(board, rr, cc);
            }
        }
    }

    // BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		ConnectingGameDiv2 obj;
		int answer;
		obj = new ConnectingGameDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.getmin(p0);
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
			res = answer == p1;
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
		
		String[] p0;
		int p1;
        // ----- test 0 -----
        p0 = new String[]{"1"};
        p1 = 1;
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;

		// ----- test 0 -----
		p0 = new String[]{"AA","BC"};
		p1 = 2;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"AAB","ACD","CCD"};
		p1 = 4;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"iii","iwi","iii"};
		p1 = 8;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"rng58","Snuke","Sothe"};
		p1 = 6;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"yyAArJqjWTH5","yyEEruYYWTHG","hooEvutpkkb2","OooNgFFF9sbi","RRMNgFL99Vmm","R76XgFF9dVVV","SKnZUPf88Vee"};
		p1 = 14;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Cat Snuke and wolf Sothe are playing the Connecting Game.
	// 
	// The Connecting Game is played on a rectangular grid that is divided into unit square cells.
	// The grid is divided into some regions.
	// Each cell belongs into exactly one of those regions.
	// Each region is 4-connected (see Notes for a formal definition).
	// 
	// You are given a String[] board that describes the division of the grid into regions.
	// Each character in board represents one of the cells.
	// Cells that are represented by the same character belong into the same region.
	// 
	// Initially, the entire grid is colorless.
	// The game consists of two steps.
	// In the first step, Snuke colors some of the regions red.
	// In the second step, Sothe colors all remaining regions blue.
	// (Within each region, all cells must have the same color.)
	// Sothe wins if there is a path (see Notes for a formal definition) of blue cells from the top row to the bottom row.
	// Otherwise, Snuke wins.
	// 
	// You are given the String[] board.
	// Compute and return the smallest number of cells Snuke can color red in order to win the game.
	// 
	// (Note that Snuke cannot simply color individual cells, he must color entire regions.
	// Also note that we are interested in minimizing the total number of cells, not the number of regions Snuke colors.)
	// 
	// DEFINITION
	// Class:ConnectingGameDiv2
	// Method:getmin
	// Parameters:String[]
	// Returns:int
	// Method signature:int getmin(String[] board)
	// 
	// 
	// NOTES
	// -A path is a sequence of cells such that each pair of consecutive cells shares a common side.
	// -A region is 4-connected if for any two cells A and B in that region there is a path that starts with A, ends with B, and only contains cells from that region.
	// 
	// 
	// CONSTRAINTS
	// -board will contain between 1 and 50 elements, inclusive.
	// -Each element in board will contain between 1 and 50 characters, inclusive.
	// -All elements in board will have the same length.
	// -Each character in board will be a letter or a digit ('a'-'z', 'A'-'Z', or '0'-'9').
	// -Each of the regions in board will be 4-connected.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"AA"
	// ,"BC"}
	// 
	// Returns: 2
	// 
	// If Snuke colors 0 or 1 cells red, he will lose the game. He can win the game by coloring 2 cells red. One possibility is to color the two 'A' cells red.
	// 
	// 1)
	// {"AAB"
	// ,"ACD"
	// ,"CCD"}
	// 
	// Returns: 4
	// 
	// Here, one optimal solution is to color the regions 'B' and 'C' red. There will be 1 + 3 = 4 red cells.
	// 
	// 2)
	// {"iii"
	// ,"iwi"
	// ,"iii"}
	// 
	// Returns: 8
	// 
	// 
	// 
	// 3)
	// {"rng58"
	// ,"Snuke"
	// ,"Sothe"}
	// 
	// Returns: 6
	// 
	// 
	// 
	// 4)
	// {"yyAArJqjWTH5","yyEEruYYWTHG","hooEvutpkkb2","OooNgFFF9sbi","RRMNgFL99Vmm","R76XgFF9dVVV","SKnZUPf88Vee"}
	// 
	// Returns: 14
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
