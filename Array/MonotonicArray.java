
// https://leetcode.com/problems/monotonic-array/description/
public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1) return true;

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for(int i = 1; i < nums.length; i++){
            if(!isIncreasing && !isDecreasing){
                return false;
            }

            if(nums[i - 1] < nums[i]){
                isDecreasing = false;
            }
            if(nums[i - 1] > nums[i]){
                isIncreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }

    public static void main(String[] args) {

    }
}
