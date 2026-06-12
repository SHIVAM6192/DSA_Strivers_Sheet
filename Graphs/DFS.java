import java.util.*;
import java.util.LinkedList;

class GraphDFS{
    int size;
    List<List<Integer>> list = new ArrayList<>();

    public GraphDFS(int size){
        this.size = size;

        for (int i = 0; i < size; i++){
            list.add(new ArrayList<>());
        }

    }

    public void addEdge(int u, int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public void graphDFS(int startNode, boolean[] visited){
        System.out.print(startNode + " ");
        visited[startNode] = true;

        for (int neb : list.get(startNode)){
            if(!visited[neb]){
                graphDFS(neb, visited);
            }
        }
    }

    public void dfs(){
        int startNode = 0;
        boolean[] visited = new boolean[this.size];
        Arrays.fill(visited, false);

        graphDFS(startNode, visited);
    }


}
public class DFS {
    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS(7);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(2, 6);

        graph.dfs();
    }
}
