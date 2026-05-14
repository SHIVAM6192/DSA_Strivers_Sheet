import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/description/
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultset = new ArrayList<>();

        // Start backtracking from the beginning
        backtrack(resultset, new ArrayList<>(), nums, 0);
        return resultset;

    }

    public static void backtrack(List<List<Integer>> resultset, List<Integer> tempSet,
                                 int[] nums, int start){
        // Add the set to result set
        resultset.add(new ArrayList<>(tempSet));
        for(int i = start; i < nums.length; i++){
            // Case of including the number
            tempSet.add(nums[i]);

            // Backtrack the new subset
            backtrack(resultset, tempSet, nums, i + 1);

            // Case of not-including the number
            tempSet.remove(tempSet.size() - 1);
        }

    }
}
