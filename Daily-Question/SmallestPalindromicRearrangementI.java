import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/smallest-palindromic-rearrangement-i
public class SmallestPalindromicRearrangementI {
    public String smallestPalindrome(String s) {
        // TreeMap keeps characters sorted in ascending order
        Map<Character, Integer> map = new TreeMap<>();

        // Count frequency of each character
        for (char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder firstHalf = new StringBuilder();
        char middleChar = '\0';

        // Build the first half of the palindrome
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();

            // Save the odd frequency character (if any)
            if (freq % 2 == 1){
                middleChar = ch;
            }

            // Add freq/2 copies to the first half
            for (int i = 0; i < freq/2; i++){
                firstHalf.append(ch);
            }
        }
        StringBuilder ans = new StringBuilder();

        // Add the first half
        ans.append(firstHalf);

        // Add the middle character if it exists
        if (middleChar != '\0'){
            ans.append(middleChar);
        }

        // Add the reverse of the first half
        ans.append(new StringBuilder(firstHalf).reverse());

        return ans.toString();
    }
    public static void main(String[] args) {

    }
}
