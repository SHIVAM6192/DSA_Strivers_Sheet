import java.util.Arrays;

// https://leetcode.com/problems/find-the-largest-almost-missing-integer
public class FindTheLargestAlmostMissingInteger {
    public static int largestInteger(int[] nums, int k) {
        int[] count = new int[51];

        for(int i=0; i<=nums.length - k; i++){
            boolean[] seen = new boolean[51];
            // Current subarray: nums[i..i+k-1]
            for(int j=i; j<i+k; j++){
                seen[nums[j]] = true;
            }
            for(int num = 0; num <= 50; num++){
                if(seen[num]){
                    count[num]++;
                }
            }
        }

        for(int num = 50; num >= 0; num--){
            if(count[num] == 1){
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,9,2,1,7};
        int k = 3;
        System.out.println(largestInteger(nums, k));
    }
}
