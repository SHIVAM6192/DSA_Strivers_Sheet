import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result.toString());
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recures(n, ans, 0, 0, "");
        return ans;
    }

    public static void recures(int n, List<String> ans, int open, int close, String  s ){
        if(s.length() == n * 2){
            ans.add(s);
            return;
        }

        if(open < n){
            recures(n, ans, open + 1, close, s + "(");
        }
        if(close < open){
            recures(n, ans, open, close + 1, s + ")");
        }
    }
}
