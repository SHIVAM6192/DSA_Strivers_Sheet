import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/distribute-elements-into-two-arrays-i
public class DistributeElementsIntoTwoArraysI {
    public static int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);

        for(int i=2; i<nums.length; i++){
            if(list1.getLast() > list2.getLast()){
                list1.add(nums[i]);
            }
            else{
                list2.add(nums[i]);
            }
        }

        list1.addAll(list2);
        int[] result = list1.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {2,1,3};
        int[] nums2 = {5,4,3,8};
        System.out.println(Arrays.toString(resultArray(nums1)));
        System.out.println(Arrays.toString(resultArray(nums2)));
    }
}
