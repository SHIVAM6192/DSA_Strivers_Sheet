// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description

public class NumberOfSubstringsContainingAllThreeCharacters {
    public static int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int count = 0;
        int charCount = 0;
        int left = 0;
        int n = s.length();

        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            freq[ch - 'a']++;
            if(freq[ch - 'a']==1){
                charCount++;
            }
            while(charCount == 3){
                count += (n - right);
                char c = s.charAt(left);
                freq[c - 'a']--;
                if(freq[c - 'a'] == 0){
                    charCount--;
                }
                left++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
       String s = "abcabc";
       System.out.println(numberOfSubstrings(s));
    }
}
