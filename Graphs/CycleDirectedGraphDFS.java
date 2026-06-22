import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleDirectedGraphDFS {
    int size;
    List<List<Integer>> list = new ArrayList<>();

    public CycleDirectedGraphDFS(int size){
        this.size = size;

        for (int i = 0; i < size; i++){
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        list.get(u).add(v);  // Only directed edges
    }

    public boolean isCycle(){
        boolean[] vis = new boolean[size];
        boolean[] recPath = new boolean[size];

        for (int i = 0; i < size; i++){
            if (!vis[i]){
                if(isCycleDirDFS(i, vis, recPath)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCycleDirDFS(int curr, boolean[] vis, boolean[] recPath){
        vis[curr] = true;
        recPath[curr] = true;

        for(int v : list.get(curr)){
            if (!vis[v]){
                if(isCycleDirDFS(v, vis, recPath)){
                    return true;
                }
            }
            else if (recPath[v]){
                return true;
            }
        }

        recPath[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        CycleDirectedGraphDFS cycleInGraph = new CycleDirectedGraphDFS(5);

        cycleInGraph.addEdge(0, 1);
        cycleInGraph.addEdge(1, 2);
        cycleInGraph.addEdge(2, 3);
        cycleInGraph.addEdge(3, 1);

        System.out.println(cycleInGraph.isCycle());
    }
}
