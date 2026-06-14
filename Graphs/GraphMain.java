import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphMain {
    int size;
    List<List<Integer>> list = new ArrayList<>();

    public GraphMain(int size){
        this.size = size;

        for (int i = 0; i < size; i++){
            list.add(new ArrayList<>());
        }

    }

    public void addEdge(int u, int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }
}
