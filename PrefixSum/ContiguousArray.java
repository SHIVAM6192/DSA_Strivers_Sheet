import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contiguous-array
public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        // Convert all 0 to -1
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == 0) nums[i] = -1;

        int sum = 0; // current
        int maxLength = 0; // final-ans

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // put sentinel value

        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                // if present, update the length
                int last = map.get(sum);
                maxLength = Math.max(maxLength, i - last);
            }
            else
                map.put(sum, i);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,1,0,0,0};
        System.out.println(findMaxLength(nums));
    }
}
