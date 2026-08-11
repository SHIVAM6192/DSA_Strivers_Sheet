import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum
public class SmallestMissingIntegerGreaterThanSequentialPrefixSum  {
    public static int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int n = nums.length;
        int sum = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1] + 1){
                sum += nums[i];
            }
            else{
                break;
            }
        }

        while(set.contains(sum)){
            sum++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,12,14,13};
        System.out.println(missingInteger(nums));
    }
}
