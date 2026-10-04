import java.util.Stack;

// https://leetcode.com/problems/valid-parenthesis-string
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> openBracket = new Stack<>();
        Stack<Integer> asterisk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                openBracket.push(i);
            }
            else if(ch == '*'){
                asterisk.push(i);
            }
            else{
                // closing bracket
                if(!openBracket.isEmpty()){
                    openBracket.pop();
                }
                else if(!asterisk.isEmpty()){
                    asterisk.pop();
                }
                else{
                    return false;
                }
            }
        }

        while(!openBracket.isEmpty()){
            if(asterisk.isEmpty()){
                return false;
            }
            int openIndex = openBracket.pop();
            int closeIndex = asterisk.pop();

            if(openIndex > closeIndex){
                return false;
            }
        }

        return openBracket.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesisString vps = new ValidParenthesisString();
        // * can be treated as '(' or ')' or ''
        String s = "(**))";

        System.out.println(vps.checkValidString(s));
    }
}
