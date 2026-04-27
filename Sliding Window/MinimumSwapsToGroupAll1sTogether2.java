public class MinimumSwapsToGroupAll1sTogether2 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,1,0,0,1,1,0};
        System.out.println("Minimum number of swaps: " + minSwaps(nums));
    }

    public static int minSwaps(int[] nums) {
        // window size - count of 1's
        int windowSize = 0;
        for(int num : nums){
            if(num == 1) windowSize++;
        }

        // find the zeros in first window
        int curZeros = 0;
        for(int i = 0; i < windowSize; i++){
            if(nums[i] == 0) curZeros++;
        }

        // solve for remaining window
        int minZeros = curZeros;
        int start = 0;
        int end = windowSize - 1;
        int n = nums.length;

        // Window [start to end]
        while(start < n){
            if(nums[start] == 0){
                curZeros--;
            }
            start++;

            end++;
            if(nums[end%n] == 0){ // forming circular array
                curZeros++;
            }
            minZeros = Math.min(minZeros, curZeros);
        }
        return minZeros;  // Number of zeros means number of swaps we need to do to group all 1's together

    }
}
