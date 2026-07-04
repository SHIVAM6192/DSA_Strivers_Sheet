// We use Prim's Algorithm to find Minimum Spanning Tree in Graph
/* Graph should be :-
    -- Connected
    -- Directed
    -- Weighted

    Spanning Tree in Graph means: All verteces are connected and they are connected with
    exactly V-1 edges. Every vertex must be connected with only one edge.
    Ex: 5 Verteses then edges must be 1.

    Minimum Spanning tree means: The tree which has the minimum sum of weight in all
    possible spanning tree's.
*/

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static int minCostMST(int src, ArrayList<ArrayList<Edge>> g, int V){
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.wt - b.v );
        boolean[] inMST = new boolean[V];
        pq.add(new Edge(src,0));
        int minCost = 0;

        while (!pq.isEmpty()){
            Edge e = pq.poll();
            if (!inMST[e.v]){
                inMST[e.v] = true;
                minCost += e.wt;
                for (Edge edge : g.get(e.v)){
                    pq.add(new Edge(edge.v, edge.wt));
                }
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        // Initialize each vertex with empty string
        for (int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1,10));
        graph.get(0).add(new Edge(3,30));
        graph.get(0).add(new Edge(2,15));

        graph.get(1).add(new Edge(3,40));
        graph.get(3).add(new Edge(2,50));

        int minCost = minCostMST(0, graph, 4);
        System.out.println("Minimum Cost Spanning Tree: " + minCost);
    }
}
