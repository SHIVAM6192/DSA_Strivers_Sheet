import java.util.Arrays;

// https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings
public class MaximumNestingDepthOfTwoValidParenthesesStrings {
//    public static int[] maxDepthAfterSplit(String s) {
//        int n = s.length();
//        int[] res = new int[n];
//
//        for (int i = 0; i < n; i++)
//            res[i] = (i ^ s.charAt(i)) & 1;
//
//        return res;
//    }

    public static int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int d = 0;

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                d++;
                result[i] = d % 2 == 0 ? 0 : 1;
            } else {
                result[i] = d % 2 == 0 ? 0 : 1;
                d--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String seq = "()(())()";
        System.out.println(Arrays.toString(maxDepthAfterSplit(seq)));
    }
}
