import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/description/?envType=problem-list-v2&envId=monotonic-stack
public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }
    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            // remove from the left
            while (!st.isEmpty() && k > 0 && ch < st.peek()){
                st.pop();
                k--;
            }
            st.push(ch);
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()){
            // Remove K elements from right if it doesn't get removed from above for loop
            if (k > 0){
                st.pop();
                k--;
            }
            else {
                // Append at last in string
                sb.insert(0, st.pop());
            }
        }

        // Check for leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }

        // if sb length is zero then return "0" otherwise return 0
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}
