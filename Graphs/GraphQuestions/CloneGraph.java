package GraphQuestions;

import java.util.HashMap;

public class CloneGraph {
    public GraphNode graphUtil(GraphNode node, HashMap<GraphNode, GraphNode> mp){
        GraphNode newNode = new GraphNode(node.val);
        mp.put(node, newNode);
        for (GraphNode neighbor : node.neighbors){
            if(!mp.containsKey(neighbor)){
                newNode.neighbors.add(graphUtil(neighbor, mp));
            }
            else {
                newNode.neighbors.add(mp.get(neighbor));
            }
        }
        return newNode;
    }

    public GraphNode cloneGraph(GraphNode node) {
        HashMap<GraphNode, GraphNode> mp = new HashMap<>();

        return graphUtil(node, mp);
    }
    public static void main(String[] args) {

    }
}
