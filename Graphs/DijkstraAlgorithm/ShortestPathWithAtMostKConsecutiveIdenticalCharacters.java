package DijkstraAlgorithm;

import java.util.*;

// https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters
public class ShortestPathWithAtMostKConsecutiveIdenticalCharacters {
    //Approach Using Dijkstra's
    //Let V = n, E = edges.length, k = max count length, usually Dijkstra is O(E * log(V)), in this problem, E = E*K and V = n*K
    //T.C : O(E*K * log(n*K))
    //S.C : O(V+E) = O(n*K + E*k)

    public static int shortestPath(int n, int[][] edges, String labels, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, wt});
        }

        // Maintain the distance for each node
        int[][] result = new int[n][k+1];
        for (int[] row : result){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Priority Queue to maintain the lowest distance on top
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        result[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()){
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];
            int count = top[2];

            if (d > result[node][count])
                continue;

            if (node == n-1)
                return d;

            if (!adj.containsKey(node))
                continue;

            for (int[] vec : adj.get(node)){
                int adjNode = vec[0];
                int wt = vec[1];

                int newCount = (labels.charAt(node) == labels.charAt(adjNode) ? count + 1 : 1);

                if (newCount > k)
                    continue;

                int newDist = d + wt;
                if (newDist < result[adjNode][newCount]){
                    result[adjNode][newCount] = newDist;
                    pq.offer(new int[]{newDist, adjNode, newCount});
                }
            }
        }


        return -1;
    }
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 1},
                {1, 2, 1},
                {0, 2, 3}
        };

        int n = 3, k = 1;
        String labels = "aab";

        System.out.println(shortestPath(n, edges, labels, k));
    }
}
