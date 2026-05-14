import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<>();
        Arrays.sort(nums); // Sorting is needed
        backtrack(resultSet, new ArrayList<>(), nums, 0);
        return resultSet;
    }

    public static void backtrack(List<List<Integer>> resultSet, List<Integer> tempSet, int[] nums, int start){
        // Check if set is already present then just continue
        if(resultSet.contains(tempSet))
            return;

        resultSet.add(new ArrayList<>(tempSet));
        for(int i = start; i < nums.length; i++){
            // Include
            tempSet.add(nums[i]);

            // Backtrack call with i + 1
            backtrack(resultSet, tempSet, nums, i + 1);

            // Not Include
            tempSet.remove(tempSet.size() - 1);
        }

    }
}
