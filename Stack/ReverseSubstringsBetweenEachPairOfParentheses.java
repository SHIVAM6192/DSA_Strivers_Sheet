import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses
public class ReverseSubstringsBetweenEachPairOfParentheses {
    public static String reverseParentheses(String s) {
        Deque<Integer> lastSkipLength = new ArrayDeque<>();

        StringBuilder result = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '(') {
                lastSkipLength.push(result.length());
            }
            else if(ch == ')') {
                int l = lastSkipLength.peek();
                lastSkipLength.pop();

                String reversed = new StringBuilder(result.substring(l)).reverse().toString();

                result.replace(l, result.length(), reversed);
            }
            else{
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }
}
