import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii
public class MinimumNumberOfPushesToTypeWordII {
    public static int minimumPushes(String word) {
        int[] freq = new int[26];

        for(char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int idx = 0;

        for(int i = 25; i >= 0; i--){
            if(freq[i] == 0) continue;

            ans += freq[i] * ((idx/8) + 1);
            idx++;
        }

        return ans;
    }
    public static void main(String[] args) {
        String word = "xyzxyzxyzxyz";
        System.out.println(minimumPushes(word));
    }
}
