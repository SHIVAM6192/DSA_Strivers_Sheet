import java.util.Arrays;

// https://leetcode.com/problems/smallest-missing-multiple-of-k
public class SmallestMissingMultipleOfK {
    public static int missingMultiple(int[] nums, int k) {
        int multiple = k;
        Arrays.sort(nums);

        for(int num : nums){
            if(num == multiple){
                multiple += k;
            }
        }

        return multiple;
    }
    public static void main(String[] args) {
        int[] nums = {8,2,3,4,6};
        int k = 2;
        System.out.println(missingMultiple(nums, k));
    }
}
