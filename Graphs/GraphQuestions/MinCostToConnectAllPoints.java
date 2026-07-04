package GraphQuestions;

import java.util.PriorityQueue;

// https://leetcode.com/problems/min-cost-to-connect-all-points
public class MinCostToConnectAllPoints {

    /* We need to calculate Manhattan Distance between points
     Ex: P1(x1,y1) P2(x2,y2)
        d = |x1-x2| + |y1-y2|

    */

    public static int manDistance(int[][] points, int p1, int p2){
        return Math.abs(points[p1][0] - points[p2][0]) +
                Math.abs(points[p1][1] - points[p2][1]);
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (int[] wt, int[] v) -> Integer.compare(wt[0], v[0]));
        boolean[] mstSet = new boolean[n];
        int mstCost = 0;
        pq.add(new int[]{0,0});

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int wt = curr[0];
            int u = curr[1];

            if(mstSet[u]) continue;;

            mstSet[u] = true;
            mstCost += wt;

            for (int i=0; i<n; i++){
                if (!mstSet[i]){
                    int edgeWt = manDistance(points, u, i);
                    pq.add(new int[]{edgeWt, i});
                }
            }

        }

        return mstCost;
    }
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int minCost = minCostConnectPoints(points);
        System.out.println("Minimum Cost: " + minCost);
    }
}
