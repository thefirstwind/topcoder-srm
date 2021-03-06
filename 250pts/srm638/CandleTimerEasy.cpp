#include <vector>
#include <array>
#include <list>
#include <map>
#include <set>
#include <queue>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;


class CandleTimerEasy {
public:
    int differentTime(vector <int> A, vector <int> B, vector <int> len) {
        const int nn = 50;
        int n = (int) A.size() + 1;
        int edge[nn][nn] = {};
        int degree[nn] = {};
        const int MAX_INT = (int) 1e9;
        for (int i = 0; i < A.size(); i++) {
            edge[A[i]][B[i]] = edge[B[i]][A[i]] = len[i];
            degree[A[i]]++;
            degree[B[i]]++;
        }
        int nLeaves = 0;
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1) nLeaves++;
        }
        map<int,int> results;
        for (int bitmask = 1; bitmask < (1 << nLeaves); bitmask++) {
            array<int, nn> dist;
            
            dist.fill(MAX_INT);
            queue<int> q;
            
            int currLeaf = 0;
            for (int i = 0; i < n; ++i) {
                if (degree[i] == 1) {
                    if ((bitmask & (1 << currLeaf)) != 0) {
                        dist[i] = 0;
                        q.push(i);
                    }
                    currLeaf++;
                }
            }
            while (!q.empty()) {
                int curr = q.front(); q.pop();
                for (int i = 0; i < n; ++i) {
                    if (edge[curr][i] != 0) {
                        if (dist[i] > dist[curr] + edge[curr][i]) {
                            dist[i] = dist[curr] + edge[curr][i];
                            q.push(i);
                        }
                    }
                }
            }
            int currMax = 0;
            for (int i = 0; i < A.size(); ++i) {
                currMax = max(currMax, dist[A[i]] + dist[B[i]] + len[i]);
            }
            if (currMax != 0) {
                results[currMax] = 1;
            }
        }
        return results.size();
    }
};


// BEGIN KAWIGIEDIT TESTING
// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
#include <iostream>
#include <string>
#include <vector>
using namespace std;
bool KawigiEdit_RunTest(int testNum, vector <int> p0, vector <int> p1, vector <int> p2, bool hasAnswer, int p3) {
    cout << "Test " << testNum << ": [" << "{";
    for (int i = 0; int(p0.size()) > i; ++i) {
        if (i > 0) {
            cout << ",";
        }
        cout << p0[i];
    }
    cout << "}" << "," << "{";
    for (int i = 0; int(p1.size()) > i; ++i) {
        if (i > 0) {
            cout << ",";
        }
        cout << p1[i];
    }
    cout << "}" << "," << "{";
    for (int i = 0; int(p2.size()) > i; ++i) {
        if (i > 0) {
            cout << ",";
        }
        cout << p2[i];
    }
    cout << "}";
    cout << "]" << endl;
    CandleTimerEasy *obj;
    int answer;
    obj = new CandleTimerEasy();
    clock_t startTime = clock();
    answer = obj->differentTime(p0, p1, p2);
    clock_t endTime = clock();
    delete obj;
    bool res;
    res = true;
    cout << "Time: " << double(endTime - startTime) / CLOCKS_PER_SEC << " seconds" << endl;
    if (hasAnswer) {
        cout << "Desired answer:" << endl;
        cout << "\t" << p3 << endl;
    }
    cout << "Your answer:" << endl;
    cout << "\t" << answer << endl;
    if (hasAnswer) {
        res = answer == p3;
    }
    if (!res) {
        cout << "DOESN'T MATCH!!!!" << endl;
    } else if (double(endTime - startTime) / CLOCKS_PER_SEC >= 2) {
        cout << "FAIL the timeout" << endl;
        res = false;
    } else if (hasAnswer) {
        cout << "Match :-)" << endl;
    } else {
        cout << "OK, but is it right?" << endl;
    }
    cout << "" << endl;
    return res;
}
int main() {
    bool all_right;
    all_right = true;
    
    vector <int> p0;
    vector <int> p1;
    vector <int> p2;
    int p3;
    
    {
        // ----- test 0 -----
        int t0[] = {0,1};
        p0.assign(t0, t0 + sizeof(t0) / sizeof(t0[0]));
        int t1[] = {1,2};
        p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
        int t2[] = {10,1};
        p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
        p3 = 2;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
        // ------------------
    }
    
    {
        // ----- test 1 -----
        int t0[] = {0,0,0};
        p0.assign(t0, t0 + sizeof(t0) / sizeof(t0[0]));
        int t1[] = {1,2,3};
        p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
        int t2[] = {1,1,1};
        p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
        p3 = 2;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
        // ------------------
    }
    
    {
        // ----- test 2 -----
        int t0[] = {0,0,0};
        p0.assign(t0, t0 + sizeof(t0) / sizeof(t0[0]));
        int t1[] = {1,2,3};
        p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
        int t2[] = {1,2,3};
        p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
        p3 = 4;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
        // ------------------
    }
    
    {
        // ----- test 3 -----
        int t0[] = {0,1,1,2,3,3,2,4};
        p0.assign(t0, t0 + sizeof(t0) / sizeof(t0[0]));
        int t1[] = {1,2,3,4,5,6,7,8};
        p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
        int t2[] = {5,3,2,4,6,8,7,1};
        p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
        p3 = 7;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
        // ------------------
    }
    
    {
        // ----- test 4 -----
        int t0[] = {0,0,0,0};
        p0.assign(t0, t0 + sizeof(t0) / sizeof(t0[0]));
        int t1[] = {1,2,3,4};
        p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
        int t2[] = {123,456,789,1000};
        p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
        p3 = 8;
        all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
        // ------------------
    }
    
    {
        // ----- test 5 -----
        int t0[] = {0};
        p0.assign(t0, t0 + sizeof(t0) / sizeof(t0[0]));
        int t1[] = {1};
        p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
        int t2[] = {1000};
        p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
        p3 = 2;
        all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
        // ------------------
    }
    
    if (all_right) {
        cout << "You're a stud (at least on the example cases)!" << endl;
    } else {
        cout << "Some of the test cases had errors." << endl;
    }
    return 0;
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
// You are given a description of the tree as three vector <int>s: a, b, and len, with N elements each.
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
// Parameters:vector <int>, vector <int>, vector <int>
// Returns:int
// Method signature:int differentTime(vector <int> A, vector <int> B, vector <int> len)
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
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
