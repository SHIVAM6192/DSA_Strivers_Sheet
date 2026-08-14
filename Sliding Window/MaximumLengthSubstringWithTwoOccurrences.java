// https://leetcode.com/problems/maximum-length-substring-with-two-occurrences
public class MaximumLengthSubstringWithTwoOccurrences {
    public static int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'a']++;
            while (freq[s.charAt(right) - 'a'] > 2){
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "bcbbbcba";
        System.out.println(maximumLengthSubstring(s));
    }
}
