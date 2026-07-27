import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations
public class Permutations {
    public void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempLits, int[] nums){
        // If we match the length then its permutation
        if(tempLits.size() == nums.length){
            resultList.add(new ArrayList<>(tempLits));
            return;
        }

        for(int num : nums){
            // Skip if we get same element
            if(tempLits.contains(num)){
                continue;
            }
            // Add the new element
            tempLits.add(num);
            // Go back to try another element
            backtrack(resultList, tempLits, nums);
            // Remove the element
            tempLits.remove(tempLits.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums);

        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations obj = new Permutations();
        List<List<Integer>> result = obj.permute(nums);
        System.out.println(result);
    }
}
