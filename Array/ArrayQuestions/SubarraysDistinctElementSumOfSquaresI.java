package ArrayQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i
public class SubarraysDistinctElementSumOfSquaresI {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sum = 0;

        for(int i=0; i<n; i++){
            Set<Integer> set = new HashSet<>();

            for(int j=i; j<n; j++){
                set.add(nums.get(j));

                int count = set.size();
                sum += count * count;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        SubarraysDistinctElementSumOfSquaresI obj = new SubarraysDistinctElementSumOfSquaresI();
        List<Integer> list = new ArrayList<>(List.of(1, 2, 1));

        System.out.println(obj.sumCounts(list));
    }
}
