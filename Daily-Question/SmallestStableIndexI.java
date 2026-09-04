// https://leetcode.com/problems/smallest-stable-index-i
public class SmallestStableIndexI {
    public static int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] min = new int[n];
        min[n-1] = nums[n-1];

        for(int i = n-2; i>=0; i--){
            min[i] = Math.min(nums[i], min[i + 1]);
        }

        int max = nums[0];
        for(int i = 0; i<n; i++){
            max = Math.max(max, nums[i]);
            int num = max-min[i];
            if(num <= k){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,0,1,4};
        int k = 3;
        System.out.println(firstStableIndex(nums, k));
    }
}
