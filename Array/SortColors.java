import java.util.Arrays;

public class SortColors {
    public static void main(String[] args){
        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println(Arrays.toString(sortColors(nums)));
    }

    public static int[] sortColors(int[] nums){
        int low = 0, mid = 0, high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }

        return nums;
    }
}
