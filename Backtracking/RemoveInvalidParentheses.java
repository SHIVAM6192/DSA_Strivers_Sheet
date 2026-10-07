import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class RemoveInvalidParentheses {
    private Set<String> st = new HashSet<>();
    private int n;
    private int maxLen;

    public void solve(String s, int i, StringBuilder curr, int count){
        if(count < 0) return;  // Invalid

        if(i == n){
            if(count ==0){
                if(curr.length() > maxLen){  // Found longer valid string
                    maxLen = curr.length();
                    st.clear();
                }
                if(curr.length() == maxLen){
                    st.add(curr.toString());
                }
            }
            return;
        }

        char c = s.charAt(i);
        if(c != '(' && c != ')'){  // Alphabet always keep
            curr.append(c);
            solve(s, i+1, curr, count);
            curr.deleteCharAt(curr.length() - 1);
            return;
        }

        // Do
        curr.append(c);
        // Explore
        solve(s, i+1, curr, count + (c == '(' ? 1 : -1));
        // Un-Do and explore
        curr.deleteCharAt(curr.length() -1);
        solve(s, i+1, curr, count);
    }

    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        maxLen = 0;
        st.clear();

        solve(s, 0, new StringBuilder(), 0);

        return new ArrayList<>(st);
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
        String s = "()())()";
        System.out.println(rip.removeInvalidParentheses(s));
    }
}
