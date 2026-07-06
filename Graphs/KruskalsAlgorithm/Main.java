package KruskalsAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge>{
    public int u;
    public int v;
    public int wt;

    public Edge(int u, int v, int wt){
        this.u = u;
        this.v = v;
        this.wt = wt;
    }

    // We are doing comparison to sort according to edge weight
    @Override
    public int compareTo(Edge other){
        // Returns a negative integer, zero, or a positive integer as this.wt
        // is less than, equal to, or greater than other.wt
        return Integer.compare(this.wt, other.wt);
        // Note: You could also use 'return this.wt - other.wt;', but
        // Integer.compare is safer as it avoids potential integer overflow issues.
    }
}

class Graph{
    int n;
    ArrayList<Edge> edges;
    int[] par;
    int[] rank;

    Graph(int n){
        this.n = n;
        this.edges = new ArrayList<>();
        par = new int[this.n];
        rank = new int[this.n];
        for (int i = 0; i<n; i++){
            par[i] = i;
            rank[i] = 0;
        }
    }

    public void addEdge(int u, int v, int wt){
        edges.add(new Edge(u,v,wt));
    }

    public int find(int x){
        if (par[x] == x){
            return x;
        }

        return par[x] = find(par[x]);
    }

    public void unionByRank(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) return;

        if (rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }
        else if (rank[parA] > rank[parB]){
            par[parB] = parA;
        }
        else {
            par[parA] = parB;
        }
    }

    // Kruskal's algorithm is best for sparse graph's
    public void kruskals(){
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;  // this to avoid more for loop iterations
        // there will be at-most V-1 edges
        // here n is total number of edges

        for (int i=0; i<edges.size() && count < this.n-1; i++){
            Edge e = edges.get(i);
            int parU = find(e.u);
            int parV = find(e.v);

            if (parU != parV){  // no cycle
                unionByRank(e.u, e.v);
                mstCost += e.wt;
                count++;
            }
        }

        System.out.println("MST cost: " + mstCost);
    }
}
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0,1,10);
        graph.addEdge(0,2,6);
        graph.addEdge(0,3,5);
        graph.addEdge(1,3,15);
        graph.addEdge(2,3,4);

        graph.kruskals();
    }
}
