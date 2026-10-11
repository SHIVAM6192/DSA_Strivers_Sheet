// https://leetcode.com/problems/minimum-sum-of-squared-difference
public class MinimumSumOfSquaredDifference {
    public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        int[] diff = new int[n];
        int maxDiff = 0;
        for(int i=0; i<n; i++){
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        // countDiff[d] = count of indices with diff exactly d
        int[] countDiff = new int[maxDiff + 1];
        for(int d : diff){
            countDiff[d]++;
        }

        long k = (long) k1 + k2;

        for(int currDiff=maxDiff; currDiff > 0 && k > 0; currDiff--){
            int countOps = (int) Math.min(countDiff[currDiff], k);
            countDiff[currDiff] -= countOps;
            countDiff[currDiff-1] += countOps;
            k -= countOps;
        }

        long result = 0;
        for(long d=1; d<=maxDiff; d++){
            result += countDiff[(int)d] * d * d;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,4,10,12};
        int[] nums2 = {5,8,6,9};
        int k1 = 2, k2 = 2;

        System.out.println(minSumSquareDiff(nums1, nums2, k1, k2));
    }
}
