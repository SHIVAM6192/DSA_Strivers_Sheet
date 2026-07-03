import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//class Edge{
//    int v;
//    int wt;
//    Edge(int v, int wt){
//        this.v = v;
//        this.wt = wt;
//    }
//}

public class DijkstrasAlgorithm {
    public static void dijkstras(int s, ArrayList<ArrayList<Edge>> g, int v){
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (distance, src) -> Integer.compare(distance[0], src[0])
        );

        pq.add(new int[]{0, s});

        while (!pq.isEmpty()){
            int u = pq.poll()[1];  // we take the edge here

            for (Edge e : g.get(u)){  // perform edge relaxation step
                if (dist[e.v] > dist[u] + e.wt){
                    dist[e.v] = dist[u] + e.wt;
                    pq.add(new int[]{dist[e.v], e.v});
                }
            }
        }

        for (int i = 0; i < v; i++){
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int v = 6;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        // Initialize each vertex with empty string
        for (int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));

        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 7));

        graph.get(2).add(new Edge(4, 3));

        graph.get(3).add(new Edge(5,1));

        graph.get(4).add(new Edge(3, 2));
        graph.get(4).add(new Edge(5,5));

        dijkstras(0, graph, v);
    }
}
