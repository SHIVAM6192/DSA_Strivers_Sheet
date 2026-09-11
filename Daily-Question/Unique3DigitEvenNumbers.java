// https://leetcode.com/problems/unique-3-digit-even-numbers
public class Unique3DigitEvenNumbers {
    public static void main(String[] args) {
        int[] digits = {1,2,3,4};
        System.out.println(totalNumbers(digits));

    }
    public static int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int num : digits){
            freq[num]++;
        }
        int count = 0;
        for(int num=100; num<= 999; num++){
            if(num % 2 != 0){
                continue;
            }
            int n = num;
            int a = n % 10;
            n /= 10;
            int b = n % 10;
            n /= 10;
            int c = n % 10;

            int[] need = new int[10];
            need[a]++;
            need[b]++;
            need[c]++;

            boolean possible = true;
            for(int i=0; i<=9; i++){
                if(need[i] > freq[i]){
                    possible = false;
                    break;
                }
            }

            if(possible){
                count++;
            }
        }
        return count;
    }
}
