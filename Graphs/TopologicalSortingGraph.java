import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortingGraph {
    int size;
    List<List<Integer>> list = new ArrayList<>();

    public TopologicalSortingGraph(int size){
        this.size = size;

        for (int i = 0; i < size; i++){
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        list.get(u).add(v);  // Only directed edges
    }

    public void dfs(int curr, boolean[] vis, Stack<Integer> st){
        vis[curr] = true;

        for (int v : list.get(curr)){
            if (!vis[v]){
                dfs(v, vis, st);
            }
        }

        st.push(curr);
    }

    public String topologicalSorting(){
        boolean[] vis = new boolean[size];
        Stack<Integer> st = new Stack<>();


        for (int i = 0; i < size; i++){
            if (!vis[i])
                dfs(i, vis, st);
        }

        String sorted = "";
        while (!st.isEmpty()){
            sorted = sorted + st.pop() + " -> ";
        }

        return sorted;
    }

    public static void main(String[] args) {
        TopologicalSortingGraph topologicalSort = new TopologicalSortingGraph(6);

        topologicalSort.addEdge(5, 0);
        topologicalSort.addEdge(5, 2);
        topologicalSort.addEdge(2, 3);
        topologicalSort.addEdge(3, 1);
        topologicalSort.addEdge(4, 1);
        topologicalSort.addEdge(4, 0);

        String sorted = topologicalSort.topologicalSorting();
        System.out.println(sorted);
    }
}
