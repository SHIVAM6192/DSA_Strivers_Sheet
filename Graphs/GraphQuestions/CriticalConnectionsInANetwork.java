package GraphQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/critical-connections-in-a-network/description/
public class CriticalConnectionsInANetwork {
    static int time;

    static void dfs(int u, int parU, List<List<Integer>> adj, int[] dt, int[] low, List<List<Integer>> bridges){
        dt[u] = low[u] = ++time;

        for (int i = 0; i < adj.get(u).size(); i++){
            int v = adj.get(u).get(i);
            if (dt[v] == -1){
                dfs(v, u, adj, dt, low, bridges);
                // Update low
                low[u] = Math.min(low[u], low[v]);

                // Bridge condition
                if (low[v] > dt[u]){
                    bridges.add(Arrays.asList(u,v));
                }
            }
            else if (v != parU){
                low[u] = Math.min(low[u], dt[v]);
            }
        }
    }
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections){
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        time = 0;
        int[] dt = new int[n]; // Discovery time
        Arrays.fill(dt, -1);
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if (dt[i] == -1){
                dfs(i, -1, adj, dt, low, bridges);
            }
        }
        return bridges;
    }

    public static void main(String[] args) {
        List<List<Integer>> connections = List.of(
                List.of(0, 1),
                List.of(1, 2),
                List.of(2, 0),
                List.of(1, 3)
        );

        System.out.println(criticalConnections(4,connections));
    }
}
