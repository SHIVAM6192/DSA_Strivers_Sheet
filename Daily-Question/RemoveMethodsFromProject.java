import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/remove-methods-from-project
public class RemoveMethodsFromProject {
    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] e : invocations){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }

        HashSet<Integer> hs = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        vis[k] = true;
        q.offer(k);

        while(!q.isEmpty()){
            int suspNode = q.poll();
            hs.add(suspNode);
            for(int it : adj.get(suspNode)){
                if(!vis[it]){
                    vis[it] = true;
                    q.offer(it);
                }
            }
        }

        // HS contains all suspicious nodes
        HashSet<Integer> ansSet = new HashSet<>();
        boolean nonBuggyToBuggy = false;

        for(int i=0; i<n; i++){
            for(int it : adj.get(i)){
                if(!hs.contains(i) && hs.contains(it)){
                    nonBuggyToBuggy = true;
                    break;
                }
                else if(!hs.contains(i) && !hs.contains(it)){
                    ansSet.add(i);
                    ansSet.add(it);
                }
            }
            if(!hs.contains(i)) {
                ansSet.add(i);
            }
        }

        if(nonBuggyToBuggy){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = 0; i<n; i++) ans.add(i);
            return ans;
        }

        return new ArrayList<>(ansSet);
    }
    public static void main(String[] args) {
        int n = 5, k = 0;
        int[][] invocations = {{1,2},{0,2},{0,1},{3,4}};
        System.out.println(remainingMethods(n, k, invocations));
    }
}
