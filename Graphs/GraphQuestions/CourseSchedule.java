package GraphQuestions;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
    // If the cycle exist in graph then we will never finish our courses
    // In that case we just return false and
    // In all other cases we can finish our courses so return true
    public boolean isCycleDFS(int src, boolean[] vis, boolean[] recPath, int[][] edges){
        vis[src] = true;
        recPath[src] = true;

        for(int i = 0; i < edges.length; i++){
            int v = edges[i][0];
            int u = edges[i][1];

            if(u == src){
                if(!vis[v]){
                    if(isCycleDFS(v, vis, recPath, edges)){
                        return true;
                    }
                }
                else if(recPath[v]){
                    return true;
                }
            }
        }

        recPath[src] = false;  // Backtracking
        return false;
    }

    public boolean canFinish(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        boolean[] recPath = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                if(isCycleDFS(i, vis, recPath, edges)){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;

        System.out.println(courseSchedule.canFinish(numCourses, prerequisites));

        int[][] prerequisites1 = {{1, 0}, {0, 1}};
        int numCourses1 = 2;
        System.out.println(courseSchedule.canFinish(numCourses1, prerequisites1));

    }
}
