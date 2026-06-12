import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graph{
    int size;
    List<List<Integer>> list = new ArrayList<>();

    public Graph(int size){
        this.size = size;

        for (int i = 0; i < size; i++){
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public void printAdjacencyGraph(){
        for(int i = 0; i < list.size(); i++){
            System.out.print(i + " -> ");
            for (Integer node : list.get(i)){
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int startNode){
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[this.size];

        Q.add(startNode);
        visited[startNode] = true;

        while (!Q.isEmpty()){
            int currentNode = Q.poll();
            System.out.print(currentNode + " ");

            for (int neb : list.get(currentNode)){
                if(!visited[neb]){
                    visited[neb] = true;
                    Q.add(neb);
                }
            }
        }
    }
}
public class AdjacencyGraph {
    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

//        graph.printAdjacencyGraph();
        graph.BFS(0);

    }
}
