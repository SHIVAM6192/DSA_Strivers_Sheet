import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/partition-array-according-to-given-pivot/description/?envType=daily-question&envId=2026-06-08
public class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        int[] arr = {10,9,12,5,10,14,3,10};
        int[] result = pivotArray(arr, 10);
        System.out.println(Arrays.toString(result));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];

        int i = 0;
        int j = n - 1;

        int left = 0;
        int right = n - 1;

        while (i < n){
            if (nums[i] < pivot){
                ans[left++] = nums[i];
            }

            if (nums[j] > pivot){
                ans[right--] = nums[j];
            }

            i++;
            j--;
        }

        // Remaining middle positions contains pivot
        while (left <= right){
            ans[left] = pivot;
            left++;
        }

        return ans;

    }

//    public static int[] pivotArray(int[] nums, int pivot) {
//        List<Integer> lessPivot = new ArrayList<>();
//        List<Integer> equalPivot = new ArrayList<>();
//        List<Integer> greaterPivot = new ArrayList<>();
//
//        for(int i = 0; i < nums.length; i++){
//            if (nums[i] < pivot){
//                lessPivot.add(nums[i]);
//            }
//            else if(nums[i] == pivot){
//                equalPivot.add(nums[i]);
//            }
//            else {
//                greaterPivot.add(nums[i]);
//            }
//        }
//
//
//        lessPivot.addAll(equalPivot);
//        lessPivot.addAll(greaterPivot);
//
//        for (int i = 0; i < lessPivot.size(); i++){
//            nums[i] = lessPivot.get(i);
//        }
//
//        return nums;
//    }
}
