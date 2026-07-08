package GraphQuestions;

import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];
            graph.get(u).add(new int[]{v,wt});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>(); // the array will store node, cost and k(total number of stops)

        dist[src] = 0;
        q.add(new int[]{src, 0, -1});  // initial K value will be -1

        while (!q.isEmpty()){
            int[] curr = q.poll();
            int u = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            for (int[] neb : graph.get(u)){
                int v = neb[0];
                int wt = neb[1];
                if (dist[v] > cost + wt && stops + 1 <= k){
                    dist[v] = cost + wt;
                    q.add(new int[]{v, dist[v], stops + 1});
                }
            }

        }

        if (dist[dst] == Integer.MAX_VALUE) return -1;

        return dist[dst];
    }
    public static void main(String[] args) {
        int[][] arr = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(findCheapestPrice(4,arr,0,3,1));
    }
}
