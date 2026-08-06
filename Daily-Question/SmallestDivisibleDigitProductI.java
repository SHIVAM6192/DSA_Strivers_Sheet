// https://leetcode.com/problems/smallest-divisible-digit-product-i
public class SmallestDivisibleDigitProductI {
    public static int smallestNumber(int n, int t) {
        int num = n;
        int product = 1;

        while (num != 0){
            int digit = num % 10;
            product = product * digit;
            num = num / 10;
        }
        if (product % t == 0){
            return n;
        }
        else {
            return smallestNumber(n+1, t);
        }
    }
    public static void main(String[] args) {
        System.out.println(smallestNumber(15,3));
    }
}
