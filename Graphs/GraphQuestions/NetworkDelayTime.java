package GraphQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/network-delay-time
public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (distance, src) -> Integer.compare(distance[0], src[0])
        );

        pq.add(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            for(int[] edge : times){
                int source = edge[0];
                int target = edge[1];
                int weight = edge[2];

                if(source == u){
                    if(dist[target] > dist[u] + weight){
                        dist[target] = dist[u] + weight;
                        pq.add(new int[]{dist[target], target});
                    }
                }
            }

        }

        int minimumTimeDelay = 0;

        for (int i = 1; i <= n; i++) {
            // Some node is unreachable
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            minimumTimeDelay = Math.max(minimumTimeDelay, dist[i]);
        }

        return minimumTimeDelay;
    }

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }


}
