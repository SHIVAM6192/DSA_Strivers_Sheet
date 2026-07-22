import java.util.HashMap;

// https://leetcode.com/problems/longest-palindrome
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : map.values()){
            if (count % 2 == 0){
                length += count;
            }
            else {
                length += count - 1;
                hasOdd = true;
            }
        }

        if (hasOdd){
            length += 1;
        }

        return length;
    }
    public static void main(String[] args) {
        String s = "abccccdd";
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome(s));
    }
}
