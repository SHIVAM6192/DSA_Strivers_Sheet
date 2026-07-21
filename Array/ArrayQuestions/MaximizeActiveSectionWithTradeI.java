package ArrayQuestions;

// https://leetcode.com/problems/maximize-active-section-with-trade-i
public class MaximizeActiveSectionWithTradeI {
    public static int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0, maxSum = 0, prevrun = -1;
        int i = 0;
        while(i<n) {
            if(s.charAt(i) == '1'){
                ones++;
                i++;
            }
            else{
                int curr = 0;
                while(i<n && s.charAt(i) == '0'){
                    curr++;
                    i++;
                }

                if(prevrun > 0){
                    maxSum = Math.max(maxSum, prevrun + curr);
                }
                prevrun = curr;
            }
        }

        return ones + maxSum;
    }
    public static void main(String[] args) {
        String s = "000110010010111001";
        System.out.println(maxActiveSectionsAfterTrade(s));
    }
}
