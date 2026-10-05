import java.util.Stack;

// https://leetcode.com/problems/score-of-parentheses
public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int score = 0;

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                st.push(score);
                score = 0;
            }
            else {
                // ')'
                if (s.charAt(i-1) == '('){
                    score = st.peek() + 1;
                }
                else {
                    // Nested
                    score = st.peek() + (2*score);
                }
                st.pop();
            }
        }

        return score;
    }

    public static void main(String[] args) {
        ScoreOfParentheses sp = new ScoreOfParentheses();
        String s = "(((())))()";
        System.out.println(sp.scoreOfParentheses(s));
    }
}
