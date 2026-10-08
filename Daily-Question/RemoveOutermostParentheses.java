// https://leetcode.com/problems/remove-outermost-parentheses
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                if(count != 0)  result.append(c);
                count++;
            }
            else{
                count--;
                if(count != 0) result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses rop = new RemoveOutermostParentheses();
        String s = "(()())(())(()(()))";

        System.out.println(rop.removeOuterParentheses(s));
    }
}
