public class KadaneAlgorithmMaximumSubarraySum {
    public static void main(String[] args){
        int[] arr = { 5,4,-1,7,8 };
        int ans = maxSubArray(arr);
        System.out.println(ans);
    }

    public static int maxSubArray(int[] nums){
        long max = Long.MIN_VALUE;

        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if(sum > max){
                max = sum;
            }

            if(sum < 0){
                sum = 0;
            }
        }

        return (int) max;
    }
}
