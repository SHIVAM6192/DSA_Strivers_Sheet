import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum
public class MinimumSwapsToSortByDigitSum {
    private int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private int compareByDigitSum(int num1, int num2){
        int num1DigSum = getDigitSum(num1);
        int num2DigSum = getDigitSum(num2);

        if(num1DigSum != num2DigSum){
            return Integer.compare(num1DigSum, num2DigSum);
        }

        return Integer.compare(num1, num2);
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] afterSort = new Integer[n];
        for(int i=0; i<n; i++){
            afterSort[i] = nums[i];
        }

        Arrays.sort(afterSort, this::compareByDigitSum);
        Map<Integer, Integer> valueToIndex = new HashMap<>();

        for(int i=0; i<n; i++){
            valueToIndex.put(nums[i], i);
        }

        int swapCount = 0;
        for(int i=0; i<n; i++){
            int expectedVal = afterSort[i];
            int currVal = nums[i];

            if(expectedVal == currVal) continue;

            int idx = valueToIndex.get(expectedVal);

            nums[i] = expectedVal;
            nums[idx] = currVal;

            valueToIndex.put(expectedVal, i);
            valueToIndex.put(currVal, idx);

            swapCount++;
        }

        return swapCount;
    }

    public static void main(String[] args) {
        MinimumSwapsToSortByDigitSum obj = new MinimumSwapsToSortByDigitSum();

        int[] nums = {18,43,34,16};

        System.out.println(obj.minSwaps(nums));
    }
}
