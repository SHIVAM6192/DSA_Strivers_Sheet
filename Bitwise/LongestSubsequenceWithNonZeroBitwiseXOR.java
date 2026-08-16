// https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor
public class LongestSubsequenceWithNonZeroBitwiseXOR {
    public static int longestSubsequence(int[] nums) {
        int n = nums.length;
        int resultXor = 0;
        boolean allZero = true;

        for(int num : nums){
            resultXor = (resultXor ^ num);

            if(num!=0){
                // We found at least one element which is not zero. So allZero = false
                allZero = false;
            }
        }

        if(allZero){ // We can't take any subsequence
            return 0;
        }

        return (resultXor  == 0) ? n-1 : n;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(longestSubsequence(nums));
    }
}
