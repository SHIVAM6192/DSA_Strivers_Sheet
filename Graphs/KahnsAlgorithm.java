import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Topological Sorting using Kahn's Algorithm
public class KahnsAlgorithm {
    int size;
    List<List<Integer>> list = new ArrayList<>();

    public KahnsAlgorithm(int size){
        this.size = size;

        for (int i = 0; i < size; i++){
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        list.get(u).add(v);  // Only directed edges
    }

    public void topoSort(){
        List<Integer> res = new ArrayList<>();

        int[] inDegree = new int[size];
        for (int u=0; u<size; u++){
            for (int v : list.get(u)){
                inDegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<size; i++){
            if (inDegree[i] == 0){
                q.add(i);
            }
        }

        // BFS
        while (!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);

            for (int v : list.get(curr)){
                inDegree[v]--;
                if(inDegree[v] == 0){
                    q.add(v);
                }
            }
        }

        // Print result
        for (int val : res){
            System.out.print(val + " ");
        }

    }

    public static void main(String[] args) {
        KahnsAlgorithm obj = new KahnsAlgorithm(6);

        obj.addEdge(3,1);
        obj.addEdge(2,3);
        obj.addEdge(4,0);
        obj.addEdge(4,1);
        obj.addEdge(5,0);
        obj.addEdge(5,2);

        obj.topoSort();
    }
}
