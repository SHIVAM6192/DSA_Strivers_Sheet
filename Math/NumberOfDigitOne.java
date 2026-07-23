// https://leetcode.com/problems/number-of-digit-one
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int totalCount = 0;

        // factor represents the current digit position
        // 1 -> ones
        // 10 -> tens
        // 100 -> hundreds
        // ...

        long factor = 1;

        while (factor <= n){
            // Digit to the left of the current position
            long high = n / (factor * 10);

            // current digit
            long current = (n/factor) % 10;

            // Digit to the right of current position
            long low = n % factor;

            // Case 1:
            // Current digit is 0
            if (current == 0){
                totalCount += high * factor;
            }
            // Case 2:
            // Current digit is exactly 1
            else if (current == 1){
                totalCount += high * factor + low + 1;
            }
            // Case 3:
            // Current digit is greater than 1
            else {
                totalCount += (high + 1) * factor;
            }

            // Move to next digit position
            factor *= 10;
        }

        return totalCount;
    }

    public static void main(String[] args) {
        NumberOfDigitOne count = new NumberOfDigitOne();
        System.out.println(count.countDigitOne(13));
    }
}
