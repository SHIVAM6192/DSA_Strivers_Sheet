import java.util.*;
import java.util.LinkedList;

public class DetectCycleBFS {
    int size;
    List<List<Integer>> list = new ArrayList<>();


    public DetectCycleBFS(int size){
        this.size = size;

        for (int i = 0; i < size; i++){
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public boolean isCycle(){
        boolean[] vis = new boolean[size];
        Arrays.fill(vis, false);
        for (int i = 0; i < size; i++){
            if (!vis[i]){
                if (hasCycle(i,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasCycle(int startNode, boolean[] vis){
        record Pair(int nodeVal, int parent){};
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(startNode, -1));

        while (!queue.isEmpty()){
            Pair p = queue.poll();

            // we need to do this cuz graph can be disconnected
            for (int neb : list.get(p.nodeVal)){
                if (!vis[neb]){
                    queue.offer(new Pair(neb, p.nodeVal));
                    vis[neb] = true;
                }
                else if (neb != p.parent){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DetectCycleBFS graph = new DetectCycleBFS(7);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(2, 6);

        System.out.println(graph.isCycle());
    }
}
