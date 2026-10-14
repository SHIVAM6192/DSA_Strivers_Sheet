// https://leetcode.com/problems/maximize-sum-of-squares-of-digits
public class MaximizeSumOfSquaresOfDigits {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9){
            return "";
        }
        int nines = sum / 9;
        int remain = sum % 9;

        StringBuilder result = new StringBuilder();
        result.repeat("9", Math.max(0, nines));

        if (remain > 0){
            result.append((char) (remain + '0'));
        }

        while (result.length() < num){
            result.append('0');
        }

        return  result.toString();
    }

    public static void main(String[] args) {
        MaximizeSumOfSquaresOfDigits obj = new MaximizeSumOfSquaresOfDigits();
        int num = 2, sum = 4;
        System.out.println(obj.maxSumOfSquares(num, sum));
    }
}
