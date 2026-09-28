
// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses
public class MaximumNestingDepthOfTheParentheses {
    public static int maxDepth(String s) {
        int maxDepth = Integer.MIN_VALUE;
        int count = 0;

        for (char ch : s.toCharArray()){
            if (ch == '('){
                count++;
                maxDepth = Math.max(maxDepth, count);
            }
            else if(ch == ')'){
                count--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        String s = "(1)+((2))+(((3)))";

        System.out.println(maxDepth(s));
    }
}
