package FloydWarshall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
    int v;
    int wt;

    Edge(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}

public class FloydWarshall {
    int V;
    List<List<Edge>> list = new ArrayList<>();

    public FloydWarshall(int size){
        this.V = size;

        for (int i = 0; i < V; i++){
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int wt){
        list.get(u).add(new Edge(v, wt));  // Only directed edges
    }

    public void floydWarshall(){
        int inf = Integer.MAX_VALUE;
        int[][] dist = new int[V][V];

        for (int[] a : dist){
            Arrays.fill(a, inf);
        }
        for (int i = 0; i < V; i++){
            dist[i][i] = 0;
        }

        for (int  u =0; u < V; u++){
            for (Edge edge : list.get(u)){
                int v = edge.v;
                int wt = edge.wt;
                dist[u][v] = wt;
            }
        }

        for (int k = 0;  k < V; k++){
            for (int i=0; i<V; i++){
                for (int j=0; j<V; j++){
                    if (dist[i][k] != inf && dist[k][j] != inf){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Print
        for (int i=0; i<V; i++){
            for (int j=0; j<V; j++){
                if (dist[i][j] == inf){
                    System.out.print("INF ");
                }
                else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }

        // Check for negative weighted cycle
        for (int i=0; i<V; i++){
            if (dist[i][i] < 0){
                System.out.println("Negative weighted cycle detected!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        FloydWarshall graph = new FloydWarshall(4);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 11);
        graph.addEdge(1, 2, 2);
//        graph.addEdge(1, 3, 8);
        graph.addEdge(3, 1, -8);
        graph.addEdge(2, 3, 3);

        graph.floydWarshall();
    }
}
