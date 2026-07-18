package GraphQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/evaluate-division/description
public class EvaluateDivision {
    public double dfs(String src, String target, double prod, HashSet<String>
            visited, HashMap<String, HashMap<String, Double>> map){
        double ret = -1;
        visited.add(src);

        if(map.get(src).containsKey(target)){
            ret = map.get(src).get(target) * prod;
        }
        else{
            for(String neighbour : map.get(src).keySet()){
                if(!visited.contains(neighbour)){
                    ret = dfs(neighbour, target, prod*map.get(src).get(neighbour),
                            visited, map);
                    if(ret != -1){
                        break;
                    }
                }
            }
        }
        visited.remove(src);
        return ret;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Gen adj map
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double res = values[i];

            if(!map.containsKey(dividend)){
                map.put(dividend, new HashMap<String, Double>());
            }
            if(!map.containsKey(divisor)){
                map.put(divisor, new HashMap<String, Double>());
            }

            map.get(dividend).put(divisor, res);
            map.get(divisor).put(dividend, 1/ res);
        }

        double[] res = new double[queries.size()];

        for(int i = 0; i<queries.size(); i++){
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if(!map.containsKey(dividend) || !map.containsKey(divisor)){
                res[i] = -1.0;
            }
            else if(dividend.equals(divisor)){
                res[i] = 1.0;
            }
            else{
                HashSet<String> visited = new HashSet<>();
                res[i] = dfs(dividend, divisor, 1, visited, map);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        // equations = [["a","b"],["b","c"]]
        List<List<String>> equations = List.of(
                List.of("a", "b"),
                List.of("b", "c")
        );

        // values = [2.0, 3.0]
        double[] values = {2.0, 3.0};

        // queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        List<List<String>> queries = List.of(
                List.of("a", "c"),
                List.of("b", "a"),
                List.of("a", "e"),
                List.of("a", "a"),
                List.of("x", "x")
        );

        EvaluateDivision obj = new EvaluateDivision();
        double[] res = obj.calcEquation(equations,values, queries);
        System.out.println(Arrays.toString(res));
    }
}
