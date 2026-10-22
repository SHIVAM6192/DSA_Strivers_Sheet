// https://leetcode.com/problems/minimum-operations-to-sort-a-permutation
public class MinimumOperationsToSortAPermutation {
    public static int minOperations(int[] nums) {
        int n = nums.length;

        boolean ascending = true;
        boolean descending = true;

        // Check for circular order
        for(int i=0; i<n; i++){
            int next = (i+1) % n;

            if(nums[next] != (nums[i] + 1) % n){
                ascending = false;
            }

            if(nums[next] != (nums[i] - 1 + n) % n){
                descending = false;
            }
        }

        // find the index of 0
        int p = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                p = i;
                break;
            }
        }

        if(ascending){
            return Math.min(p, n-p + 2);
        }

        if(descending){
            int q = n-1-p;
            return 1 + Math.min(q, n-q);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(minOperations(nums));

        int[] nums1 = {2, 3, 0, 1};
        System.out.println(minOperations(nums1));

        int[] nums2 = {2, 3, 4, 0, 1, 5};
        System.out.println(minOperations(nums2));


    }
}
