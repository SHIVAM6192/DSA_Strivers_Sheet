package GraphQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/is-graph-bipartite/description/
/*
* We can solve it using adjecent coloring technique
* We can use two color and make sure two adjecent colors are not same
* - If the graph containg cycle and the length of cycle is odd, then that graph could not be
*   satisfy the adjecent coloring rule, so we can say that that graph is not Bipartite
*
* */
public class IsGraphBipartite {
    public boolean colorBFS(int src, int[][] graph, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        color[src] = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int neighbour : graph[node]){
                if (color[neighbour] == -1){
                    // toggle the color
                    // if node color is 1 then neighbour color will be 0 and
                    // if node color is 0 then neighbour color will be 1
                    color[neighbour] = 1 - color[node];
                    queue.add(neighbour);
                }
                else if (color[neighbour] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        // 0 will br blue
        // 1 will be green
        Arrays.fill(color, -1);  // Declare all the colors with -1
        for (int i = 0; i<n; i++){
            if (color[i] == -1){
                if (!colorBFS(i, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsGraphBipartite obj = new IsGraphBipartite();
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println("Is Bipartite: " + obj.isBipartite(graph));

        int[][] graph1 = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println("Is Bipartite: " + obj.isBipartite(graph1));


    }
}
