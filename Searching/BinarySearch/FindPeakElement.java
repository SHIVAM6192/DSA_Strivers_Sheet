package BinarySearch;

// https://leetcode.com/problems/find-peak-element/description/?envType=problem-list-v2&envId=binary-search
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }

    // Here we need to find any peak element and return that index
    // there will be multiple peak element in nums
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return left;
    }
}
