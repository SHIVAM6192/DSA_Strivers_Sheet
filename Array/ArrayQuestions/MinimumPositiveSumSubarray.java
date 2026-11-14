package ArrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPositiveSumSubarray {
    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefixSum = new int[n+1];

        for(int i=0; i<n; i++){
            prefixSum[i+1] = prefixSum[i] + nums.get(i);
        }

        int result = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            for(int len = l; len <= r && i+len <= n; len++){
                int j = i+len;
                int sum = prefixSum[j] - prefixSum[i];

                if(sum > 0)
                    result = Math.min(result, sum);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(-2, 2, -3, 1));
        int l = 2, r = 3;

        System.out.println(minimumSumSubarray(nums, l, r));
    }
}
