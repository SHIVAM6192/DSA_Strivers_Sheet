package ArrayQuestions;

// https://leetcode.com/problems/majority-element/description/
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }

    // Moore's Algorithm
    public static int majorityElement(int[] nums) {
        int majority = nums[0];
        int votes = 1;

        for (int i = 1; i < nums.length; i++){
            if (votes == 0){
                votes++;
                majority = nums[i];
            }
            else if (nums[i] == majority){
                votes++;
            }
            else {
                votes--;
            }
        }

        return majority;
    }
}
