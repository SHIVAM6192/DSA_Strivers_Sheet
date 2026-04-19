public class MaximumProductSubarray {

    public static void main(String[] args){
//        int[] nums = {2, 0, 3, -2, 4, 2, 8, 0};
        int[] nums = {0};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int ans = nums[0];
        int leftProduct = 1;
        int rightProduct = 1;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[n - 1 - i];
            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }
        return ans;
    }
}
