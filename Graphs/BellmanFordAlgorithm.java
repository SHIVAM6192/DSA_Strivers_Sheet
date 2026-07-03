import java.util.ArrayList;
import java.util.Arrays;

/*
* public class Edge {
    int v;
    int wt;
    Edge(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}
* */
public class BellmanFordAlgorithm {
    public static void bellmanFord(int src, ArrayList<ArrayList<Edge>> graph, int v){
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=0; i<v-1; i++){
            for(int u=0; u<v; u++){
                for(Edge e : graph.get(u)){
                    if (dist[e.v] > dist[u] + e.wt){
                        dist[e.v] = dist[u] + e.wt;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }


    public static void main(String[] args) {
        int v = 5;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        // Initialize each vertex with empty string
        for (int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));

        graph.get(1).add(new Edge(4, -1));
        graph.get(1).add(new Edge(2, -4));

        graph.get(4).add(new Edge(3, 2));
        graph.get(4).add(new Edge(4,4));

        bellmanFord(0, graph, v);
    }
}
