#line 5 "CandleTimerEasy.cpp" 
#include<bits/stdc++.h> 
using namespace std; 
#define pb push_back 
#define mp make_pair 
#define X first 
#define Y second 
#define fill(A) memset(A,0,sizeof(A)) 
#define Copy(A,B) memcpy(A,B,sizeof(A)) 
#define rep(i,A,B) for(int i=A;i<=(int)(B);i++) 
#define per(i,B,A) for(int i=B;i>=(int)(A);i--) 
#define RE(B,A) for(A::iterator it=B.begin();it!=B.end();++it) 
#define re(i,A) for(int i=0;i<(int)(A);i++) 
#define de(i,A) for(int i=A;i+1;i--) 
#define re1(i,A) for(int i=1;i<(int)(A);i++) 
#define For(i,A,B) for(int i=A;i<B;i++) 
#define all(x) (x).begin(),(x).end() 
#define inf (1<<30) 
#define Mod 10000007 
#define mn 1000111 
#define pi acos(-1) 
#define eps (1e-6) 
#define MAX(A,B) A=max(A,B) 
#define MIN(A,B) A=min(A,B) 
#define sqr(x) ((x)*(x)) 
#define lowbit(x) ((x)&-(x)) 
typedef long long ll; 
typedef pair<int,int> pii; 
typedef map<int,int> mii; 

const int nn=10000; 
vector<int> E[nn],L[nn]; 
int v[nn],inq[nn],q[nn],w[nn],d[nn]; 
int n,ls; 
queue<int> Q; 

void link(int x,int y,int z) { 
  E[x].pb(y);L[x].pb(z); 
  E[y].pb(x);L[y].pb(z); 
  ++inq[x]; 
  ++inq[y];   
} 
class CandleTimerEasy 
{ 
   public: 
  int differentTime(vector <int> A, vector <int> B, vector <int> len) 
  { 
    n=A.size(); 
    rep(i,0,n*2) inq[i]=0,E[i].clear(),L[i].clear(),w[i]=0,d[i]=0,v[i]=0; 
  //  cout<<n<<endl; 
    rep(i,0,n-1) { 
      int x=A[i],y=B[i],z=len[i]; 
      link(x,y,z); 
    //  link(x,i+n,z); 
    //  link(i+n,y,z); 
    } 
    ls=0; 
    rep(i,0,n) if (inq[i]==1) q[++ls]=i,w[i]=ls; 
    if (ls==0) return 2; 
    map<int,int> ma;ma.clear(); 
    int ans=0; 
    rep(mask,1,(1<<ls)-1) { 
      rep(j,0,n) { 
        d[j]=1<<29; 
        v[j]=0; 
        if (w[j]>0) 
        if (mask&(1<<(w[j]-1))) { 
          Q.push(j); 
          d[j]=0; 
          v[j]=1; 
        } 
      } 
      while (Q.size()) { 
        int x=Q.front();v[x]=0;Q.pop(); 
        for(int i=0;i<E[x].size();++i) { 
          int j=E[x][i],z=L[x][i]; 
          if (d[j]>d[x]+z) { 
            d[j]=d[x]+z; 
            if (!v[j]) { 
              v[j]=1;Q.push(j); 
            } 
          } 
        } 
      } 
      int mm=0; 
      rep(i,0,n-1) { 
        int x=A[i],y=B[i],z=len[i]; 
        mm=max(mm,d[x]+d[y]+z);   
      } 
      if (!ma[mm]) { 
        ma[mm]=1,ans++; 
    //    if (mm==1) cout<<' '<<' '<<mask<<endl; 
    //    cout<<mm<<endl; 
      } 
    } 
    return ans; 
  }  
   

}; 


// Powered by FileEdit
// Powered by TZTester 1.01 [25-Feb-2003]
// Powered by CodeProcessorimport java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class CandleTimerEasy {
    /**
     * 1. double the len so we don't get half integers
     * 2. find all pairs shortest paths
     * 3. enum all lighting schemes, simulate with the paths' length
     * find out the longest time of all paths
     * 4. get results in hashset
     *
     * @param A   [description]
     * @param B   [description]
     * @param len [description]
     * @return [description]
     */
    public int differentTime(int[] A, int[] B, int[] len) {
        int n = A.length + 1;
        int[][] dist = new int[n][n];
        int[] degree = new int[n];
        for (int[] arr : dist) {
            Arrays.fill(arr, (int) 1e9);
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int i = 0; i < A.length; i++) {
            dist[A[i]][B[i]] = dist[B[i]][A[i]] = 2 * len[i];
            degree[A[i]]++;
            degree[B[i]]++;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        HashSet<Integer> results = new HashSet<Integer>();
        for (int bitmask = 1; bitmask < (1 << n); bitmask++) {
            if (bitmask == (1 << n) - 2) {
                int a = 1;
            }
            int curr = -1;
            for (int i = 0; i < n; i++) {
                if ((bitmask & (1 << i)) == 0 || degree[i] != 1) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if (degree[j] != 1) continue;
                    if ((bitmask & (1 << j)) != 0) {
                        curr = Math.max(curr, dist[i][j] / 2);
                    } else {
                        curr = Math.max(curr, dist[i][j]);
                    }
                }
            }
            if (curr != -1) {
                results.add(curr);
            }
        }
        return results.size();
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
        CandleTimerEasy obj;
        int answer;
        obj = new CandleTimerEasy();
        long startTime = System.currentTimeMillis();
        answer = obj.differentTime(p0, p1, p2);
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

        // ----- test 4 -----
        p0 = new int[]{0, 0, 0, 0};
        p1 = new int[]{1, 2, 3, 4};
        p2 = new int[]{123, 456, 789, 1000};
        p3 = 8;
        all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 0 -----
        p0 = new int[]{0, 1};
        p1 = new int[]{1, 2};
        p2 = new int[]{10, 1};
        p3 = 2;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = new int[]{0, 0, 0};
        p1 = new int[]{1, 2, 3};
        p2 = new int[]{1, 1, 1};
        p3 = 2;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = new int[]{0, 0, 0};
        p1 = new int[]{1, 2, 3};
        p2 = new int[]{1, 2, 3};
        p3 = 4;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = new int[]{0, 1, 1, 2, 3, 3, 2, 4};
        p1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        p2 = new int[]{5, 3, 2, 4, 6, 8, 7, 1};
        p3 = 7;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = new int[]{0};
        p1 = new int[]{1};
        p2 = new int[]{1000};
        p3 = 2;
        all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // You have a lot of candles.
    // The candles burn at a uniform rate: if you ignite a candle of length L, it will burn completely in L units of time.
    // You can also ignite a candle at both ends, which makes it burn twice as fast.
    //
    //
    //
    // You have arranged some candles into the shape of a tree.
    // You want to use the tree to measure time.
    // At the beginning, you will ingite some leaves of the tree (all at the same time).
    // Then you will just wait and watch the flames spread across the entire tree.
    // (Whenever a flame reaches an inner node of the tree, it spreads to all branches that meet at that node.)
    // Note that you are not allowed to light new flames during the process.
    // The time you will measure is the time between the moment when you lighted the fire(s) and the moment when the last part of the tree finished burning.
    //
    //
    //
    // You are given a description of the tree as three int[]s: a, b, and len, with N elements each.
    // The nodes of the tree are numbered 0 through N, inclusive.
    // For each valid i, there is a candle between the nodes a[i] and b[i] with length len[i].
    //
    //
    //
    // Compute and return the number of different times you can measure when following the above procedure.
    //
    // DEFINITION
    // Class:CandleTimerEasy
    // Method:differentTime
    // Parameters:int[], int[], int[]
    // Returns:int
    // Method signature:int differentTime(int[] A, int[] B, int[] len)
    //
    //
    // CONSTRAINTS
    // -A will contain between 1 and 19 elements, inclusive.
    // -A, B and len will contain same number of elements.
    // -Each element in A will be between 0 and |A|, inclusive.
    // -Each element in B will be between 0 and |A|, inclusive.
    // -Each element in len will be between 1 and 1000, inclusive.
    // -A, B and len will describe a tree.
    //
    //
    // EXAMPLES
    //
    // 0)
    // {0,1}
    // {1,2}
    // {10,1}
    //
    // Returns: 2
    //
    // This tree looks the same as a single candle of length 11. If we light it on one end, we will measure the time 11. If we light it on both ends, we will measure the time 5.5.
    //
    // 1)
    // {0,0,0}
    // {1,2,3}
    // {1,1,1}
    //
    // Returns: 2
    //
    // This time we have 3 ends. If we ignite all of them the time is 1, otherwise the time is 2.
    //
    // 2)
    // {0,0,0}
    // {1,2,3}
    // {1,2,3}
    //
    // Returns: 4
    //
    // We can get 4 different outcomes: 2.5, 3, 4, 5.
    //
    // 3)
    // {0,1,1,2,3,3,2,4}
    // {1,2,3,4,5,6,7,8}
    // {5,3,2,4,6,8,7,1}
    //
    // Returns: 7
    //
    //
    //
    // 4)
    // {0,0,0,0}
    // {1,2,3,4}
    // {123,456,789,1000}
    //
    // Returns: 8
    //
    //
    //
    // 5)
    // {0}
    // {1}
    // {1000}
    //
    // Returns: 2
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
