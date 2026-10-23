// https://leetcode.com/problems/maximum-k-to-sort-a-permutation
public class MaximumKToSortAPermutation {
    public static int sortPermutation(int[] nums) {
        int n = nums.length;

        int K = -1;

        for(int i=0; i<n; i++){
            if(nums[i] != i){
                K = (K & nums[i]);
            }
        }

        return K == -1 ? 0 : K;
    }

    public static void main(String[] args) {
        int[] nums1 = {0,3,2,1};
        int[] nums2 = {0,1,3,2};
        int[] nums3 = {3,2,1,0};

        System.out.println(sortPermutation(nums1));
        System.out.println(sortPermutation(nums2));
        System.out.println(sortPermutation(nums3));
    }
}
