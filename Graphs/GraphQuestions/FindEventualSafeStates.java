package GraphQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/find-eventual-safe-states
public class FindEventualSafeStates {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        HashMap<Integer, Boolean> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i=0;i<n;i++){
            if (dfs(i, graph, map)){
                result.add(i);
            }
        }

        return result;
    }

    public static boolean dfs(int node, int[][] graph, HashMap<Integer, Boolean> map){
        if (map.containsKey(node)){
            return map.get(node);
        }

        map.put(node, false);

        for (int neighbour : graph[node]){
            if (!dfs(neighbour, graph, map)){
                return false;
            }
        }

        map.put(node, true);
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }
}
