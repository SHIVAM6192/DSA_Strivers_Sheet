package ArrayQuestions;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/description
public class FindMaximumNumberElementsInSubset {
    public static int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        int ones = 0;
        for (int num : nums){
            if (num == 1){
                ones++;
            }
            else {
                freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
            }
        }
        if (ones != 0 && ones % 2 == 0){
            ones--;
        }
        int ans = ones;

        for (Map.Entry<Long, Integer> it : freq.entrySet()){
            long val = it.getKey();
            long base = (long) Math.sqrt(val);

            if ((base * base == val) && freq.containsKey(base) && freq.get(base) > 1){
                continue;
            }

            int count = 0;
            while (freq.containsKey(val) && freq.get(val) > 1){
                count += 2;
                val = val*val;
            }
            if (freq.containsKey(val) && freq.get(val) == 1){
                count++;
            }
            else {
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,1,2,2};
        System.out.println(maximumLength(arr));
    }

}
