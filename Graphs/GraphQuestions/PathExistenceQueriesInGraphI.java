package GraphQuestions;

import java.util.Arrays;

// https://leetcode.com/problems/path-existence-queries-in-a-graph-i
public class PathExistenceQueriesInGraphI {
    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp = new int[n];
        boolean[] ans = new boolean[queries.length];
        comp[0] = 0;

        for(int i = 1; i < n; i++){
            int diff = Math.abs(nums[i] - nums[i-1]);
            if(diff <= maxDiff){
                comp[i] = comp[i-1];
            }
            else{
                comp[i] = i;
            }
        }

        for(int i = 0; i < queries.length; i++){
            int node1 = queries[i][0];
            int node2 = queries[i][1];
            if(comp[node1] == comp[node2]){
                ans[i] = true;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int n = 4, maxDiff = 2;
        int [] nums = {2,5,6,8};
        int[][] queries = {{0,1},{0,2},{1,3},{2,3}};
        boolean[] ans = pathExistenceQueries(n, nums, maxDiff, queries);
        System.out.println(Arrays.toString(ans));
    }
}
