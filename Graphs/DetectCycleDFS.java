import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleDFS {
    int size;
    List<List<Integer>> list = new ArrayList<>();

    public DetectCycleDFS(int size){
        this.size = size;

        for (int i = 0; i < size; i++){
            list.add(new ArrayList<>());
        }

    }

    public void addEdge(int u, int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public boolean hasCycle(){
        boolean[] visited = new boolean[size];
        Arrays.fill(visited, false);

        // we need to do this cuz graph can be disconnected
        for (int i = 0; i < size; i++){
            if (!visited[i]){
                if (dfs(i, visited,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int v, boolean[] visited, int parent){
        visited[v] = true;

        for (int neb : list.get(v)){
            // If an adjacent vertex is not visited,
            // then recur for that adjacent
            if (!visited[neb]){
                if(dfs(neb, visited, v)){
                    return true;
                }
            }
            // If an adjacent vertex is visited and is not
            // parent of current vertex,
            // then there exists a cycle in the graph.
            else if (neb != parent){
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        DetectCycleDFS graph = new DetectCycleDFS(7);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 0);
        graph.addEdge(2, 6);

        System.out.println(graph.hasCycle());


    }
}
