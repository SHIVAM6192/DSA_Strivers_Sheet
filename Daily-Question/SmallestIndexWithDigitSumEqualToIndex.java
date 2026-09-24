// https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index
public class SmallestIndexWithDigitSumEqualToIndex {
    public static int smallestIndex(int[] nums) {
        int smallestIndex = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i=0; i<n; i++){
            int num = nums[i];
            int sum = 0;

            while(num > 0){
                sum += num % 10;
                num /= 10;
            }

            if(sum == i)
                smallestIndex = Math.min(smallestIndex, i);
        }

        return smallestIndex == Integer.MAX_VALUE ? -1 : smallestIndex;
    }

    public static void main(String[] args) {
        int[] nums ={256,234,957,777,430,907,63,105,162,271,10};
        System.out.println(smallestIndex(nums));
    }
}
