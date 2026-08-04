import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/find-missing-elements
public class FindMissingElements {
    public static List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        for (int i = min; i < max; i++){
            if (!set.contains(i)){
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,5};
        System.out.println(findMissingElements(nums));
    }
}
