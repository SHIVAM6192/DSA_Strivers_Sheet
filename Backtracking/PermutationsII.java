import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations-ii
public class PermutationsII {
    public static void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, boolean[] used){
        // If the size of tempList match to the size of nums,
        // then add tempList to resultList and return
        if(tempList.size() == nums.length && !resultList.contains(tempList)){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            // If the element at that index is used then continue
            if (used[i])
                continue;

            // Add the new element
            tempList.add(nums[i]);

            // Make that element used true
            used[i] = true;

            // Go back to try another element
            // Backtracking
            backtrack(resultList, tempList, nums, used);

            // Remove that element from tempList
            tempList.remove(tempList.size() - 1);

            // Make it used false
            used[i] = false;
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums, new boolean[nums.length]);
        return resultList;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        List<List<Integer>> resultList = permuteUnique(nums);
        System.out.println(resultList);
    }
}
