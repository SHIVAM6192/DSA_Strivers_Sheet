package ArrayQuestions;

// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum
public class NumberOfSubArraysWithOddSum {
    static int MOD = 1_000_000_007;

    // Brute Force approach
//    public static void generateSubArray(int[] arr, int start, int end, int sum){
//        if (start == arr.length)
//            return;
//
//        if (end == arr.length){
//            generateSubArray(arr, start+1, start+1, 0);
//            return;
//        }
//
//        sum += arr[end];
//
//        if (sum % 2 != 0){
//            count = (count + 1) % MOD;
//        }
//
//        generateSubArray(arr, start, end+1, sum);
//    }
//
//    public static int numOfSubarrays(int[] arr) {
//        count = 0;
//        generateSubArray(arr, 0, 0, 0);
//        return count % MOD;
//    }

    // Optimal Approach

    public static int numOfSubarrays(int[] arr){
        int count = 0;
        int sum = 0;
        int even = 1;
        int odd = 0;

        for (int num : arr){
            sum += num;
            if (sum % 2 == 0){
                count = (count + odd) % MOD;
                even++;
            }
            else {
                count = (count + even) % MOD;
                odd++;
            }

            even %= MOD;
            odd %= MOD;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5};
        System.out.println(numOfSubarrays(arr));
    }
}
