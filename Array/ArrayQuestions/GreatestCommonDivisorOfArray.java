package ArrayQuestions;

// https://leetcode.com/problems/find-greatest-common-divisor-of-array
public class GreatestCommonDivisorOfArray {
    public static int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return gcd(max, min);
    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,9,10};
        System.out.println(findGCD(nums));
    }
}
