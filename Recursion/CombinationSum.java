import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {
    Set<List<Integer>> s = new HashSet<>();

    public void getCombinations(int[] arr, int target, int idx, List<List<Integer>> ans, List<Integer> combi){
        if(idx == arr.length || target < 0){
            return;
        }

        if(target == 0){
            if(!s.contains(combi)){
                ans.add(new ArrayList<>(combi));
                s.add(new ArrayList<>(combi));
            }
        }

        // add the num in combination
        combi.add(arr[idx]);

        // call for single num combinations
        // ex. [2] next num will be different num
        getCombinations(arr, target - arr[idx], idx+1, ans, combi);

        // call for multiple num combinations
        // ex. [2, 2] next will be same num
        getCombinations(arr, target - arr[idx], idx, ans, combi);

        // exclude the added num and call again
        combi.remove(combi.size() - 1);
        getCombinations(arr, target, idx + 1, ans, combi);
    }


    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combi = new ArrayList<>();
        getCombinations(arr, target, 0, ans, combi);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> result = cs.combinationSum(arr, target);
        System.out.println(result.toString());
    }
}
