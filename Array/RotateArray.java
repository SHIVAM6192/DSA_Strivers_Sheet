import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }


    public static void reverse(int[] nums, int start, int end){
        while(end > start){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Brute force approach
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length - 1;
//        k = k % nums.length;
//        for(int i = 0; i<k; i++){
//            int temp = nums[n];
//            for(int j = n; j>0; j--){
//                nums[j] = nums[j-1];
//            }
//            nums[0] = temp;
//        }
//    }
}
