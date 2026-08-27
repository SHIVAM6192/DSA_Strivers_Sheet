// https://leetcode.com/problems/sum-game
public class SumGame {
    public static boolean sumGame(String num) {
        int n = num.length();
        int half = n/2;
        int leftSum = 0;
        int rightSum = 0;
        int qLeft = 0;
        int qRight = 0;

        for(int i = 0; i < half; i++){
            if(num.charAt(i) == '?'){
                qLeft++;
            }
            else{
                leftSum += num.charAt(i) - '0';
            }
        }

        for(int i = half; i < n; i++){
            if(num.charAt(i) == '?'){
                qRight++;
            }
            else{
                rightSum += num.charAt(i) - '0';
            }
        }

        if(qLeft == qRight){
            return leftSum != rightSum;
        }

        return 2 * (leftSum - rightSum) != 9 * (qRight - qLeft);
    }

    public static void main(String[] args) {
        String num1 = "25??";
        String num2 = "?3295???";

        System.out.println(sumGame(num1) ? "Alice win." : "Bob win.");
        System.out.println(sumGame(num2) ? "Alice win." : "Bob win.");
    }
}
