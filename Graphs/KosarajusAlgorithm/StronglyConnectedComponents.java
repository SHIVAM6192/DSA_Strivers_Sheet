package KosarajusAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* Kosaraju's Algorithm
* 1. Get nodes in stack(Topological Sort)
* 2. Transpose the graph Ex. 1 --> 2 the transpose will be 1 <-- 2
* 3. Do DFS accordingly to stack nodes on Transpose Graph
*
* We need Directed Graph
* */
public class StronglyConnectedComponents {
    int size;
    List<List<Integer>> list = new ArrayList<>();

    public StronglyConnectedComponents(int size){
        this.size = size;

        for (int i = 0; i < size; i++){
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        list.get(u).add(v);  // Only directed edges
    }

    void topoSort(int curr, boolean[] vis, Stack<Integer> st){
        vis[curr] = true;

        for (int neb : list.get(curr)){
            if (!vis[neb]){
                topoSort(neb, vis, st);
            }
        }

        st.add(curr);
    }

    void dfs(int curr, boolean[] vis, List<List<Integer>> transpose){
        vis[curr] = true;
        System.out.print(curr +" ");

        for (int neb : transpose.get(curr)){
            if (!vis[neb]){
                dfs(neb, vis, transpose);
            }
        }
    }

    public void kosaraju(){
        // Step 1 : Topo Sort
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[size];

        for (int i = 0; i < size; i++){
            if (!vis[i]){
                topoSort(i, vis, st);
            }
        }

        // Step 2 : Transpose graph
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < size; i++){
            transpose.add(new ArrayList<>());
        }

        for (int u =0; u < size; u++){ // u --> v
            vis[u] = false;
            for (int v : list.get(u)){
                transpose.get(v).add(u);  // v --> u
            }
        }

        // Step 3 : DFS on Transpose graph
        // Perform DFS in topological sorted order
        System.out.println("Printing the Strongly Connected Components: ");
        while (!st.isEmpty()){
            int curr = st.pop();

            if (!vis[curr]){
                dfs(curr, vis, transpose);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        StronglyConnectedComponents scc = new StronglyConnectedComponents(5);

        scc.addEdge(0, 2);
        scc.addEdge(0, 3);
        scc.addEdge(1, 0);
        scc.addEdge(2, 1);
        scc.addEdge(3, 4);

        scc.kosaraju();
    }
}
