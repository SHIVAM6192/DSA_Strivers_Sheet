package GraphQuestions;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/course-schedule-ii/description/
public class CourseScheduleII {

    public boolean isCycleDFS(int src, boolean[] vis, boolean[] recPath, int[][] edges){
        vis[src] = true;
        recPath[src] = true;

        for (int i = 0;  i < edges.length; i++){
            int v = edges[i][0];
            int u = edges[i][1];

            if (u == src){
                if (!vis[v]){
                    if (isCycleDFS(v, vis, recPath, edges)){
                        return true;
                    }
                }
                else if (recPath[v]){
                    return true;
                }
            }
        }

        recPath[src] = false;
        return false;
    }

    // TopologicalOrder
    void topoOrder(int src, boolean[] vis, Stack<Integer> st, int[][] edges){
        vis[src] = true;

        for (int i = 0; i < edges.length; i++){
            int v = edges[i][0];
            int u = edges[i][1];

            if (u == src){
                if (!vis[v]){
                    topoOrder(v, vis, st, edges);
                }
            }
        }

        st.push(src);
    }


    public int[] findOrder(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        boolean[] recPath = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!vis[i]){
                if (isCycleDFS(i, vis, recPath, edges)){
                    return new int[]{};
                }
            }
        }

        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(vis, false);

        for (int i = 0; i < n; i++){
            if (!vis[i]){
                topoOrder(i, vis, st, edges);
            }
        }

        int i = 0;
        while (!st.isEmpty() && i < n){
            ans[i] = st.pop();
            i++;
        }

        return ans;
    }
    public static void main(String[] args) {
        CourseScheduleII obj = new CourseScheduleII();

        int[][] courses = {{1,0},{2,0},{3,1},{3,2}};
        int numCourses = 4;

        int[] result = obj.findOrder(numCourses, courses);

        System.out.println(Arrays.toString(result));
    }
}
