package GraphQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n==1 || n==2){
            for(int i = 0; i<n; i++){
                ans.add(i);
            }
            return ans;
        }

        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            degree[edge[0]]++;
            adj.get(edge[0]).add(edge[1]);
            degree[edge[1]]++;
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(degree[i] == 1)  q.add(i);
        }

        while(!q.isEmpty()){
            ans = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                int el = q.remove();
                ans.add(el);
                for(int neb : adj.get(el)){
                    degree[neb]--;
                    if(degree[neb] == 1)  q.add(neb);
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] edges = {{1,0},{1,2},{1,3}};
        int n = 4;
        List<Integer> res = findMinHeightTrees(n, edges);
        System.out.println(res.toString());
    }
}
