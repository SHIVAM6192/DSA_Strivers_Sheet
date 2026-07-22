import java.util.Arrays;

// https://leetcode.com/problems/largest-number
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        if (arr[0].equals("0")){
            return "0";
        }

        StringBuilder largest = new StringBuilder();
        for (String s : arr) {
            largest.append(s);
        }
        return largest.toString();
    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int[] nums1 = {10,2};
        System.out.println("Largest Number: " + ln.largestNumber(nums1));
        int[] nums2 = {3,30,34,5,9};
        System.out.println("Largest Number: " + ln.largestNumber(nums2));
    }
}
