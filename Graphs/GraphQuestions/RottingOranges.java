package GraphQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        for (boolean[] arr : vis){
            Arrays.fill(arr, false);
        }

        Queue<int[]> q = new LinkedList<>();

        int ans = 0;

        // Pushing all rotten oranges in queue with time 0
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 2){
                    q.offer(new int[] {i, j, 0});  // {i, j, time}
                    vis[i][j] = true; // Mark as visited
                }
            }
        }

        // BFS
        while (!q.isEmpty()){
            int[] arr = q.poll();
            int i = arr[0];
            int j = arr[1];
            int time = arr[2];

            ans = Math.max(ans, time);

            // top
            if (i - 1 >= 0 && !vis[i - 1][j] && grid[i - 1][j] == 1){
                q.add(new int[]{i - 1, j, time + 1});
                vis[i - 1][j] = true;
            }

            // right
            if (j + 1 < m && !vis[i][j + 1] && grid[i][j + 1] == 1){
                q.add(new int[]{i, j + 1, time + 1});
                vis[i][j + 1] = true;
            }

            // bottom
            if (i + 1 < n && !vis[i+1][j] && grid[i+1][j] == 1){
                q.add(new int[]{i+1, j, time + 1});
                vis[i+1][j] = true;
            }

            //left
            if (j - 1 >= 0 && !vis[i][j-1] && grid[i][j-1] == 1){
                q.add(new int[]{i, j-1, time + 1});
                vis[i][j-1] = true;
            }
        }

        // Check if there any unvisited fresh orange
        // If there is at-least 1 fresh orange after BFS traversal then return -1
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1 && !vis[i][j]){
                    return -1;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = {
                    {2,1,1},
                    {1,1,0},
                    {0,1,1}};
        System.out.println(orangesRotting(arr) +" Minutes");
    }
}
