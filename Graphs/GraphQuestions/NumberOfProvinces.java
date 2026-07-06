package GraphQuestions;

// https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvinces {
    public static void dfs(int i, int[][] adj, boolean[] vis){
        vis[i] = true;

        for(int j = 0; j < adj[i].length; j++){
            if(adj[i][j] == 1 && !vis[j]){
                dfs(j, adj, vis);
            }
        }
    }

    public static int findCircleNum(int[][] adj) {
        int n = adj.length;
        boolean[] vis = new boolean[n];
        int noOfProvinces = 0;

        for(int i = 0; i<n; i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                noOfProvinces++;
            }
        }

        return noOfProvinces;
    }
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("Number of Provinces: " + findCircleNum(isConnected));
    }
}
