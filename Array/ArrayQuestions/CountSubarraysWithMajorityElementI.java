package ArrayQuestions;

// https://leetcode.com/problems/count-subarrays-with-majority-element-i/description
public class CountSubarraysWithMajorityElementI {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        int target = 2;
        System.out.println(countMajoritySubarrays(arr, target));
    }
    public static int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int subCount = 0;
        for(int i = 0; i < n; i++){
            int cnt = 0;   // count the target element in subarray
            for(int j = i; j < n; j++){
                if(nums[j] == target){
                    cnt++;
                }
                if(cnt > (j - i + 1)/2){  // if target element is in majority then increase subarray count
                    subCount++;
                }
            }
        }

        return subCount;
    }
}
