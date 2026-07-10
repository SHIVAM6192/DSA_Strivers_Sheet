import java.util.*;

// Articulation Point in Graph using Tarjan's Algorithm | Critical Points
public class ArticulationPoint {
    int V;
    List<List<Integer>> list = new ArrayList<>();
    int time;
    int[] dt,low;


    // Graph
    public ArticulationPoint(int size){
        this.V = size;

        for (int i = 0; i < V; i++){
            list.add(new ArrayList<>());
        }

    }

    public void addEdge(int u, int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public void dfs(int u, int parU, Set<Integer> criticalPoint){
        dt[u] = low[u] = ++time;
        int children = 0;

        for (int i = 0; i < list.get(u).size(); i++){
            int v = list.get(u).get(i);
            if(dt[v] == -1){
                children++;
                dfs(v, u, criticalPoint);
                // Update low
                low[u] = Math.min(low[u], low[v]);

                if (parU != -1 && low[v] >= dt[u]){
                    // Articulation point => Critical point
                    criticalPoint.add(u);
                }
            }
            else if (v != parU){
                low[u] = Math.min(low[u],dt[v]);
            }
        }
        if (parU == -1 && children > 1){
            // Articulation point => Critical point
            criticalPoint.add(u);
        }
    }

    public int articulationPoint(){
        time = 0;
        dt = new int[V];
        Arrays.fill(dt, -1);   // dt == -1 means non visited node
        low = new int[V];

        Set<Integer> criticalPoint = new HashSet<>();

        for (int i = 0; i < V; i++){
            if (dt[i] == -1){
                dfs(i, -1, criticalPoint);
            }
        }

        // Print critical point
        System.out.print("Critical points: ");
        for (int point : criticalPoint){
            System.out.print(point + " ");
        }

        return criticalPoint.size();
    }

    public static void main(String[] args) {
        ArticulationPoint ap = new ArticulationPoint(6);
        ap.addEdge(1, 0);
        ap.addEdge(1, 2);
        ap.addEdge(4, 3);
        ap.addEdge(4, 5);
        ap.addEdge(4, 1);

        System.out.println("\nNumber of critical point: " +ap.articulationPoint());

    }

}
